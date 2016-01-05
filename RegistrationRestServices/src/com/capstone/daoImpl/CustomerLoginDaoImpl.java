package com.capstone.daoImpl;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capstone.dao.CustomerLoginDao;
import com.capstone.model.Customer;
import com.capstone.model.LoginBean;
import com.capstone.util.HibernateUtil;

public class CustomerLoginDaoImpl implements CustomerLoginDao {

	@Override
	public String authenticateUser(LoginBean login) {
		
		
		JSONObject jsonObj = new JSONObject();
		String email = login.getEmail();
		String pwd = "";
		String password = login.getPassword();
		System.out.println("password******"+password);
		RequestDispatcher requestDispatcher;

		HibernateUtil hibernateUtil = new HibernateUtil();

		Session session = hibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		try{
		List<Customer> userList =null;
		userList = session.createQuery("from Customer where email = :email").setParameter("email", email).list();
		
		LoginBean loginBean = null;
		//loginBean = (LoginBean) query.uniqueResult();
		System.out.println("UserList"+userList.size());
		
		pwd = userList.get(0).getPassword();
		System.out.println("Password from datbase****"+ pwd);
		
		trans.commit();
				} catch (HibernateException e) {
			System.err.println(".HibernateException." + e.getClass().getName() + " -- " + e.getMessage());
			trans.rollback();
		}

		finally {
			HibernateUtil.closeSession(session);
		}
		if(password.equals(pwd)){
			
			return "{\"status\":\"loginSuccess\"}";
		}else{
		
		 return "{\"status\":\"loginFail\"}";
		}


			}
}
