package com.timer1;

import java.util.Timer;

public class TestTimerTask {

	public static void main(String[] args) {
		// 新建一个 timer 
		Timer t = new Timer("定时任务");
		//  执行我们的定时任务   第一个参数是 定时任务对象    0 是立即开始   3000 每隔3秒钟执行一次
		t.schedule(new JdkTimerTask(), 0 , 3000);
	}
}
