package com.ferasinka.prospringproject.ch4;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean {
	private File file;
	private String filePath;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		DestructiveBeanWithInterface bean = ctx.getBean("destructiveBean", DestructiveBeanWithInterface.class);
		
		System.out.println("Calling destroy()");
		
		ctx.destroy();
		
		System.out.println("Method destroy() has been called");
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		
		if (filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBeanWithInterface.class);
		}
		
		this.file = new File(filePath);
		boolean x = this.file.createNewFile();
		
		System.out.println("Is file created?: " + x + ", file exists: " + file.exists());
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroying Bean");
		
		if (!file.delete()) {
			System.out.println("ERROR: failed to delete file!");
		}
		
		System.out.println("File exists: " + file.exists());
	}
}
