package com.tim.spring.filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;


public class MyMultipartFilter extends MultipartFilter
{


	@Override
	protected MultipartResolver lookupMultipartResolver()
	{
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		String beanName = getMultipartResolverBeanName();
		if (wac != null && wac.containsBean(beanName))
		{
			if (logger.isDebugEnabled())
				logger.debug((new StringBuilder()).append("Using MultipartResolver '").append(beanName)
						.append("' for MultipartFilter").toString());
			MultipartResolver r = (MultipartResolver) wac.getBean(beanName, MultipartResolver.class);
			System.out.println("MultipartResolver:" + r.getClass());
			return r;
		}
		else
		{
			System.out.println("lookupMultipartResolver default");
		}

		return super.lookupMultipartResolver();
	}
}
