package com.tim.spring.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class HomePageController
{
	private static final Logger LOG = Logger.getLogger(HomePageController.class);

	@Resource
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		LOG.info("loading home/index.jsp page...");
		String message = messageSource.getMessage("first.message", null, Locale.CHINA);
		LOG.info("test i18n file message:" + message);
		return "home/index";
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public String testGet(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		LOG.info("请求参数：" + name);
		return name + ",你好";
	}
}
