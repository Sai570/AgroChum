package com.cap.util;

import java.util.List;

import org.hibernate.Session;

import entites.Customer;
import entity.model.Category;
import entity.model.PostItemsDetails;

public class AgrochumHelper {

	@SuppressWarnings("unchecked")
	public Integer getCurrentCustomerId(String email) {

		List<Customer> userList = null;
		Integer UserId;
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		userList = session.createQuery("from Customer where email = :email").setParameter("email", email).list();

		// loginBean = (LoginBean) query.uniqueResult();
		System.out.println("UserList" + userList.size());

		UserId = (int) userList.get(0).getCustomerid();

		return UserId;

	}

	@SuppressWarnings("unchecked")
	public List<PostItemsDetails> getSearchCategory(Integer categoryId) {
		List<PostItemsDetails> postDetails = null;
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		/*List<Category> categoryList = session.createQuery("from Category where categoryName = :categoryName").setParameter("categoryName", selectedCat).list();
		categoryId = categoryList.get(0).getCategoryId();
		System.out.println("categoryid**" + categoryId);
*/
		postDetails = (List<PostItemsDetails>)session.createQuery("from PostItemsDetails where categoryid = :categoryid order by postDate DESC").setParameter("categoryid", categoryId).list();

		System.out.println(" In getSearchCategory postDetails size" + postDetails.size());
		return postDetails;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PostItemsDetails> getPostDetails(Integer postId) {
		List<PostItemsDetails> postDetails = null;
		HibernateUtil hibernateUtil = new HibernateUtil();
		Session session = hibernateUtil.getSession();
		
		postDetails = (List<PostItemsDetails>)session.createQuery("from PostItemsDetails where postId = :postId").setParameter("postId", postId).list();

		System.out.println(" In postDetails size" + postDetails.size());
		return postDetails;
	}


}
