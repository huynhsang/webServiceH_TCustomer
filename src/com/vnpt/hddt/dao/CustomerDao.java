package com.vnpt.hddt.dao;

import java.util.List;

import com.vnpt.hddt.model.Customer;

public interface CustomerDao {
	
	public static final String TB_NAME = "Customer";
	
	public Customer checkLogin(String username, String password);
	
	public Customer getCustomerById(int id);
	
	public List<Customer> getAllCustomer();
	
	public int getCount();
	
	public boolean insert(Customer customer);
	
	public boolean update(Customer customer);
	
	public boolean deleteById(int id);
	
}
