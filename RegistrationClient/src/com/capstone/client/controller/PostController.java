package com.capstone.client.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.codehaus.jettison.json.JSONException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.Document;

import com.cap.util.HibernateUtil;

import entity.model.Address;
import entity.model.PostItemsDetails;
import ws.RestfulClient;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
@MultipartConfig(maxFileSize = 16177215)
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HibernateUtil hibernateUtil = new HibernateUtil();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostController() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("In Post of Post Controller");
		String title = "";
		String address = "";
		Integer quantity = 0;
		double price = 0.0;
		String email = (String) request.getSession().getAttribute("email");
		System.out.println("In Do Post businessName**" + email);

		RestfulClient rc = new RestfulClient();
		String custId = "";
		int customerId = 0;
		try {
			custId = rc.getCurrentCustomerId(email);
			Document doc = RegistrationClient.loadXMLFromString(custId);

			System.out.println("value" + doc.getDocumentElement().getTextContent());
			String elementValue = doc.getDocumentElement().getTextContent();
			customerId = Integer.parseInt(elementValue);

			// customerId = rc.getCurrentCustomerId(email);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<FileItem> items = null;
		try {

			items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}

		int id = 0;
		InputStream filecontent = null;
		byte[] bytes = null;
		String select_category = "";
		String desc = "";
		String priceDetails = "";
		String select_sub_category = "";
		// String select_sub_category =
		// request.getParameter("select_sub_category");
		for (FileItem item : items) {
			System.out.println("field Names" + item.getFieldName());
			if (item.isFormField()) {
				if (item.getFieldName().equals("select_category")) {
					select_category = item.getString();
					System.out.println("select_category In items" + select_category);
					// select_category = item.getString("select_category");
				}
				if (item.getFieldName().equals("select_sub_category")) {
					select_sub_category = item.getString();
					System.out.println("select_category In items" + select_category);
					// select_category = item.getString("select_category");
				}
				if (item.getFieldName().equals("description")) {
					desc = item.getString();
					System.out.println("desc" + desc);
				}
				if (item.getFieldName().equals("quantity")) {
					System.out.println("Quantity***"+item.getString());
					quantity = Integer.parseInt(item.getString());
					System.out.println("quantity In items" + quantity);
					// select_category = item.getString("select_category");
				}

				if (item.getFieldName().equals("price")) {
					priceDetails = item.getString();
					System.out.println("priceDetails" + priceDetails);
				}
			}

			if (item.getFieldName().equals("image")) {
				filecontent = item.getInputStream();
				System.out.println(" filecontent" + item.getInputStream());
				bytes = IOUtils.toByteArray(filecontent);
			}

			/*
			 * if (item.isFormField()) ) {
			 * id=Integer.parseInt(item.getString());
			 * 
			 * } else { filecontent = item.getInputStream(); }
			 */

		}

		// postName = request.getParameter("postName");
		title = (String) request.getSession().getAttribute("title");
		System.out.println("In Do Post title**" + title);
		String businessName = (String) request.getSession().getAttribute("businessName");
		System.out.println("In Do Post businessName**" + businessName);

		String contact_num = (String) request.getSession().getAttribute("contact_num");
		System.out.println("In Do Post contact_num**" + contact_num);

		String addr1 = (String) request.getSession().getAttribute("addr1");
		System.out.println("In Do Post addr1**" + addr1);

		String addr2 = (String) request.getSession().getAttribute("addr2");
		System.out.println("In Do Post addr2**" + addr2);

		String city = (String) request.getSession().getAttribute("city");
		System.out.println("In Do Post city**" + city);

		String state = (String) request.getSession().getAttribute("state");
		System.out.println("In Do Post state**" + state);
		String zipcode = (String) request.getSession().getAttribute("zipcode");
		System.out.println("In Do Post zipcode**" + zipcode);

		String country = (String) request.getSession().getAttribute("country");
		System.out.println("In Do Post country**" + country);

		int categoryId = 0;
		if (select_category != null) {
			categoryId = Integer.parseInt(select_category);
		}
		System.out.println("categoryId***" + categoryId);

		// String select_sub_category =
		// request.getParameter("select_sub_category");
		int sub_categoryId = 0;
		if (select_sub_category != null) {
			sub_categoryId = Integer.parseInt(select_sub_category);
		}
		System.out.println(" sub_categoryId***" + sub_categoryId);
				if (priceDetails != null) {
			price = Double.parseDouble(priceDetails);
		}
		System.out.println("title" + title);
		// System.out.println("address" + address);
		System.out.println("quantity" + quantity);

		System.out.println("customerId" + customerId);

		String message = savePostInfo(title, businessName, addr1, addr2, city, state, zipcode, country, quantity, price,
				categoryId, customerId, sub_categoryId, bytes);
		System.out.println("Message" + message);
		RequestDispatcher requestDispatcher = null;
		if (message.equals("success")) {
			request.getSession().setAttribute("msg", "Posted Successfully!!!!!");
			requestDispatcher = request.getRequestDispatcher("/choose_buy_post.jsp");

		}
		requestDispatcher.include(request, response);
	}

	private String savePostInfo(String title, String businessName, String addr1, String addr2, String city,
			String state, String zipcode, String country, Integer quantity, double price, Integer categoryId,
			Integer customerId, Integer sub_categoryId, byte[] imgcontent) {
		System.out.println("In save Post Info");
		Session session = hibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		// Customer cus = new Customer();
		PostItemsDetails pos = new PostItemsDetails();
		String msg = "";
		System.out.println("Sub Category" + sub_categoryId);
		System.out.println("categoryId" + categoryId);
		System.out.println("imgcontent length**" + imgcontent);

		pos.setTitle(title);
		pos.setBusinessName(businessName);
		pos.setQuantity(quantity);
		pos.setTotalprice(price);
		pos.setImage(imgcontent);
		pos.setCustomerid(customerId);
		pos.setCategoryid(categoryId);
		pos.setSubcategoryid(sub_categoryId);
		Date date = new Date();
	     
	/*	DateFormat formatter = null;
		formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss zzz");
		// System.out.println("Date is: " + rdate);
		Date tempDate = formatter.parse(dob);*/
		pos.setPostDate(new Timestamp(date.getTime()));
		System.out.println("Current Date"+pos.getPostDate()); 
		
		Address address = new Address();
		address.setAddr1(addr1);
		address.setAddr2(addr2);
		address.setCity(city);
		address.setZipcode(zipcode);
		address.setState(state);
		address.setCountry(country);
		pos.setAddress(address);

		session.save(pos);
		trans.commit();
		msg = "success";

		return msg;
	}
}