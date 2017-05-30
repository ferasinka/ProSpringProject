package com.ferasinka.prospringproject.ch4.kindergarten;

import com.ferasinka.prospringproject.ch4.Food;
import com.ferasinka.prospringproject.ch4.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

//@Profile("kindergarten")
public class FoodProviderServiceImpl implements FoodProviderService {
	@Override
	public List<Food> provideLunchSet() {
		List<Food> lunchSet = new ArrayList<>();
		
		lunchSet.add(new Food("Milk"));
		lunchSet.add(new Food("Biscuits"));
		
		return lunchSet;
	}
}
