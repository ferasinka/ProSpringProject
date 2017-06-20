package com.ferasinka.prospringproject.ch10;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import javax.annotation.PostConstruct;

public class StringToDateTimeConverter implements Converter<String, DateTime> {
	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private DateTimeFormatter dateFormat;
	private String datePattern = DEFAULT_DATE_PATTERN;
	
	public String getDatePattern() {
		return datePattern;
	}
	
	@Autowired(required = false)
	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	
	@PostConstruct
	public void init() {
		dateFormat = DateTimeFormat.forPattern(datePattern);
	}
	
	@Override
	public DateTime convert(String source) {
		return dateFormat.parseDateTime(source);
	}
}
