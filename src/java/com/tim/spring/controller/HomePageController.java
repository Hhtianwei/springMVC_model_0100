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

import com.tim.spring.device.data.DeviceData;
import com.tim.spring.service.device.DeviceService;


@Controller
@RequestMapping("/")
public class HomePageController
{
	private static final Logger LOG = Logger.getLogger(HomePageController.class);

	@Resource
	private MessageSource messageSource;

	@Resource
	private DeviceService deviceService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		LOG.info("loading home/index.jsp page...");
		String message = messageSource.getMessage("first.message", null, Locale.CHINA);
		LOG.info("test i18n file message:" + message);
		String userName = (String) request.getSession().getAttribute("userName");
		LOG.info("index page userName-------------------" + userName + "----");

		//设备类型
		DeviceData deviceData = deviceService.getDeviceData();
		LOG.info("device type:Agent:" + deviceData.getUserAgent() + ", Mobile:" + deviceData.getMobileBrowser() + ",Desktop:"
				+ deviceData.getDesktopBrowser() + ",Tablet:" + deviceData.getTabletBrowser());
		return "home/index";
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public String testGet(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("name");
		LOG.info("请求参数：" + name);
		if (name.length() < 100)
		{
			throw new NullPointerException("这是我做测试专门抛出的异常");
		}

		return name + ",你好";
	}

	@RequestMapping(value = "/testHello", method = RequestMethod.GET)
	public String testHello(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("message", "this is a test message");
		LOG.info("test get method ");
		return "test/test01";
	}
}
