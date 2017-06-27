package com.ferasinka.prospringproject.ch11;

import java.util.List;

public interface CarService {
	List<Car> findAll();
	
	Car save(Car car);
	
	void updateCarAgeJob();
}
