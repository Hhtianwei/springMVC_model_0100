package com.tim.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.tim.spring.service.device.DeviceService;


public class DefaultInterceptor implements HandlerInterceptor
{
	private static final Logger LOG = Logger.getLogger(DefaultInterceptor.class);
	private DeviceService deviceService;


	public DeviceService getDeviceService()
	{
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService)
	{
		this.deviceService = deviceService;
	}

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj)
			throws Exception
	{
		LOG.info("--------invoke spring MVC interceptor-----------------");
		//每次处理过来请求，都获取一下请求的设备
		deviceService.getCurrentDeviceData(httpservletrequest);
		//返回false 就会把这个请求拦截
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj,
			Exception exception) throws Exception
	{

	}

}
