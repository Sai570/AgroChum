package com.capstone.dao;

import java.util.Date;
import java.util.List;

import com.capstone.model.Customer;

public interface CustomerDao {
	public List<Customer> listUsers();

	public int saveUser(String fname, String lname, String email,String password);

	public List<Customer> getUserByUserEmail(String userEmail);

}
