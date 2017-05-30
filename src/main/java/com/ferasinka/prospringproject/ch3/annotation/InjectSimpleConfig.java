package com.ferasinka.prospringproject.ch3.annotation;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
	public String name = "Andrey Kuznetsov";
	public int age = 28;
	public float height = 76.5F;
	public boolean programer = true;
	public Long ageInSeconds = 100500L;
}
