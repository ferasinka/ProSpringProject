package com.ferasinka.prospringproject.ch11;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@Service("carService")
public class CarServiceImpl implements CarService {
	private static final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);
	private CarRepository carRepository;
	
	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Car> findAll() {
		return Lists.newArrayList(carRepository.findAll());
	}
	
	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}
	
	@Override
	@Scheduled(fixedDelay = 10_000)
	public void updateCarAgeJob() {
		List<Car> cars = findAll();
		
		DateTime currentDate = DateTime.now();
		
		LOG.info("Car age update job started");
		
		for (Car car : cars) {
			int age = Years.yearsBetween(car.getManufactureDate(), currentDate).getYears();
			
			car.setAge(age);
			
			save(car);
			
			LOG.info("Car age update--- " + car);
		}
		
		LOG.info("Car age update job completed successfully!");
	}
}
