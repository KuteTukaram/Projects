package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;

@Repository
public class CustomerDao 
{
	// Database operation 
	
	//@Autowired  // it handle the spring container, creation or destroy object
	SessionFactory sf;// used to data store in database , it is predefine method save() , delete(), update()
	// without @Autowired we use constructor injection 
	public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	// it is old approch to store
	public String insertCustomer(Customer customer)
	{
		Session session = sf.openSession();
		//insert , update, delete , you need to used to Transacction 
		Transaction tr = session.beginTransaction();
		
		// save method >> session
		session.save(customer);// to insert data
		
		tr.commit();// used to trasaction close and save the data
		session.close();
		
		return "Customer insert Successfully"; // return to service
	}
	
	// read data 
	
	public List<Customer> getCustomersList()
	{
	Session session = 	sf.openSession(); // Session is interface , present in org.hibernate package
	// sessionFactory is interface
	
	return session.createQuery("from Customer").list();// return List 
	}
	
	public Customer getcustomerById(int id)
	{
		Session session = sf.openSession();
		return session.get(Customer.class, id);
		// difference betn get or load
		// get it will return null if object not found in database
		// load it will return objectNotFoundException if object not found in database
		
	}
	
	public String updateCustomer(Customer customer)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(customer);
		
		tr.commit();
		session.close();
		
		return "customer updated successfully";
	}
}
