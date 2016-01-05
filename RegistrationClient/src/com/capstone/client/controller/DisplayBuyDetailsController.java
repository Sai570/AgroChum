package com.capstone.client.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cap.util.AgrochumHelper;

import entity.model.PostItemsDetails;

/**
 * Servlet implementation class DisplayBuyDetails
 */
@WebServlet("/DisplayBuyDetailsController")
public class DisplayBuyDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayBuyDetailsController() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		int post_Id = 0;
		List<PostItemsDetails> postDetailsList;
		String selected_postId = request.getParameter("radioName");
		if (selected_postId != null) {
			post_Id = Integer.parseInt(selected_postId);
		}
		System.out.println("post_Id" + post_Id);
		AgrochumHelper agrochumHelper = new AgrochumHelper();

		postDetailsList = agrochumHelper.getPostDetails(post_Id);

		System.out.println("Title Name" + postDetailsList.get(0).getTitle());
		String addr1 = postDetailsList.get(0).getAddress().getAddr1();
		String addr2 = postDetailsList.get(0).getAddress().getAddr2();
		String address = addr1 + addr2;
		/* System.out.println("Address"+postDetailsList.get(0) */
		System.out.println("Price" + postDetailsList.get(0).getTotalprice());
		System.out.println("Quantity" + postDetailsList.get(0).getQuantity());
		System.out.println("PostId" + postDetailsList.get(0).getPostId());
		Integer postId = postDetailsList.get(0).getPostId();
		RequestDispatcher requestDispatcher = null;

		if (postDetailsList.size() != -1 && postDetailsList.size() > 0) {
		
			request.setAttribute("address", address);
			request.getSession().setAttribute("postDetailsList", postDetailsList);
			request.getSession().setAttribute("postId", postId);
			requestDispatcher = request.getRequestDispatcher("/show_item_details.jsp");
		}
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
