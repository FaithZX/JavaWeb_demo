package com.timer1;

import java.util.Timer;

public class TestTimerTask {

	public static void main(String[] args) {
		// �½�һ�� timer 
		Timer t = new Timer("��ʱ����");
		//  ִ�����ǵĶ�ʱ����   ��һ�������� ��ʱ�������    0 ��������ʼ   3000 ÿ��3����ִ��һ��
		t.schedule(new JdkTimerTask(), 0 , 3000);
	}
}
