package com.rabindra.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rabindra.springdemo.entity.RabindrasCustomer;
import com.rabindra.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	// need to inject the customer dao
	@Autowired
	//initially we didnot have service layer so we used DAO for data base transaction
//	private CustomerDAO customerDAO;
	//need to inject a customer service
	private CustomerService customerService;
	

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<RabindrasCustomer> theCustomers = customerService.getCustomers();
						
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
				
		return "list-customers";
		}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//add model attribute to bind form data 
		RabindrasCustomer theCustomer = new RabindrasCustomer();
		
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") RabindrasCustomer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service with primary key
		RabindrasCustomer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customers/list";
		
	}
	
}


