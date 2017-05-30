package com.ferasinka.prospringproject.ch4;

import com.ferasinka.prospringproject.ch2.ConfigurableMessageProvider;
import com.ferasinka.prospringproject.ch2.MessageProvider;
import com.ferasinka.prospringproject.ch2.MessageRenderer;
import com.ferasinka.prospringproject.ch2.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@ImportResource(value = "app-context-xml-ch3.xml")
@PropertySource(value = "message.properties")
@ComponentScan(basePackages = {"com.ferasinka.prospringproject.ch2"})
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	Environment env;
	
	@Bean
	@Lazy
	public MessageProvider messageProvider() {
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}
	
	@Bean(name = "messageRenderer")
	@Scope(value = "prototype")
	@DependsOn(value = "messageProvider")
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		
		return renderer;
	}
}
