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

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;
import org.w3c.dom.Document;

import com.cap.util.AgrochumHelper;

import entity.model.Category;
import entity.model.PostItemsDetails;
import ws.RestfulClient;

/**
 * Servlet implementation class BuyController
 */
@WebServlet("/BuyController")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuyController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PostDetails postDetails = new PostDetails();
		List<Category> categoryList = null;

		categoryList = postDetails.listOfStocks();
		System.out.println("categorysize:" + categoryList.size());
		if (categoryList.size() > 0) {

			System.out.println(" In if conditioncategorysize:" + categoryList.size());
			Iterator<Category> iterator = categoryList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().getCategoryName());
			}
			request.setAttribute("categoryList", categoryList);

		}
		requestDispatcher = request.getRequestDispatcher("/buy_item.jsp");
	//	requestDispatcher = request.getRequestDispatcher("/displayImage.jsp");
		requestDispatcher.include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In Do Post BuY Controller");

		String selected_category = request.getParameter("select_category");
		System.out.println("selected_category" + selected_category);
		int categoryId = Integer.parseInt(selected_category);
		RestfulClient rc = new RestfulClient();
		/*
		 * String custId = ""; String email = (String)
		 * request.getSession().getAttribute("email"); System.out.println(
		 * "In Do Post**" + email); try { custId =
		 * rc.getCurrentCustomerId(email); Document doc =
		 * RegistrationClient.loadXMLFromString(custId);
		 * 
		 * System.out.println("value" +
		 * doc.getDocumentElement().getTextContent()); String elementValue =
		 * doc.getDocumentElement().getTextContent(); customerId =
		 * Integer.parseInt(elementValue);
		 * 
		 * // customerId = rc.getCurrentCustomerId(email); } catch
		 * (JSONException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		if (categoryId > 0) {
			// String chooseCat = request.getParameter("searchCat");
			AgrochumHelper agrochumhelper = new AgrochumHelper();

			List<PostItemsDetails> postItemsList = agrochumhelper.getSearchCategory(categoryId);
			/*
			 * ObjectMapper mapper = new ObjectMapper();
			 * mapper.writeValue(response.getOutputStream(), postItems);
			 * 
			 * // response.getWriter().write(postItems.toString());
			 * 
			 */
			System.out.println("postItemsList Size:"+postItemsList.size());
			request.setAttribute("postItemsList", postItemsList);
			requestDispatcher = request.getRequestDispatcher("/buy_item.jsp");
			requestDispatcher.include(request, response);

		}

	}

}
