package com.capstone.client.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cap.util.HibernateUtil;

import entity.model.Category;
import entity.model.SubCategory;

/**
 * Servlet implementation class PostDetails
 */
@WebServlet("/PostDetails")
public class PostDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDetails() {
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
		response.setContentType("text/html");

		String email = (String) request.getSession().getAttribute("email");
		System.out.println("In Get Post**" + email);

		RequestDispatcher requestDispatcher = null;
		// session.beginTransaction();

		List<Category> categoryList = listOfStocks();
		if (categoryList.isEmpty() && categoryList.size() == 0) {
			saveUser();
			categoryList = listOfStocks();

		}
		System.out.println("categorysize:" + categoryList.size());
		Iterator<Category> iterator = categoryList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getCategoryName());
		}
		request.setAttribute("categoryList", categoryList); 
		// session.getTransaction().commit();
		System.out.println("Done");
		requestDispatcher = request.getRequestDispatcher("/postdetails.jsp");
		requestDispatcher.include(request, response);

	}

	public void saveUser() {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		// Session session = hibernateUtil.getSession();
		// Transaction trans = session.beginTransaction();
		session.beginTransaction();
		try {
			// Transaction trans = session.beginTransaction();
			// session.beginTransaction();

			Category cat1 = new Category();
			// stock.setStockCode("7052");
			cat1.setCategoryName("Fruits");
			Category cat2 = new Category();
			cat2.setCategoryName("Grains");
			Category cat3 = new Category();
			cat3.setCategoryName("Vegetables");
			/*Category cat4 = new Category();
			cat4.setCategoryName("Flowers");*/


			session.save(cat1);
			session.save(cat2);
			session.save(cat3);
		/*	session.save(cat4);*/

			SubCategory sub1 = new SubCategory();
			sub1.setCategoryName("Tomato");
			sub1.setCategory(cat3);
			/*
			 * if (cat1.getSubCategoryRecords() == null) {
			 * cat1.setSubCategoryRecords(new HashSet()); }
			 * cat1.getSubCategoryRecords().add(sub1);
			 */
			session.saveOrUpdate(sub1);

			// cat1.getSubCategoryRecords().add(sub1);

			SubCategory sub2 = new SubCategory();
			sub2.setCategoryName("Potato");
			sub2.setCategory(cat3);
			/*
			 * if (cat1.getSubCategoryRecords() == null) {
			 * cat1.setSubCategoryRecords(new HashSet()); }
			 */
			// cat1.getSubCategoryRecords().add(sub2);
			session.saveOrUpdate(sub2);

			// cat1.getSubCategoryRecords().add(sub2);

			SubCategory sub3 = new SubCategory();
			sub3.setCategoryName("Onions");
			sub3.setCategory(cat3);
			/*
			 * if (cat1.getSubCategoryRecords() == null) {
			 * cat1.setSubCategoryRecords(new HashSet()); }
			 * cat1.getSubCategoryRecords().add(sub3);
			 */
			session.saveOrUpdate(sub3);

			SubCategory sub4 = new SubCategory();
			sub4.setCategoryName("Apple");
			sub4.setCategory(cat1);
			// cat2.getSubCategoryRecords().add(sub4);
			session.saveOrUpdate(sub4);

			SubCategory sub5 = new SubCategory();
			sub5.setCategoryName("Banana");
			sub5.setCategory(cat1);
			// cat2.getSubCategoryRecords().add(sub5);
			session.saveOrUpdate(sub5);

			SubCategory sub6 = new SubCategory();
			sub6.setCategoryName("Orange");
			sub6.setCategory(cat1);
			/*
			 * if(cat2.getSubCategoryRecords() == null) {
			 * cat2.setSubCategoryRecords(new HashSet()); }
			 * cat2.getSubCategoryRecords().add(sub3);
			 */
			session.saveOrUpdate(sub6);

			// cat2.getSubCategoryRecords().add(sub2);

			SubCategory sub7 = new SubCategory();
			sub7.setCategoryName("Rice");
			sub7.setCategory(cat2);
			session.saveOrUpdate(sub7);
			// cat3.getSubCategoryRecords().add(sub7);

			SubCategory sub8 = new SubCategory();
			sub8.setCategoryName("soya");
			sub8.setCategory(cat2);
			session.saveOrUpdate(sub8);
			// cat3.getSubCategoryRecords().add(sub8);

			SubCategory sub9 = new SubCategory();
			sub9.setCategoryName("wheat");
			sub9.setCategory(cat2);
			session.saveOrUpdate(sub9);
			
			SubCategory sub10 = new SubCategory();
			sub10.setCategoryName("Onions");
			sub10.setCategory(cat3);
			
			SubCategory sub11 = new SubCategory();
			sub11.setCategoryName("cherries");
			sub11.setCategory(cat1);


			
			
			
			session.getTransaction().commit();

			List<Category> customerList = new ArrayList<Category>();
			// customerList = getUserByUserEmail(cus.getEmail());

			// cus = (Customer) customerList.get(0);

		} catch (HibernateException e) {
			System.err.println(".HibernateException." + e.getClass().getName() + " -- " + e.getMessage());
			session.getTransaction().rollback();
		}

		finally {
		}
	}

	@SuppressWarnings("unchecked")
	public List<Category> listOfStocks() {
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query custList = null;
		try {
			// String cusQuery = "from Customer where email= "+email;
			custList = session.createQuery("from Category category");

			System.out.println("Category size " + custList.list().size());
			tx.commit();
		} catch (HibernateException ex) {
			System.err.println("HibernateException " + ex.getClass().getName() + "------" + ex.getMessage());
			// session.getTransaction().rollback();
			tx.rollback();

		} finally {
			// HibernateUtil.closeSession(session);
		}

		return custList.list();
		// }

		// session.beginTransaction();
		// System.out.println("In List of Categories
		// size:"+session.createCriteria(Category.class).list().size());
		// return (List<Category>)
		// session.createCriteria(Category.class).list();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectCategory = request.getParameter("method");
		String result = "";
		String finalResponse = "";
		System.out.println("selectCategorymethod" + selectCategory);
		if (selectCategory != null && !selectCategory.equals("")) {
			String categoryid = request.getParameter("categoryid");
			SortedMap<String, SortedMap<String, String>> categoryMap = new TreeMap<String, SortedMap<String, String>>();
			SortedMap<Integer, String> subcategoryMap = getSubCategory(categoryid);
			System.out.println("categoryid**" + categoryid);
			if (subcategoryMap != null) {
				Iterator itr = subcategoryMap.keySet().iterator();
				while (itr.hasNext()) {
					Object optionValue = itr.next();
					System.out.println("optionValue" + optionValue);
					String optionText = subcategoryMap.get(optionValue);
					System.out.println("optionText" + optionText);
					result += "<option Value=" + optionValue + ">" + optionText + "</option>";

				}
				finalResponse += result;
			}
			response.getWriter().write(finalResponse);

		}
		// doGet(request, response);
	}

	public SortedMap<Integer, String> getSubCategory(String subcat) {
		System.out.println("categoryId" + subcat);
		// Session session = hibernateUtil.getSession();
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		SortedMap<Integer, String> subCategoryMap = new TreeMap<Integer, String>();
		// Query custList = null;
		try {
			// List<Person> personList = session.createQuery("FROM
			// Person").list();
			@SuppressWarnings("unchecked")
			int subcategory = Integer.parseInt(subcat);
			@SuppressWarnings("unchecked")
			List<Category> custList = session.createQuery("from Category category where categoryId= :categoryId")
					.setParameter("categoryId", subcategory).list();
			System.out.println("customer List:" + custList.size());

			// for (Iterator iterator = custList.iterator();
			// iterator.hasNext();) {

			for (Iterator<Category> itr = custList.iterator(); itr.hasNext();) {

				Category category = itr.next();

				Set<SubCategory> ph = new HashSet<SubCategory>();

				ph = category.getSubCategoryRecords();
				ph.size();
				System.out.println("subCat size" + ph.size());

				for (SubCategory sb : ph) {

					System.out.println("***************************");

					System.out.println(" Category Id" + sb.getCategory().getCategoryId());
					System.out.println("Sub Category Name " + sb.getCategoryName());

					System.out.println("***************************");
					subCategoryMap.put(sb.getSubcategoryId(), sb.getCategoryName());

				}

				// }

				// String cusQuery = "from Customer where email= "+email;
				/*
				 * custList = session.createQuery(
				 * "from SubCategory subCategory where category= :category"
				 * ).setParameter("category", email) .list();
				 * System.out.println( "SubCategory size " + custList.size());
				 */
				/*
				 * Query query = session.createQuery("from Category"); query =
				 * session.createQuery(
				 * "select s.subCategoryName from Employee e " +
				 * "INNER JOIN e.address a"); List<Object[]> list =
				 * query.list(); for(Object[] arr : list){
				 * System.out.println(Arrays.toString(arr)); }
				 */
			}
			tx.commit();

		} catch (HibernateException ex) {
			System.err.println("HibernateException " + ex.getClass().getName() + "------" + ex.getMessage());
			tx.rollback();

		} finally {
			// HibernateUtil.closeSession(session);
		}
		return subCategoryMap;

		// return custList;

	}
}
