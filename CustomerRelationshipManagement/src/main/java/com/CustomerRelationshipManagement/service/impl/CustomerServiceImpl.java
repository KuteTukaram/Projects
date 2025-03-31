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
	
}
