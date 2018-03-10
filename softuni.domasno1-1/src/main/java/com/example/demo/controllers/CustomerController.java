package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerService;


@Controller
@RequestMapping("/customers/all")
public class CustomerController {

	//need to inject the customer service
		@Autowired
		CustomerService customerService;
		
		@GetMapping("/descending")
		public String listCustomer(Model model) {
			//get the customers from service
			List<Customer> tempCustomers=customerService.getCustomersOrderedByBirthDateDesc();
		
			//add customers to spring MVC model
			model.addAttribute("customerDesc",tempCustomers);
			
			return "descending";
		}
		@GetMapping("/ascending")
		public String listCustomerReverse(Model model) {
			//get the customers from service
			List<Customer> tempCustomers=customerService.getCustomersOrderedByBirthDate();
			
			//add customers to spring MVC model
			model.addAttribute("customerAsc",tempCustomers);
			
			return "ascending";
		}
}
