package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
	
	public String deleteCustomerById(int id)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
		tr.commit();
		session.close();
		
		return "Customer delete successfully";
	}
	
	// Multiple customer insert single time 
	
	public String insertMultipleCustomers(List<Customer> customers)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for(Customer customer : customers)
		{
			session.save(customer);
		}
		
		tr.commit();
		session.close();
		return "Customers are intrested successfully";
		
	}
	// client given name find in db
	public List<Customer> getCustomerBYFirstName(String firstName)
	{
		Session session  =  sf.openSession();
		                    // entity name
		String query = "from Customer c where c.firstName =: firstName"; 
		Query<Customer> customers = session.createQuery(query,Customer.class);// take sql query
		
		customers.setParameter("firstName", firstName);
		List<Customer> list = customers.list();
		
		return list;
	}
	
	public List<Customer> getCustomersByLessThanAge(int age)
	{
		Session session = sf.openSession();
		String query = "from Customer c where c.age <: age";
		Query<Customer> customers = session.createQuery(query,Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		
		return list;	
	}
	
	public List<Customer> getCustomersByGreterThanAge(int age)
	{
	Session session = sf.openSession();
	String query = "from Customer c where c.age >: age";
	Query<Customer> customers = session.createQuery(query , Customer.class);
	customers.setParameter("age", age);
	List<Customer> list = customers.list();
	return list;
	
	}
	
	public List<Customer> getCustomerByAge(int age)
	{
		Session session = sf.openSession();
		String query = "from Customer c where c.age =: age";
		Query<Customer> customers = session.createQuery(query, Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;
		
	}
	
	public List<Customer> getCustomerByLastName(String lastName)
	{
		Session session = sf.openSession();
		String query = "from Customer c where c.lastName =: lastName";
		Query<Customer> customer = session.createQuery(query, Customer.class);
		customer.setParameter("lastName", lastName);
		List<Customer> list = customer.list();
		return list;
		
	}
	
	public List<Customer> getCustomerByMobileNumber(String mobileNumber)
	{
		Session session = sf.openSession();
		String query = "from Customer c where c.mobileNumber =: mobileNumber";
		Query<Customer> customers = session.createQuery(query, Customer.class);
		customers.setParameter("mobileNumber", mobileNumber);
		List<Customer>list = customers.list();
		return list;
	}
	
	public List<Customer> getCustomerByEmail(String email)
	{
		Session session = sf.openSession();
		String query = "from Customer c where c.email =: email";
		Query<Customer> customers = session.createQuery(query,Customer.class);
		customers.setParameter("email", email);
		List<Customer>  list = customers.list();
		return list;
	}
	
	public String updateFirstName(int id, String firstName)
	{
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setFirstName(firstName);
		tr.commit();
		session.close();
		
		return "update successfully";
	}
	
	public String updateLastName(int id, String lastName)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setLastName(lastName);
		tr.commit();
		session.close();
		
		return "update successfully";
	}
	
	public String updateEmailId(int id, String email)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setEmail(email);
		
		tr.commit();
		session.close();
		
		return "Email id update successfully";
	}
	
	public String updateMobileNumber(int id, String mobileNumber)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
		customer.setMobileNumber(mobileNumber);
		tr.commit();
		session.close();
		
		return "mobile number updated successfully";
	}
	
	public String updateAge(int id, int age)
	{
	Session session = sf.openSession();
	Transaction tr = session.beginTransaction();
	Customer customer = session.get(Customer.class, id);
	customer.setAge(age);
	
	tr.commit();
	session.close();
	
	return "Age update succesffully";
	
	}
	
	public List<String> getCustomerFirstName()
	{
		Session session = sf.openSession();
		String query = "select c.firstName from Customer c"; // change c.lastName get lastname list, as it all email, mobile number, we get 
		return session.createQuery(query).list();
	}
	
}
