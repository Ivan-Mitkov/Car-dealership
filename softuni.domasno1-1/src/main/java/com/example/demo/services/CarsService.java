package com.example.demo.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Car;
import com.example.demo.entity.Part;

public interface CarsService {
	
	
	public List<Car> getCarsByMake(String make);

	List<String> getCarMakers();
	

	Car carById(long id);

	Map<Car, List<Part>> getCarWithThereParts(long id);


}
