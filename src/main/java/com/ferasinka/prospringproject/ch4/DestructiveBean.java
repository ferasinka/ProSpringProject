package com.ferasinka.prospringproject.ch4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {
	private File file;
	private String filePath;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch4.xml");
		
		DestructiveBean bean = ctx.getBean("destructiveBean", DestructiveBean.class);
		
		ctx.destroy();
		
		System.out.println("Method destroy() has been called");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		
		if (filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
		}
		
		this.file = new File(filePath);
		boolean x = this.file.createNewFile();
		
		System.out.println("Is file created?: " + x + ", file exists: " + file.exists());
	}
	
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
