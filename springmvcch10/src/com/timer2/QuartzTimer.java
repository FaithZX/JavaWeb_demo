package com.timer2;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * ��ʱ����
 * @author Administrator
 */
public class QuartzTimer implements Job {

	int a = 1;
	
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("�ҵ�quartz��ʱ����" +  new Date() + "     " + a++);

	}

}
