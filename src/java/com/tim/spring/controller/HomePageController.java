package com.tim.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	/**
	 * 测试spring security 权限管理
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testHello2", method = RequestMethod.GET)
	public String testHello2(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("message", "拥有user权限可以访问");
		LOG.info("test get method ");
		return "test/test02";
	}

	/**
	 * 测试spring security 权限管理
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testHello3", method = RequestMethod.GET)
	public String testHello3(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("message", "拥有admin权限可以访问");
		LOG.info("test get method ");
		return "test/test03";
	}

	/**
	 * 测试文件上传
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/testUpload", method = RequestMethod.GET)
	public String testUpload(Model model, HttpServletRequest request, HttpServletResponse response)
	{
		model.addAttribute("message", "拥有admin权限可以访问");
		LOG.info("test file upload method ");
		return "test/fileUpload";
	}

	@RequestMapping(value = "/testUpload", method = RequestMethod.POST)
	@ResponseBody
	public String testUploadPost(Model model, @RequestParam("name") String name, @RequestParam("myFile") List<MultipartFile> files)
			throws IOException
	{//@RequestParam("file") Part file

		for (MultipartFile file : files)
		{
			String fileName = file.getOriginalFilename();
			String basePath = "D:" + File.separator + "testFile" + File.separator;
			File tempFile = new File(basePath + fileName);
			OutputStream output = new FileOutputStream(tempFile);
			byte[] t = file.getBytes();
			output.write(t);
			output.flush();
			output.close();
			LOG.info(String.format("test upload file,file Name is %s ", fileName));
		}
		return "success";
	}
}
