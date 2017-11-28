package com.tim.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tim.spring.data.Pagination;
import com.tim.spring.data.SearchResult;
import com.tim.spring.model.UserModel;
import com.tim.spring.security.exception.AttackSystemException;
import com.tim.spring.security.exception.SMSErrorAuthenticationexception;
import com.tim.spring.service.UserService;


@Controller
public class LoginPageController
{

	private static final Logger LOG = Logger.getLogger(LoginPageController.class);
	@Resource(name = "userService")
	private UserService userService;

	@Resource
	private MessageSource messageSource;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String testGet(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "error", defaultValue = "false") final boolean loginError, Model model)
	{
		if (loginError)
		{
			AuthenticationException loginException = (AuthenticationException) request.getSession()
					.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
			String errorMsg = "";
			if (loginException instanceof BadCredentialsException)
			{
				errorMsg = "password error";
				String name = request.getParameter("uname");
				LOG.error(String.format("user[%s] password error", name));
			}
			if (loginException instanceof UsernameNotFoundException)
			{
				errorMsg = "user name is not found";
				String name = request.getParameter("uname");
				LOG.error(String.format("user[%s] name is not found", name));
			}
			if (loginException instanceof AttackSystemException)
			{
				errorMsg = "user attack system,can't login";
				String name = request.getParameter("uname");
				LOG.error(String.format("user[%s] attack system,can't login", name));
			}
			if (loginException instanceof SMSErrorAuthenticationexception)
			{
				errorMsg = loginException.getMessage();
				String mobile = request.getParameter("mobile");
				LOG.error(String.format("user[%s] sms code error,can't login", mobile));
			}
			model.addAttribute("errorMsg", errorMsg);
		}

		String x1 = messageSource.getMessage("first.message", null, "default1", Locale.CHINA);
		LOG.info("test i18n message:" + x1);
		return "login/login";
	}

	@RequestMapping(value = "/logoutsystem", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		LOG.info("---user logout-----");
		return "login/logout";
	}

	@RequestMapping(value = "/addUsers", method = RequestMethod.GET)
	public void addUser(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("start add users....");
		String number = request.getParameter("number");
		userService.addUsers(Integer.parseInt(number));
		System.out.println("end add users....");
	}

	/**
	 * 查询所有用户
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		List<UserModel> list = userService.findAllUser();
		model.addAttribute("users", list);
		return "users/userlist";
	}

	/**
	 * 查询 某个用户
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userListWithPagination2", method = RequestMethod.GET)
	public String userListWithPagination2(@RequestParam(value = "name", defaultValue = "name") final String currentPage,
			Model model, HttpServletRequest request, HttpServletResponse response)
	{

		//model.addAttribute("searchResult", searchResult);
		return "users/userlistwithpagination";
	}

	/**
	 * 查询所有用户 分页
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userListWithPagination", method = RequestMethod.GET)
	public String userListWithPagination(@RequestParam(value = "currentPage", defaultValue = "1") final int currentPage,
			Model model, HttpServletRequest request, HttpServletResponse response)
	{
		Pagination page = new Pagination();
		page.setCurrentPage(currentPage);
		page.setPageSize(3);
		SearchResult<UserModel> searchResult = userService.findUserByPagination(page);
		model.addAttribute("searchResult", searchResult);
		return "users/userlistwithpagination";
	}
}
