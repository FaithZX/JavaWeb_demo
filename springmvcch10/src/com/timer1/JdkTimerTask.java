package com.timer1;

import java.util.Date;
import java.util.TimerTask;
/**
 * jdk�Դ��Ķ�ʱ��   ����Ҫ�����κε�jar  
 * @author Administrator
 */
public class JdkTimerTask extends TimerTask {
	int a = 1;
	@Override
	public void run() {
		System.out.println("�ҵĶ�ʱ����    " + new Date() + "     " + a++ );
	}
}
