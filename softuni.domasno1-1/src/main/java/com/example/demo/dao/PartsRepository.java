package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;
import com.example.demo.entity.Part;
@Repository
public interface PartsRepository extends JpaRepository<Part, Long>{
	 
	  
}
