package com.tim.spring.common.listener;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;


public class PropertiesFileAlterationListener implements FileAlterationListener
{

	private Logger log = Logger.getLogger(PropertiesFileAlterationListener.class);

	/**
	 * 文件创建执行
	 */
	@Override
	public void onFileCreate(File file)
	{
		log.info("[新建]:" + file.getAbsolutePath());
	}

	/**
	 * 文件创建修改
	 */
	@Override
	public void onFileChange(File file)
	{
		log.info("[修改]:" + file.getAbsolutePath());
	}

	/**
	 * 文件删除
	 */
	@Override
	public void onFileDelete(File file)
	{
		log.info("[删除]:" + file.getAbsolutePath());
	}

	/**
	 * 目录创建
	 */
	@Override
	public void onDirectoryCreate(File directory)
	{
		log.info("[新建]:" + directory.getAbsolutePath());
	}

	/**
	 * 目录修改
	 */
	@Override
	public void onDirectoryChange(File directory)
	{
		log.info("[修改]:" + directory.getAbsolutePath());
	}

	/**
	 * 目录删除
	 */
	@Override
	public void onDirectoryDelete(File directory)
	{
		log.info("[删除]:" + directory.getAbsolutePath());
	}

	@Override
	public void onStart(FileAlterationObserver observer)
	{
		log.debug("start");
	}

	@Override
	public void onStop(FileAlterationObserver observer)
	{
		log.debug("stop");
	}

}
