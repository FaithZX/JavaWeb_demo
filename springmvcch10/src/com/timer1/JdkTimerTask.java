package com.timer1;

import java.util.Date;
import java.util.TimerTask;
/**
 * jdk自带的定时器   不需要引入任何的jar  
 * @author Administrator
 */
public class JdkTimerTask extends TimerTask {
	int a = 1;
	@Override
	public void run() {
		System.out.println("我的定时任务    " + new Date() + "     " + a++ );
	}
}
