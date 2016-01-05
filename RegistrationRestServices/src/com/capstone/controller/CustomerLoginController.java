package com.capstone.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capstone.dao.CustomerLoginDao;
import com.capstone.daoImpl.CustomerLoginDaoImpl;
import com.capstone.model.LoginBean;

@Path("/customer_login")
public class CustomerLoginController {

	public CustomerLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	CustomerLoginDao loginDao = new CustomerLoginDaoImpl();

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String loginUserInfo(@FormParam("email") String email, @FormParam("pwd") String password) {

		LoginBean login = new LoginBean();
		login.setEmail(email);
		login.setPassword(password);

		String userValidate = loginDao.authenticateUser(login);
		return userValidate;

	}

}
