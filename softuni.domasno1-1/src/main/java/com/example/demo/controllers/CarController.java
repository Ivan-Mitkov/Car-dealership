package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import com.example.demo.entity.Part;
import com.example.demo.services.CarsService;

@Controller
@RequestMapping("/search")
public class CarController {
	
		//need to inject the car service
			@Autowired
			CarsService service;
			
			public CarController(CarsService service) {
				this.service = service;
			}
			@GetMapping("/carFormTest")
			public String showCarPart(Model model) {
				
				model.addAttribute("car",new Car());				
				return "carFormTest";
			}
			//show cars with same model
			@PostMapping("/showCar")
			public String carsByMake(@Valid @ModelAttribute("car") Car car,
					 BindingResult result,
					 Model model) {
				if (result.hasErrors()) {
			        return "error";
			    }
				List<Car>cars=new ArrayList<>();
				cars=service.getCarsByMake(car.getMake());
				//add car to spring MVC model
				model.addAttribute("carsByMake",cars);
				
				return "makelist";
			}
			
			
			
			@GetMapping("/parts")
			public String showCarFormTest(Model model) {
				
				model.addAttribute("car",new Car());				
				return "parts";
			}
			
			//show parts with same model
			@PostMapping("/partOfCar")
			public String partsByCar(@Valid @ModelAttribute("car") Car car,
					 BindingResult result,
					 Model model) {
				if (result.hasErrors()) {
			        return "error";
			    }
				Map<Car,List<Part>>parts=new HashMap<Car, List<Part>>();
				parts=service.getCarWithThereParts(car.getId());
				//add car to spring MVC model
				model.addAttribute("carsByMake",parts);
				
				return "partlist";
			}
			
			//NOT USED
			@GetMapping("/carForms")
			public String showCarForm( Model model) {
				List<Car>allTypes=new ArrayList<>(); 
				//get all makers
				allTypes=service.getCarMakers();
				//add them to the model
				model.addAttribute("allTypes",allTypes);
				
				return "carForms";
			}
			//FOR TESTS
			@PostMapping("/showCarTest")
			public String listCarsByMake(@Valid @ModelAttribute("car") Car car,
					 BindingResult result,
					 Model model) {
				if (result.hasErrors()) {
			        return "error";
			    }
				String type2=car.getMake();
			
				//add car to spring MVC model
				model.addAttribute("car",type2);
				
				return "makelistTest";
			}
	
}
