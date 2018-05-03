package com.timer3;

import java.text.ParseException;
import java.util.Date;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartzTimer {
	
	public static void main(String[] args) throws SchedulerException, ParseException {
		/**
		 * jar �汾  quartz-all-1.6.1.jar
		 */
		//  �½�һ����ʱ�������� jobDetail
		//JobDetail jobDetail = new JobDetail("quartzTimer","quartzTimerGroup" , QuartzTimer.class);
		
		// ������ʱ��������
		/*SimpleTrigger simpleTrigger = new SimpleTrigger("quartzTimerTrigger", "quartzTimerTriggerGroup");
		//  ʲôʱ���ִ��      new Date()��������
		simpleTrigger.setStartTime(new Date());
		// ִ�ж��ٴ�    10 ��
		simpleTrigger.setRepeatCount(10);
		//  ÿ��������ִ��һ��   1000�Ǵ���1��
		simpleTrigger.setRepeatInterval(1000);*/
		
		// ���ʽ�Ĵ�����   ����������ֻ��Ҫһ���ͺ��ˡ�
		/*CronTrigger cronTrigger = new CronTrigger("quartzTimerCronTrigger", "quartzTimerCronTriggerGroup");
		// �½�һ�����ʽ
		CronExpression cronExpression = new CronExpression("0/5 32/1 0-23 * * ? *");
		// �����ʽ���� ������
		cronTrigger.setCronExpression(cronExpression);
		
		//  �½�һ���ƻ�������
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		//  ��ȡ��һ���ƻ�����
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		//  ����ʱ����������ʹ����������һ��
		scheduler.scheduleJob(jobDetail, cronTrigger);
		// ����������
		scheduler.start();*/
		
		
		//quartz 2.X�汾�������� ++++++++++++++++++++++++++++++++++++++++++++++++
		/**
		 * quartz-2.2.3-distribution(quartz-2.2.3��quartz-jobs-2.2.3)
		 */
		// ͨ�� schedulerFactory ��ȡһ��������
        /*SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // ���� jobDetail ʵ������ Job ʵ����
        // ָ�� job �����ƣ�����������ƣ��Լ��� job ��
        JobDetail job = JobBuilder.newJob(QuartzTimer.class).withIdentity("job1", "group1").build();

        // ������ȴ�������

        // SimpleTrigger���ӵ�ǰʱ����� 1 �뿪ʼ��ÿ�� 1 ��ִ�� 1 �Σ��ظ�ִ�� 2 ��
        Trigger trigger = TriggerBuilder.newTrigger()
                // ָ�� trigger �� name �� group
                .withIdentity("trigger1", "group1")
                // �ӵ�ǰʱ����� 1 �뿪ʼִ�У�Ĭ��Ϊ������ʼִ�У�.startNow()��
                .startAt(DateBuilder.evenSecondDate(new Date()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1) // ÿ�� 1 ��ִ�� 1 ��
                        .withRepeatCount(2)) // �ظ�ִ�� 2 �Σ�һ��ִ�� 3 ��
                .build();


        // corn ���ʽ��������ִ��һ�Σ�Ȼ��ÿ�� 5 ��ִ�� 1 ��
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*\/5 * * * * ?"))
                .build();


        // ����ҵ�ʹ�����ע�ᵽ���������
        sched.scheduleJob(job, trigger);

        // �����ƻ�����ʵ����ֱ���������Ѿ������ŻῪʼ���У�
        sched.start();

        // �ȴ� 10 �룬ʹ���ǵ� job �л���ִ��
        //Thread.sleep(10000);

        // �ȴ���ҵִ�����ʱ�Źرյ�����
        //sched.shutdown(true);
		*/
	}
}
