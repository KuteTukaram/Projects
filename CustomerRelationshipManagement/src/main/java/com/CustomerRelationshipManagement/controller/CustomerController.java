package com.CustomerRelationshipManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@DeleteMapping("/{id}")
	public String customerDeleteById(@PathVariable int id)
	{
		return customerService.customerDeleteById(id);
	}
	
	@PostMapping("/multiple")
	public String insertMultipleCustomers(@RequestBody List<Customer> customers)
	{
		return customerService.insertMultipleCustomer(customers);
	}
	
	@GetMapping("/byname/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName)
	{
		return customerService.getCustomerByFirstName(firstName);
	}
	
	@GetMapping("/LessThanAge/{age}")
	public List<Customer> getCustomerByLessThanAge(@PathVariable int age)
	{
		return customerService.getCustomersByLessThanAge(age);
	}
	
	@GetMapping("/GreterThanAge/{age}")
	public List<Customer> getCustomerByGreterThanAge(@PathVariable int age)
	{
		return customerService.getCustomerByGreterThanAge(age);
	}
	
	@GetMapping("/byage/{age}")
	public List<Customer> getCustomerByAge(@PathVariable int age)
	{
		return customerService.getCustomerByAge(age);
	}
	
	@GetMapping("/BylastName/{lastName}")
	public List<Customer> getCustomerBylastName(@PathVariable String lastName)
	{
		return customerService.getCustomerBylastName(lastName);
	}
	
	@GetMapping("/bymobileNumber/{mobileNumber}")
	public List<Customer> getCustomerBymobileNumber(@PathVariable String mobileNumber)
	{
		return customerService.getCustoemrBymobileNumber(mobileNumber);
	}
	
	@GetMapping("/Byemail/{email}")
	public List<Customer> getCustomerByEmail(@PathVariable String email)
	{
		return customerService.getCustomerByEmail(email);
	}
	
	@PutMapping("/fname/{id}")
	public String updateFirstName(@PathVariable int id, @RequestBody Map<String , String > request)
	{
		String firstName = request.get("firstName");
		
		return customerService.updateFirstName(id, firstName);
	}
	
	@PutMapping("/lname/{id}")
	public String updateLastName(@PathVariable int id, @RequestBody Map<String, String> request)
	{
		String lastName = request.get("lastName");
		
		return customerService.updateLastName(id, lastName);
	}
	
	@PutMapping("/updateemail/{id}")
	public String updateEmailId(@PathVariable int id, @RequestBody Map<String , String > request)
	{
		String email = request.get("email");
		return customerService.updateEmailId(id, email);
	}
	
	@PutMapping("/mobileNumber/{id}")
	public String updateMobileNumber(@PathVariable int id, @RequestBody Map<String, String> request)
	{
		String mobileNumber = request.get("mobileNumber");
		return customerService.updateMobileNumber(id, mobileNumber);
	}
	
	@PutMapping("/age/{id}")
	public String updateAge(@PathVariable int id,@RequestBody Map<String,Integer> request)
	{
		int age = request.get("age");
		
		return customerService.updateAge(id, age);
	}
	
	@GetMapping("/firstnames")
	public List<String> getCustomerFirstName()
	{
		return customerService.getCustomerFirstName();
	}
}
