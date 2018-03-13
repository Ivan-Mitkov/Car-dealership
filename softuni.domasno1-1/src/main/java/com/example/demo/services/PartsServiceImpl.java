package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PartsRepository;
import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Part;
@Service
public class PartsServiceImpl implements PartsServices {
	private PartsRepository partsRepository;
	
	@Autowired
	public PartsServiceImpl(PartsRepository partsRepository) {
		this.partsRepository=partsRepository;
	}
	
	
	
}
