package com.timer4;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时任务
 * @author Administrator
 */
public class QuartzTimer extends QuartzJobBean  {
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("我的Spring管理quartz定时任务" +  new Date());
		
	}

}
