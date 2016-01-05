package com.capstone.dao;

import com.capstone.model.LoginBean;

public interface CustomerLoginDao {
	
	 public String authenticateUser(LoginBean login);

}
