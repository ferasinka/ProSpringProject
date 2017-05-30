package com.ferasinka.prospringproject.ch2;

import javax.inject.Inject;
import javax.inject.Named;

//@Service("messageProvider")
@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
//	private String message;
	private String message = "Default message";
	
	public ConfigurableMessageProvider() {
	}
	
//	@Autowired
	@Inject
	@Named("message")
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}
