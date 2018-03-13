package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Car;
import com.example.demo.services.CarsService;

@Controller
@RequestMapping("/search")
public class CarController {
	
		//need to inject the car service
			@Autowired
			CarsService service;
			
//NOT MAPPED TO THE FORMS
			@PostMapping("/showCars")
			public String listCarsByMake( @RequestParam("type")String type, Model model) {
				
				String make2=type;
				List<Car> tempCar=service.getCarsByMake(make2);
			
				//add customers to spring MVC model
				model.addAttribute("carsByMake",tempCar);
				
				return "makelist";
			}
			@GetMapping("/carForms")
			public String showCarForm(@ModelAttribute("type")String type,
					 Model model) {
				List<String>allTypes=new ArrayList<>(); 
				allTypes=service.getCarMakers();
				model.addAttribute("allTypes",allTypes);
				
				return "carForms";
			}
			
	
}