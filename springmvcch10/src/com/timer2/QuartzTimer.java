package com.timer2;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务
 * @author Administrator
 */
public class QuartzTimer implements Job {

	int a = 1;
	
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("我的quartz定时任务" +  new Date() + "     " + a++);

	}

}
