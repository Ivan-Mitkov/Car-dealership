package com.example.demo.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Car;
import com.example.demo.entity.Part;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
		
	List<Car> findByMakeOrderByModel(String make);
	@Query(value="select p " +
		    "from Part p " +
		    "inner join p.cars c " +
		    "where c.id = :id ")
	 List<Part> findByIdIn(@Param(value = "id")long id);
	
}
