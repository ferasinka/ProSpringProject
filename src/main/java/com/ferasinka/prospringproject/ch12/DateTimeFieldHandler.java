package com.ferasinka.prospringproject.ch12;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.exolab.castor.mapping.ValidityException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Properties;

public class DateTimeFieldHandler extends GeneralizedFieldHandler {
	private static String dateFormatPattern;
	
	private static String format(final DateTime dateTime) {
		String dateTimeString = "";
		
		if (dateTime != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
			
			dateTimeString = dateTimeFormatter.print(dateTime);
		}
		
		return dateTimeString;
	}
	
	private static DateTime parse(final String dateTimeString) {
		DateTime dateTime = new DateTime();
		
		if (dateTimeString != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(dateFormatPattern);
			
			dateTime = dateTimeFormatter.parseDateTime(dateTimeString);
		}
		
		return dateTime;
	}
	
	@Override
	public void setConfiguration(Properties config) throws ValidityException {
		dateFormatPattern = config.getProperty("date-format");
	}
	
	@Override
	public Object convertUponGet(Object value) {
		DateTime dateTime = (DateTime) value;
		
		return format(dateTime);
	}
	
	@Override
	public Object convertUponSet(Object value) {
		String dateTimeString = (String) value;
		
		return parse(dateTimeString);
	}
	
	@Override
	public Class<DateTime> getFieldType() {
		return DateTime.class;
	}
}
