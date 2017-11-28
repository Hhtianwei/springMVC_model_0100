package com.tim.spring.security.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.tim.spring.security.impl.DefaultBruteForceAttackCounter;


public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
	private static final Logger LOG = Logger.getLogger(MyAuthenticationSuccessHandler.class);

	private DefaultBruteForceAttackCounter bruteForceAttackCounter;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException
	{
		String name = authentication.getName();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> iter = authorities.iterator();
		while (iter.hasNext())
		{
			LOG.info("------name：" + name + ",auth:" + iter.next() + "--------------------");
		}

		LOG.info("my MyAuthenticationSuccessHandler invoke...userName is :" + name);
		bruteForceAttackCounter.removeLoginFailureUser(name);

		//TODO save userInfo to session 
		request.getSession().setAttribute("userName", name);

		super.onAuthenticationSuccess(request, response, authentication);
	}

	public DefaultBruteForceAttackCounter getBruteForceAttackCounter()
	{
		return bruteForceAttackCounter;
	}

	public void setBruteForceAttackCounter(DefaultBruteForceAttackCounter bruteForceAttackCounter)
	{
		this.bruteForceAttackCounter = bruteForceAttackCounter;
	}

}
