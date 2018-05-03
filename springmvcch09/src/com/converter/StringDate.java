package com.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringDate implements Converter<String, Date>{

	// 日期转换格式
	private String pattern;
	// 构造函数
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
			throw new IllegalAccessError("日期转换出错！！");
		}
	}

}
