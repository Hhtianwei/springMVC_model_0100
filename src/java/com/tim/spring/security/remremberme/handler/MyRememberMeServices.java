package com.tim.spring.security.remremberme.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;


public class MyRememberMeServices extends TokenBasedRememberMeServices
{
	private static final Logger LOG = Logger.getLogger(MyRememberMeServices.class);

	public MyRememberMeServices(String key, UserDetailsService userDetailsService)
	{
		super(key, userDetailsService);
	}

	@Override
	protected UserDetails processAutoLoginCookie(String cookieTokens[], HttpServletRequest request, HttpServletResponse response)
	{
		UserDetails user = super.processAutoLoginCookie(cookieTokens, request, response);
		HttpSession session = request.getSession();
		session.setAttribute("userName", user.getUsername());
		LOG.info("-----MyRememberMeServices-----user-----------" + user.getUsername() + "--------------------");
		return user;
	}

}
