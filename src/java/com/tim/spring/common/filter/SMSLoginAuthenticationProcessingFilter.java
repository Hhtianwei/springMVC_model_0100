package com.tim.spring.common.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tim.spring.security.exception.SMSErrorAuthenticationexception;


public class SMSLoginAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter
{

	public static final String SPRING_SECURITY_MOBILE_KEY = "mobile";
	public static final String SPRING_SECURITY_SMSCODE_KEY = "smsCode";

	private static final String SMSCODE = "smsCode";


	private String mobileParameter;
	private String smsCodeParameter;
	private boolean postOnly;

	protected SMSLoginAuthenticationProcessingFilter()
	{
		super(new AntPathRequestMatcher("/smsLogin", "POST"));
		mobileParameter = SPRING_SECURITY_MOBILE_KEY;
		smsCodeParameter = SPRING_SECURITY_SMSCODE_KEY;
		postOnly = true;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException
	{

		if (postOnly && !request.getMethod().equals("POST"))
			throw new AuthenticationServiceException(
					(new StringBuilder()).append("Authentication method not supported: ").append(request.getMethod()).toString());

		String mobile = request.getParameter(mobileParameter);
		String smsCode = request.getParameter(smsCodeParameter);
		if (mobile == null)
			mobile = "";
		mobile = mobile.trim();
		if (smsCode == null)
			smsCode = "";
		smsCode = smsCode.trim();
		HttpSession session = request.getSession();
		String sessionSmsCode = (String) session.getAttribute(SMSCODE);
		if (!smsCode.equalsIgnoreCase(sessionSmsCode))
		{
			getFailureHandler().onAuthenticationFailure(request, response, new SMSErrorAuthenticationexception("手机验证码不正确"));
			return null;
		}

		SMSCodeAuthenticationToken authRequest = new SMSCodeAuthenticationToken(mobile);
		setDetails(request, authRequest);
		return getAuthenticationManager().authenticate(authRequest);
	}

	protected void setDetails(HttpServletRequest request, SMSCodeAuthenticationToken authRequest)
	{
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	public void setPostOnly(boolean postOnly)
	{
		this.postOnly = postOnly;
	}

	public String getMobileParameter()
	{
		return mobileParameter;
	}

	public void setMobileParameter(String mobileParameter)
	{
		this.mobileParameter = mobileParameter;
	}

	public String getSmsCodeParameter()
	{
		return smsCodeParameter;
	}

	public void setSmsCodeParameter(String smsCodeParameter)
	{
		this.smsCodeParameter = smsCodeParameter;
	}


}
