package com.tim.spring.service.device;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceResolver;

import com.tim.spring.device.data.DeviceData;


public class DeviceService
{
	private DeviceData deviceData;
	private DeviceResolver deviceResolver;

	public DeviceService()
	{
		deviceData = new DeviceData();
	}

	public DeviceData getCurrentDeviceData(HttpServletRequest request)
	{
		Device device = deviceResolver.resolveDevice(request);
		deviceData.setUserAgent(request.getHeader("User-Agent"));
		deviceData.setDesktopBrowser(Boolean.valueOf(device.isNormal()));
		deviceData.setTabletBrowser(Boolean.valueOf(device.isTablet()));
		deviceData.setMobileBrowser(Boolean.valueOf(device.isMobile()));
		return deviceData;
	}

	public DeviceData getDeviceData()
	{
		return deviceData;
	}

	public DeviceResolver getDeviceResolver()
	{
		return deviceResolver;
	}

	public void setDeviceResolver(DeviceResolver deviceResolver)
	{
		this.deviceResolver = deviceResolver;
	}

}
