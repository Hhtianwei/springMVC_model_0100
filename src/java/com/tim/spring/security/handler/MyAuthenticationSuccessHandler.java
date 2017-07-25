package com.tim.spring.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.tim.spring.security.impl.DefaultBruteForceAttackCounter;


public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
	private static final Logger LOG = Logger.getLogger(MyAuthenticationFailureHandler.class);

	private DefaultBruteForceAttackCounter bruteForceAttackCounter;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException
	{
		LOG.info("my MyAuthenticationSuccessHandler invoke...");
		String userName = request.getParameter("uname");
		bruteForceAttackCounter.removeLoginFailureUser(userName);

		//TODO save userInfo to session 
		request.getSession().setAttribute("userName", userName);

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
