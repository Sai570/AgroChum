package com.capstone.client.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*String email = (String) request.getSession().getAttribute("email");
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

		HibernateUtil hibernateUtil = new HibernateUtil();

		Session session = hibernateUtil.getSession();
		Transaction trans = session.beginTransaction();
		try{
		List<Customer> userList =null;
		userList = session.createQuery("from Customer where email = :email").setParameter("email", email).list();
		
		//LoginBean loginBean = null;
		//loginBean = (LoginBean) query.uniqueResult();
		System.out.println("UserList"+userList.size());
		
		pwd = userList.get(0).getPassword();

		
		
		
		
		
		
*/		
	/*int postId= (int)request.getSession().getAttribute("postId");
	System.out.println("postId in payment"+postId);*/
		
		
		
		String cardholderName = request.getParameter("CardHolderName");
		String CreditCardNumber = request.getParameter("CreditCardNumber");
		String ExpiryDate = request.getParameter("ExpiryDate");
		String cvv = request.getParameter("CVV");
		
		String payementDetails = paymentMode(cardholderName,CreditCardNumber,ExpiryDate,cvv);
		System.out.println("payementDetails"+payementDetails);
		RequestDispatcher requestDispatcher = null;
		if(payementDetails!=null){
			request.setAttribute("message", payementDetails);
			requestDispatcher = request.getRequestDispatcher("/payement_details.jsp");
		}
		
		requestDispatcher.include(request, response);
	}

	private String paymentMode(String cardholderName, String creditCardNumber, String expiryDate, String cvv) {
		if(cardholderName!=null&&creditCardNumber!=null&&expiryDate!=null&& cvv!=null){
			
		}
		return "Payment SuccessFull!!";
	}

}
