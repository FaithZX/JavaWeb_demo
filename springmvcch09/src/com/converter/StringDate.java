package com.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDate implements Converter<String, Date>{

	// ����ת����ʽ
	private String pattern;
	// ���캯��
	public StringDate(String pattern) {
		super();
		this.pattern = pattern;
	}

	@Override
	public Date convert(String arg0) {  
		//  yyyy-MM-dd 
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		try {
			return sd.parse(arg0);
		} catch (ParseException e) {
			//e.printStackTrace();
			throw new IllegalAccessError("����ת��������");
		}
	}

}
