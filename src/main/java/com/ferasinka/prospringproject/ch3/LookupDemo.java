package com.ferasinka.prospringproject.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml-ch3.xml");
		
		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);
		
		displayInfo(standardBean);
		displayInfo(abstractBean);
	}
	
	private static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		
		System.out.println("Are instances equal?: " + (helper1 == helper2));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		
		for (int i = 0; i < 100_000; i++) {
			MyHelper helper = bean.getMyHelper();
			helper.doSomethingHelpful();
		}
		
		stopWatch.stop();
		
		System.out.println("100 000 gets took " + stopWatch.getTotalTimeMillis() + "ms");
	}
}
