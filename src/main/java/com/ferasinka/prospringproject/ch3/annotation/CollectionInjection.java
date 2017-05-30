package com.ferasinka.prospringproject.ch3.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {
	@Resource(name = "map")
	private Map<String, Object> map;
	
	@Resource(name = "props")
	private Properties props;
	
	@Resource(name = "set")
	private Set set;
	
	@Resource(name = "list")
	private List list;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation-ch3.xml");
		
		CollectionInjection instance = ctx.getBean("injectCollection", CollectionInjection.class);
		instance.displayInfo();
	}
	
	private void displayInfo() {
		System.out.println("Map content:");
		
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		
		System.out.println("\nProperties content:");
		
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " - Value: " + entry.getValue());
		}
		
		System.out.println();
		System.out.println("Set content:");
		
		for (Object obj : set) {
			System.out.println("Value: " + obj);
		}
		
		System.out.println();
		System.out.println("List content:");
		
		for (Object obj : list) {
			System.out.println("Value: " + obj);
		}
	}
	
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void setProps(Properties props) {
		this.props = props;
	}
	
	public void setSet(Set set) {
		this.set = set;
	}
	
	public void setList(List list) {
		this.list = list;
	}
}
