package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService 
{
	String insertCustomer(Customer customer);
	
	List<Customer> getCustomersList();
	
	Customer getCustomerById(int id);
	
	String customerUpdate(Customer customer);
	
	String customerDeleteById(int id);
	
	String insertMultipleCustomer(List<Customer> customers);
	
	List<Customer> getCustomerByFirstName(String firstName);
	
	List<Customer> getCustomersByLessThanAge(int age);
	
	List<Customer> getCustomerByGreterThanAge(int age);
	
	List<Customer> getCustomerByAge(int age);
	
	List<Customer> getCustomerBylastName(String lastName);
	
	List<Customer> getCustoemrBymobileNumber(String mobileNumber);
	
	
}
