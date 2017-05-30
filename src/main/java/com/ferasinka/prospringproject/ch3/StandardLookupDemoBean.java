package com.ferasinka.prospringproject.ch3;

public class StandardLookupDemoBean implements DemoBean {
	private MyHelper myHelper;
	
	@Override
	public MyHelper getMyHelper() {
		return this.myHelper;
	}
	
	public void setMyHelper(MyHelper myHelper) {
		this.myHelper = myHelper;
	}
	
	@Override
	public void someOperation() {
		myHelper.doSomethingHelpful();
	}
}
