package com.timer2;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartzTimer {

	
	public static void main(String[] args) throws SchedulerException {
		//  �½�һ����ʱ�������� jobDetail
		/*JobDetail jobDetail = new JobDetail("quartzTimer","quartzTimerGroup" , QuartzTimer.class);
		
		// ������ʱ��������
		SimpleTrigger simpleTrigger = new SimpleTrigger("quartzTimerTrigger", "quartzTimerTriggerGroup");
		//  ʲôʱ���ִ��      new Date()��������
		simpleTrigger.setStartTime(new Date());
		// ִ�ж��ٴ�    10 ��
		simpleTrigger.setRepeatCount(10);
		//  ÿ��������ִ��һ��   1000�Ǵ���1��
		simpleTrigger.setRepeatInterval(1000);
		
		//  �½�һ���ƻ�������
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		//  ��ȡ��һ���ƻ�����
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		//  ����ʱ����������ʹ����������һ��
		scheduler.scheduleJob(jobDetail, simpleTrigger);
		// ����������
		scheduler.start();*/
		
	}
}
