package com.capstone.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.capstone.dao.CustomerDao;
import com.capstone.model.Customer;
import com.capstone.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {

	HibernateUtil hibernateUtil = new HibernateUtil();

	@SuppressWarnings("unchecked")
	public List<Customer> listUsers() {
		return (List<Customer>) hibernateUtil.getSession().createCriteria(Customer.class).list();
	}

	@Override
	public int saveUser(String fname, String lname, String email,String password) {
		Session session = hibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		Customer cus = new Customer();

		try {
			cus.setFirstname(fname);
			cus.setLastname(lname);
			cus.setEmail(email);
		//	cus.setGender(gender);
			cus.setPassword(password);
		//	cus.setContactNumber(c_number);
		//	cus.setRegDate(new Date());
		//	cus.setDOB(dob);

			session.saveOrUpdate(cus);
			trans.commit();

			List<Customer> customerList = new ArrayList<Customer>();
			customerList = getUserByUserEmail(cus.getEmail());

			cus = (Customer) customerList.get(0);
			
		} catch (HibernateException e) {
			System.err.println(".HibernateException." + e.getClass().getName() + " -- " + e.getMessage());
			trans.rollback();
		}

		finally {
			HibernateUtil.closeSession(session);
		}

		/*
		 * System.out.println("list size" + l.size()); Customer u = (Customer)
		 * l.get(0); System.out.println("custId" + u.getCustomerid());
		 * 
		 * System.out.println("CustomerId" + u.getCustomerid());
		 */ // trans.commit();
		return cus.getCustomerid();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getUserByUserEmail(String email) {
		System.out.println("Email" + email);
		Session session = hibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List custList = null;
		try {
			// String cusQuery = "from Customer where email= "+email;
			custList = session.createQuery("from Customer where email= :email").setParameter("email", email).list();
			System.out.println("Customer size " + custList.size());
			tx.commit();
		} catch (HibernateException ex) {
			System.err.println("HibernateException " + ex.getClass().getName() + "------" + ex.getMessage());
			tx.rollback();

		} finally {
			HibernateUtil.closeSession(session);
		}

		return custList;
	}

}
