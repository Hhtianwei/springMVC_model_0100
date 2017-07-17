package com.tim.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginPageController
{

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
				System.out.println("password error");
			}
			if (loginException instanceof UsernameNotFoundException)
			{
				errorMsg = "user name is not found";
				System.out.println("user name is not found");
			}
			model.addAttribute("errorMsg", errorMsg);
			System.out.println(loginException.getClass());
		}
		return "login/login";
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public String testGet(String filePath, Model model, HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		System.out.println("请求参数：" + name);
		return name + ",你好";
	}

	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	@ResponseBody
	public String testPost(String filePath, Model model, HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		System.out.println("请求参数：" + name);
		return name + ",你好";
	}
}
