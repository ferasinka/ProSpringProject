package com.ferasinka.prospringproject.ch4.highschool;

import com.ferasinka.prospringproject.ch4.Food;
import com.ferasinka.prospringproject.ch4.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

//@Profile("highschool")
public class FoodProviderServiceImpl implements FoodProviderService {
	@Override
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<>();
		
		lunchSet.add(new Food("Coke"));
		lunchSet.add(new Food("Hamburger"));
		lunchSet.add(new Food("French Fries"));
		
		return lunchSet;
	}
}
