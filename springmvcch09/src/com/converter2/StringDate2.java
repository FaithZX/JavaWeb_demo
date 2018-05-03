package com.converter2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;


/**
 * ��������ת����
 * @author Administrator
 *
 */
public class StringDate2 implements Formatter<Date>{

	// ����ת����ʽ
	private String pattern;
	private SimpleDateFormat sd;
	
	// ���캯��
	public StringDate2(String pattern) {
		super();
		this.pattern = pattern;
		sd = new SimpleDateFormat(pattern);
	}
	
	@Override
	public String print(Date object, Locale locale) {
		//������仰  ����Ҫ�������ڹ淶ȥת   ����1999-15-15�ͻᱨ��
		sd.setLenient(false);
		return sd.format(object);
	}
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		sd.setLenient(false);
		return sd.parse(text);
	}


}
