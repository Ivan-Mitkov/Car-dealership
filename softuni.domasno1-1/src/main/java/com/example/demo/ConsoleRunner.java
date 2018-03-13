package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.dao.PartsRepository;
import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Part;
import com.example.demo.services.CarsServisceImpl;
import com.example.demo.services.CustomerServisceImpl;
import com.example.demo.services.PartsServiceImpl;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private CustomerServisceImpl customerServisceImpl;
	@Autowired
	private CarsServisceImpl carService;
	@Autowired
	private PartsServiceImpl partService;
	
	@Override
	public void run(String... args) throws Exception {
        
//		List<Customer>customer= customerServisceImpl.getCustomersOrderedByBirthDate();
//		print(customer);
//		List<Customer> customer2 = customerServisceImpl.getCustomersOrderedByBirthDateDesc();
//		print(customer2);
//		String make="Opel";
//		List<Car>cars=carService.getCarsByMake(make);
//		print(cars);
//		List<String>makers=carService.getCarMakers();
//		print(makers);
//		long id=10L;
//		Map<Car, List<Part>> parts=new HashMap<>();
//		try {
//			Car car = carService.carById(id);
//			System.out.println(car);
//		}
//		catch(Exception e) {
//			System.out.println("Car null");
//			e.printStackTrace();
//		}
//		
//		try {
//			parts=carService.getCarWithThereParts(id);
//			printMap(parts);
//		}
//		catch(Exception e) {
//			System.out.println("Parts null");
//			e.printStackTrace();
//			
//		}
//		
		
	}
	private<K,V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if(entry.getValue()!=null){
				System.out.println(entry.getKey()+": "+entry.getValue());
			}
			else {
				System.out.println(entry.getKey());
			}
		}
		
	}

	public<T> void print(Iterable<T> customer) {
		
		for(T c:customer) {
			System.out.println(c);
		}
	}
	

}
