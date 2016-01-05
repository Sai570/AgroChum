package com.capstone.client.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import entites.Customer;
import ws.RestfulClient;

/**
 * Servlet implementation class RegistrationClient
 */
@WebServlet("/RegistrationClient")
public class RegistrationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");

		long id;
		String fname = "";
		String lname = "";
		String email = "";
		String password = "";
		String gender = "";
		String dob = "";
		String c_number = "";

		String checkemail = "emailAvailability";
		String emailavail = "";
		emailavail = request.getParameter("method");
		email = request.getParameter("email");
		System.out.println("email"+email);
		String success = email;
		
		
		RestfulClient rc = new RestfulClient();

		if ((emailavail != null) && (checkemail.equals(emailavail))) {
		String emailData =	checkemail(email);
		response.getWriter().write(emailData);
			//System.out.println("Jobject" + jObj);
	//		String success = email;
		} else {

			fname = request.getParameter("firstname");
			lname = request.getParameter("lastname");
			email = request.getParameter("email");
			password = request.getParameter("password");
			System.out.println("FNAME:" + fname + "," + "LNAME :" + lname + "," + "email:" + email + "password: "
					+ password);
			/*gender = request.getParameter("gender");
			dob = request.getParameter("dob");
			c_number = request.getParameter("c_number");

			System.out.println("FNAME:" + fname + "," + "LNAME :" + lname + "," + "email:" + email + "password: "
					+ password + ", " + "gender: " + gender + "dob:" + dob);
*/

		String result = rc.testUpdateUser(fname, lname, email, password);
		RequestDispatcher requestDispatcher;

		try {
			Document doc = loadXMLFromString(result);

			System.out.println("value" + doc.getDocumentElement().getTextContent());
			String elementValue = doc.getDocumentElement().getTextContent();
			int value = Integer.parseInt(elementValue);
			if (value >= 1) {
				request.getSession().setAttribute("userStatus", "SuccessfullyRegistered!!!");
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
			} else {
				requestDispatcher = request.getRequestDispatcher("/registration.html");
			}
			requestDispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}

	}

		
		
		// TODO Auto-generated method stub
		// doGet(request, response);
	/*	response.setContentType("text/html");

		long id;
		String fname = "";
		String lname = "";
		String email = "";
		String password = "";
		String gender = "";
		String dob = "";
		String c_number = "";

		fname = request.getParameter("fname");
		lname = request.getParameter("lname");
		email = request.getParameter("email");
		password = request.getParameter("pwd");
		gender = request.getParameter("gender");
		dob = request.getParameter("dob");
		c_number = request.getParameter("c_number");

		System.out.println("FNAME:" + fname + "," + "LNAME :" + lname + "," + "email:" + email + "password: " + password
				+ ", " + "gender: " + gender + "dob:" + dob);

		PrintWriter pw = response.getWriter();
		RestfulClient rc = new RestfulClient();
		String result = rc.testUpdateUser(fname, lname, email, password, gender, dob, c_number);
		System.out.println("result" + result);
		RequestDispatcher requestDispatcher;

		try {
			Document doc = loadXMLFromString(result);

			System.out.println("value" + doc.getDocumentElement().getTextContent());
			String elementValue = doc.getDocumentElement().getTextContent();
			int value = Integer.parseInt(elementValue);
			if (value >= 1) {
				request.getSession().setAttribute("userStatus", "SuccessfullyRegistered!!!");
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
			} else {
				requestDispatcher = request.getRequestDispatcher("/registration.html");
			}
			requestDispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		pw.print(result);
*/
	}

	public static Document loadXMLFromString(String xml) throws Exception {
		System.out.println("xml" + xml);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		return builder.parse(is);
	}
	
	
	private String checkemail(String emailavail) {
		RestfulClient rc = new RestfulClient();
		String emailAvail = "";
		try {
			System.out.println("emailavail" + emailavail);
			emailAvail = rc.checkEmailAvailability(emailavail);
			System.out.println("emailAvail"+emailAvail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return emailAvail;
	}
	
}
