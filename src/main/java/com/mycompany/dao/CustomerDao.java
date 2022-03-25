package com.mycompany.dao;

import java.util.ArrayList;

import com.mycompany.dto.Customer;

public interface CustomerDao {
	

	public boolean save(Customer customer);
	public boolean update(Customer customer);
	public boolean delete(int customerId);
	public ArrayList<Customer>getAll();
	public Customer get(int customerId);
	
	
	
}
