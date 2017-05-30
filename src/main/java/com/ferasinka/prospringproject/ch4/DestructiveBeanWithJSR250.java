package com.ferasinka.prospringproject.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250 {
	private File file;
	private String filePath;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch4.xml");
		
		DestructiveBeanWithJSR250 bean = ctx.getBean("destructiveBean", DestructiveBeanWithJSR250.class);
	}
	
	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		
		if (filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithJSR250.class);
		}
		
		this.file = new File(filePath);
		boolean x = this.file.createNewFile();
		
		System.out.println("Is file created?: " + x + ", file exists: " + file.exists());
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroying Bean");
		
		if (!file.delete()) {
			System.out.println("ERROR: failed to delete file!");
		}
		
		System.out.println("File exists: " + file.exists());
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
