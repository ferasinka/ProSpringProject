package com.ferasinka.prospringproject.ch18;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;

import java.util.Date;

public class PersonJob {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/person-job-ch18.xml");
		
		Job job = applicationContext.getBean(Job.class);
		JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
		
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("date", new Date())
				.toJobParameters();
		
		jobLauncher.run(job, jobParameters);
	}
}
