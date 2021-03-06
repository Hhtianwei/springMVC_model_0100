package com.tim.spring.common.filter;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.lang.StringUtils;


public class WatchedPropertiesFileFilter implements FileFilter
{

	@Override
	public boolean accept(File file)
	{
		if (!file.isFile())
		{
			return false;
		}

		String fielName = file.getName();
		return StringUtils.equals(fielName, "a.txt");
	}

}
