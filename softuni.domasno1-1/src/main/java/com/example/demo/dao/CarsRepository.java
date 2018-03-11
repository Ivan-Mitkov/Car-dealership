package com.example.demo.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Car;


public interface CarsRepository extends JpaRepository<Car, Long> {

	List<Car> findByMakeOrderByModel(String make);

}
