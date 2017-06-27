package com.ferasinka.prospringproject.ch11;

import org.springframework.core.task.TaskExecutor;

public class TaskToExecute {
	private TaskExecutor taskExecutor;
	
	public void setTaskExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	public void executeTask() {
		for (int i = 0; i < 10; i++) {
			taskExecutor.execute(() -> System.out.println("Hello from thread: " + Thread.currentThread().getName()));
		}
	}
}
