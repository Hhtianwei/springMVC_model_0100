package com.tim.spring.security.salt;

import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

import com.tim.spring.util.MD5Util;


public class MySaltSourceImpl implements SaltSource
{

	public Object getSalt(UserDetails userdetails)
	{
		String source = userdetails.getUsername();
		return MD5Util.MD5(source);
	}

}
