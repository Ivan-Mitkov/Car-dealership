package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.entity.Car;
import com.example.demo.entity.Part;

public interface CarsService {
	
	
	public List<Car> getCarsByMake(String make);

	public Map<List<Car>,List<Part>> getCarsWithParts();

	List<String> getCarMakers();

}
