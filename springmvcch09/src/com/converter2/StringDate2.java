package com.converter2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;


/**
 * 日期类型转换器
 * @author Administrator
 *
 */
public class StringDate2 implements Formatter<Date>{

	// 日期转换格式
	private String pattern;
	private SimpleDateFormat sd;
	
	// 构造函数
	public StringDate2(String pattern) {
		super();
		this.pattern = pattern;
		sd = new SimpleDateFormat(pattern);
	}
	
	@Override
	public String print(Date object, Locale locale) {
		//加上这句话  就需要按照日期规范去转   类似1999-15-15就会报错
		sd.setLenient(false);
		return sd.format(object);
	}
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		sd.setLenient(false);
		return sd.parse(text);
	}


}
