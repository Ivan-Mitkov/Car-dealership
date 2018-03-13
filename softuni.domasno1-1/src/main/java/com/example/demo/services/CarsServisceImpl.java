package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CarsRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Part;

@Service
public class CarsServisceImpl implements CarsService{
	@PersistenceContext
    private EntityManager entityManager;
	private CarsRepository carRepository;
	private PartsServiceImpl partsService;
	
	//construct and autowire
	@Autowired
	public CarsServisceImpl(EntityManager entityManager, CarsRepository carRepository, PartsServiceImpl partsService) {
		this.entityManager = entityManager;
		this.carRepository = carRepository;
		this.partsService = partsService;
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
	public List<String> getCarMakers() {
		List<Car> manufacturers= carRepository.findAll();
		Set<String>uniqMakers=new TreeSet<>();
		for(Car a:manufacturers) {
			uniqMakers.add(a.getMake());
		}
		List<String> makers= uniqMakers.stream().collect(Collectors.toList());
		
		return makers;
	}
	@Override
	@Transactional
	public Map<Car,List<Part>> getCarWithThereParts(long id) {
		//initialize
		List<Part> parts=new ArrayList<>();
		Map<Car,List<Part>>result=new HashMap<>();
		//get
		Car car=carRepository.findById(id).get();		
		parts = carRepository.findByIdIn(id);	
		
		result.put(car, parts);
		
		return result;
	}

	@Override
	public Car carById(long id) {
		
		return carRepository.findById(id).get();
	}

	

}
