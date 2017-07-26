package com.tim.spring.device.data;

public class DeviceData
{
	private Boolean tabletBrowser;
	private String userAgent;
	private Boolean desktopBrowser;
	private Boolean mobileBrowser;

	public Boolean getTabletBrowser()
	{
		return tabletBrowser;
	}

	public void setTabletBrowser(Boolean tabletBrowser)
	{
		this.tabletBrowser = tabletBrowser;
	}

	public String getUserAgent()
	{
		return userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}

	public Boolean getDesktopBrowser()
	{
		return desktopBrowser;
	}

	public void setDesktopBrowser(Boolean desktopBrowser)
	{
		this.desktopBrowser = desktopBrowser;
	}

	public Boolean getMobileBrowser()
	{
		return mobileBrowser;
	}

	public void setMobileBrowser(Boolean mobileBrowser)
	{
		this.mobileBrowser = mobileBrowser;
	}

}
