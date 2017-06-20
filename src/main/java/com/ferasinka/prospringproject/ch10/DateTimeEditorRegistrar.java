package com.ferasinka.prospringproject.ch10;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

import java.beans.PropertyEditorSupport;

public class DateTimeEditorRegistrar implements PropertyEditorRegistrar {
	private DateTimeFormatter dateTimeFormatter;
	
	public DateTimeEditorRegistrar(String dateTimePattern) {
		dateTimeFormatter = DateTimeFormat.forPattern(dateTimePattern);
	}
	
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(DateTime.class, new DateTimeEditor(dateTimeFormatter));
	}
	
	private static class DateTimeEditor extends PropertyEditorSupport {
		private DateTimeFormatter dateTimeFormatter;
		
		DateTimeEditor(DateTimeFormatter dateTimeFormatter) {
			this.dateTimeFormatter = dateTimeFormatter;
		}
		
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(DateTime.parse(text, dateTimeFormatter));
		}
	}
}
