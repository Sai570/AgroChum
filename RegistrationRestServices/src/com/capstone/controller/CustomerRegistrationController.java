package com.capstone.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.capstone.dao.CustomerDao;
import com.capstone.daoImpl.CustomerDaoImpl;
import com.capstone.model.Customer;

/*import entites.User;
import entites.UserId;*/

/**
 * Servlet implementation class CustomerRegistrationController
 */
@Path("/customer_reg")
@Consumes("multipart/related")
public class CustomerRegistrationController {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// private CustomerService custService;
	CustomerDao custService = new CustomerDaoImpl();

	public CustomerRegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_XML)
	public String registerUserInfo(@FormParam("fname") String fname, @FormParam("lname") String lname,
			@FormParam("email") String email, @FormParam("pwd") String password) throws ParseException {

		System.out.println("fname" + fname);
		System.out.println("lname" + lname);
	//	System.out.println("dob" + dob);
		System.out.println("email" + email);
	//	System.out.println("gender" + gender);
		System.out.println("password" + password);
	//	System.out.println("c_number" + c_number);

		Customer customer = new Customer();
		customer.setFirstname(fname);
		customer.setLastname(lname);
		customer.setEmail(email);
		customer.setPassword(password);
		DateFormat formatter = null;
		/*formatter = new SimpleDateFormat("MM/dd/yyyy");
		// System.out.println("Date is: " + rdate);
		Date tempDate = formatter.parse(dob);
		System.out.println("Output date is = " + tempDate);
		*/// char ch = (char)gender;
		/*
		 * customer.setGender(gender); customer.setDOB(tempDate);
		 * customer.setContactNumber(c_number); customer.setRegDate(new Date());
		 */
		int custId = custService.saveUser(fname, lname, email, password);
		// String response = "success from Registration Service!!!";
		String response = "<result>" + custId + "</result>";
		return response;

	}

	@POST
	@Path("/check_email")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String emailAvailability(@FormParam("email") String email) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		// obj.put("name", "mkyong.com");

		List<Customer> emailList = custService.getUserByUserEmail(email);
		int emailzise = emailList.size();
		System.out.println("emailzise" + emailzise);
		if (emailzise >= 1) {
			// jsonObj.put("emailavail", false);
			return "{\"status\":\"Not available\"}";
		}
		// jsonObj.put("emailavail", true);
		return "{\"status\":\"available\"}";

	}

	@POST
	@Path("/get_userId")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCurrentCustomerId(@FormParam("email") String email) throws JSONException {
		JSONObject jsonObj = new JSONObject();
		// obj.put("name", "mkyong.com");
		Integer customerId = 0;

		List<Customer> emailList = custService.getUserByUserEmail(email);
		int emailsize = emailList.size();
		if (emailsize > 0) {
			customerId = emailList.get(0).getCustomerid();
		}

		String response = "<CustomerId>" + customerId + "</CustomerId>";
		return response;

	}

}
