package com.tim.spring.common.monitor;

import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.tim.spring.common.filter.WatchedPropertiesFileFilter;
import com.tim.spring.common.listener.PropertiesFileAlterationListener;


public class MyFileAlterationMonitor
{
	private FileAlterationListener listener = new PropertiesFileAlterationListener();

	private FileFilter fileWatchfilter = new WatchedPropertiesFileFilter();

	// 监控目录    
	private String watchedPath = "D:\\upload";

	public void init() throws Exception
	{
		// 轮询间隔 5 秒    
		long interval = TimeUnit.SECONDS.toMillis(5);

		System.out.println("watchedPath:" + watchedPath);
		// 创建一个文件观察器用于处理文件的格式    
		FileAlterationObserver observer = new FileAlterationObserver(watchedPath, fileWatchfilter);

		observer.addListener(listener); //设置文件变化监听器    
		//创建文件变化监听器    
		FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
		// 开始监控    
		monitor.start();
	}

	public void setListener(FileAlterationListener listener)
	{
		this.listener = listener;
	}

	public FileAlterationListener getListener()
	{
		return listener;
	}


	public FileFilter getFileWatchfilter()
	{
		return fileWatchfilter;
	}


	public void setFileWatchfilter(FileFilter fileWatchfilter)
	{
		this.fileWatchfilter = fileWatchfilter;
	}


	public String getWatchedPath()
	{
		return watchedPath;
	}


	public void setWatchedPath(String watchedPath)
	{
		this.watchedPath = watchedPath;
	}


}
