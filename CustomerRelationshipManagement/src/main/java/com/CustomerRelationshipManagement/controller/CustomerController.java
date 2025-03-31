package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController
{
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/insert") // postmapping not store normal or can't to the able store or hold the data  object , overcome this problem we use the @Requestbody
	public String insertCustomer(@RequestBody Customer customer)
	{
		String msg = customerService.insertCustomer(customer);
		
		return msg;
	}
	
	@GetMapping
	public List<Customer> getCustomersList()
	{
		List<Customer> msg = customerService.getCustomersList();
		return msg;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id)
	{
		return customerService.getCustomerById(id);
	}
	
	@PutMapping  // update to data us the putmapping
	public String customerUpdate(@RequestBody Customer customer)
	{
		return customerService.customerUpdate(customer);
	}
	
}
