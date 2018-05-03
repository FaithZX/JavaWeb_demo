package com.timer2;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartzTimer {

	
	public static void main(String[] args) throws SchedulerException {
		//  新建一个定时任务处理类 jobDetail
		/*JobDetail jobDetail = new JobDetail("quartzTimer","quartzTimerGroup" , QuartzTimer.class);
		
		// 创建定时器触发器
		SimpleTrigger simpleTrigger = new SimpleTrigger("quartzTimerTrigger", "quartzTimerTriggerGroup");
		//  什么时间点执行      new Date()立即启动
		simpleTrigger.setStartTime(new Date());
		// 执行多少次    10 次
		simpleTrigger.setRepeatCount(10);
		//  每隔多少秒执行一次   1000是代表1秒
		simpleTrigger.setRepeatInterval(1000);
		
		//  新建一个计划共工厂
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		//  获取到一个计划任务
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		//  将定时器任务处理类和触发器结合在一起
		scheduler.scheduleJob(jobDetail, simpleTrigger);
		// 启动触发器
		scheduler.start();*/
		
	}
}
