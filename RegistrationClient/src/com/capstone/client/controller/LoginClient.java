package com.capstone.client.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import ws.RestfulLoginClient;

/**
 * Servlet implementation class LoginClient
 */
@WebServlet("/LoginClient")
public class LoginClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginClient() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		response.setContentType("text/html");

		String email = "";
		String password = "";

		email = request.getParameter("email");
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		// request.getSession().setAttribute("email", email);
		password = request.getParameter("password");

		System.out.println("email:" + email + "password: " + password);

		PrintWriter pw = response.getWriter();
		RestfulLoginClient rlc = new RestfulLoginClient();
		RequestDispatcher requestDispatcher = null;
		String result = rlc.testUpdateUserLogin(email, password);

		Object obj = JSONValue.parse(result);
		JSONObject jsonObject = (JSONObject) obj;

		String status = (String) jsonObject.get("status");
		System.out.println("status***" + status);

		if (status != null && status.equals("loginSuccess")) {
			requestDispatcher = request.getRequestDispatcher("/choose_buy_post.jsp");

		} else if (status != null && status.equals("loginFail")) {
			requestDispatcher = request.getRequestDispatcher("/registration.html");

		}
		requestDispatcher.include(request, response);
		// response.getWriter().write(result);

		// System.out.println("result"+result);
		// pw.print(result);

	}
}
