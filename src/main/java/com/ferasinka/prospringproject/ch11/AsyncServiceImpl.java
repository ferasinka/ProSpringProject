package com.ferasinka.prospringproject.ch11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {
	private static final Logger LOG = LoggerFactory.getLogger(AsyncServiceImpl.class);
	
	@Async
	@Override
	public void asyncTask() {
		LOG.info("Start execution of async task");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LOG.info("Complete execution of async task");
	}
	
	@Async
	@Override
	public Future<String> asyncWithReturn(String name) {
		LOG.info("Start execution of async task with return");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LOG.info("Complete execution of async task with return");
		
		return new AsyncResult<>("Hello: " + name);
	}
}
