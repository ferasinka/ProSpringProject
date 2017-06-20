package com.ferasinka.prospringproject.ch10;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {
	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private DateTimeFormatter dateFormat;
	private String datePattern = DEFAULT_DATE_PATTERN;
	private Set<Formatter<?>> formatters = new HashSet<>();
	
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
		formatters.add(getDateTimeFormatter());
		setFormatters(formatters);
	}
	
	
	public Formatter<DateTime> getDateTimeFormatter() {
		return new Formatter<DateTime>() {
			@Override
			public DateTime parse(String text, Locale locale) throws ParseException {
				System.out.println("Parsing date string: " + text);
				
				return dateFormat.parseDateTime(text);
			}
			
			@Override
			public String print(DateTime object, Locale locale) {
				System.out.println("Formatting dateTime: " + object);
				
				return dateFormat.print(object);
			}
		};
	}
}
