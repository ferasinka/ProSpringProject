package com.ferasinka.prospringproject.ch5;

public class WorkerBean {
	public void doSomeWork(int noOfTimes) {
		for (int i = 0; i < noOfTimes; i++) {
			work();
		}
	}
	
	private void work() {
		System.out.print("");
	}
}
