package com.ferasinka.prospringproject.ch15;

import com.ferasinka.prospringproject.ch12.ContactService;
import org.springframework.beans.factory.annotation.Autowired;

public class AppStatisticsImpl implements AppStatistics {
	@Autowired
	private ContactService contactService;
	
	@Override
	public int getTotalContactCount() {
		return contactService.findAll().size();
	}
}
