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
		 * jar 版本  quartz-all-1.6.1.jar
		 */
		//  新建一个定时任务处理类 jobDetail
		//JobDetail jobDetail = new JobDetail("quartzTimer","quartzTimerGroup" , QuartzTimer.class);
		
		// 创建定时器触发器
		/*SimpleTrigger simpleTrigger = new SimpleTrigger("quartzTimerTrigger", "quartzTimerTriggerGroup");
		//  什么时间点执行      new Date()立即启动
		simpleTrigger.setStartTime(new Date());
		// 执行多少次    10 次
		simpleTrigger.setRepeatCount(10);
		//  每隔多少秒执行一次   1000是代表1秒
		simpleTrigger.setRepeatInterval(1000);*/
		
		// 表达式的触发器   两个触发器只需要一个就好了。
		/*CronTrigger cronTrigger = new CronTrigger("quartzTimerCronTrigger", "quartzTimerCronTriggerGroup");
		// 新建一个表达式
		CronExpression cronExpression = new CronExpression("0/5 32/1 0-23 * * ? *");
		// 将表达式放入 触发器
		cronTrigger.setCronExpression(cronExpression);
		
		//  新建一个计划共工厂
		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		//  获取到一个计划任务
		Scheduler scheduler = stdSchedulerFactory.getScheduler();
		//  将定时器任务处理类和触发器结合在一起
		scheduler.scheduleJob(jobDetail, cronTrigger);
		// 启动触发器
		scheduler.start();*/
		
		
		//quartz 2.X版本以上做法 ++++++++++++++++++++++++++++++++++++++++++++++++
		/**
		 * quartz-2.2.3-distribution(quartz-2.2.3、quartz-jobs-2.2.3)
		 */
		// 通过 schedulerFactory 获取一个调度器
        /*SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        // 创建 jobDetail 实例，绑定 Job 实现类
        // 指明 job 的名称，所在组的名称，以及绑定 job 类
        JobDetail job = JobBuilder.newJob(QuartzTimer.class).withIdentity("job1", "group1").build();

        // 定义调度触发规则

        // SimpleTrigger，从当前时间的下 1 秒开始，每隔 1 秒执行 1 次，重复执行 2 次
        Trigger trigger = TriggerBuilder.newTrigger()
                // 指明 trigger 的 name 和 group
                .withIdentity("trigger1", "group1")
                // 从当前时间的下 1 秒开始执行，默认为立即开始执行（.startNow()）
                .startAt(DateBuilder.evenSecondDate(new Date()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1) // 每隔 1 秒执行 1 次
                        .withRepeatCount(2)) // 重复执行 2 次，一共执行 3 次
                .build();


        // corn 表达式，先立即执行一次，然后每隔 5 秒执行 1 次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*\/5 * * * * ?"))
                .build();


        // 把作业和触发器注册到任务调度中
        sched.scheduleJob(job, trigger);

        // 启动计划程序（实际上直到调度器已经启动才会开始运行）
        sched.start();

        // 等待 10 秒，使我们的 job 有机会执行
        //Thread.sleep(10000);

        // 等待作业执行完成时才关闭调度器
        //sched.shutdown(true);
		*/
	}
}
