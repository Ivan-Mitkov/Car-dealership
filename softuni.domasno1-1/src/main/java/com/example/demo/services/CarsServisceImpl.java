package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CarsRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Part;

@Service
public class CarsServisceImpl implements CarsService{
	
	private CarsRepository carRepository;
	
	@Autowired
	public CarsServisceImpl(CarsRepository carRepository) {
		this.carRepository=carRepository;
	}
	
	@Override
	@Transactional
	public List<Car> getCarsByMake(String make) {
		List<Car> cars=carRepository.findByMakeOrderByModel(make);
		List<Car>res=cars.stream()
				.sorted(Comparator.comparing(Car::getModel)
						.thenComparing(Comparator.comparing(Car::getTravelledDistance)
								.reversed()))
				.collect(Collectors.toList());
				
		return res;
	}


	@Override
	@Transactional
	public Map<List<Car>, List<Part>> getCarsWithParts() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public List<String> getCarMakers() {
		List<Car> manufacturers= carRepository.findAll();
		Set<String>uniqMakers=new TreeSet<>();
		for(Car a:manufacturers) {
			uniqMakers.add(a.getMake());
		}
		List<String> makers= uniqMakers.stream().collect(Collectors.toList());
		
		return makers;
	}


}
