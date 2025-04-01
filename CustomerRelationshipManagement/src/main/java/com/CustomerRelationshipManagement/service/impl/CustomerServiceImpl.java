package com.CustomerRelationshipManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	//Dao to call using spring
	CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public String insertCustomer(Customer customer) {
		
		return customerDao.insertCustomer(customer);
	}

	@Override
	public List<Customer> getCustomersList() {
		
		return customerDao.getCustomersList();
	}

	@Override
	public Customer getCustomerById(int id) {
		
		return customerDao.getcustomerById(id);
	}

	@Override
	public String customerUpdate(Customer customer) {
		
		return customerDao.updateCustomer(customer) ;
	}

	@Override
	public String customerDeleteById(int id) {
		
		return customerDao.deleteCustomerById(id);
	}

	@Override
	public String insertMultipleCustomer(List<Customer> customers) {
		
		return customerDao.insertMultipleCustomers(customers);
	}

	@Override
	public List<Customer> getCustomerByFirstName(String firstName) {
		
		return customerDao.getCustomerBYFirstName(firstName);
	}

	@Override
	public List<Customer> getCustomersByLessThanAge(int age) {
		
		return customerDao.getCustomersByLessThanAge(age);
	}

	@Override
	public List<Customer> getCustomerByGreterThanAge(int age) {
		
		return customerDao.getCustomersByGreterThanAge(age);
	}

	@Override
	public List<Customer> getCustomerByAge(int age) {
		
		return customerDao.getCustomerByAge(age);
	}

	@Override
	public List<Customer> getCustomerBylastName(String lastName) {
		
		return customerDao.getCustomerByLastName(lastName);
	}

	@Override
	public List<Customer> getCustoemrBymobileNumber(String mobileNumber) {
		
		return customerDao.getCustomerByMobileNumber(mobileNumber);
	}

	@Override
	public List<Customer> getCustomerByEmail(String email) {
		
		return customerDao.getCustomerByEmail(email);
	}

	@Override
	public String updateFirstName(int id, String firstName) {
		
		return customerDao.updateFirstName(id, firstName);
	}

	@Override
	public String updateLastName(int id, String lastName) {
		
		return customerDao.updateLastName(id, lastName);
	}

	@Override
	public String updateEmailId(int id, String email) {
		
		return customerDao.updateEmailId(id, email);
	}

	@Override
	public String updateMobileNumber(int id, String mobileNumber) {
		
		return customerDao.updateMobileNumber(id, mobileNumber);
	}

	@Override
	public String updateAge(int id, int age) {
	
		return customerDao.updateAge(id, age);
	}

	@Override
	public List<String> getCustomerFirstName() {
		
		return customerDao.getCustomerFirstName();
	}
	
}
