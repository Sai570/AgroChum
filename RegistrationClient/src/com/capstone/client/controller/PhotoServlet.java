package com.capstone.client.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.model.PostItemsDetails;

/**
 * Servlet implementation class PhotoServlet
 */
@WebServlet("/PhotoServlet")
public class PhotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	try {
	
	//	int id =  Integer.parseInt(request.getParameter("id"));
		
		
		
		
		
		
		
		/*String filename = id+".jpg";
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sarasu10");	
		Statement st1=con.createStatement();
	    System.out.println("id is*************"+id);
	   
	    String strQuery = "select image from postitems where post_id="+id;
	  
	    ResultSet rs1 = st1.executeQuery(strQuery);
	    System.out.println("id is*************"+id);
	    //rs1.getInt();
	    String imgLen="";
	    if(rs1.next())
	    {
	      imgLen = rs1.getString("image");
	      System.out.println("imgLen"+imgLen.length());
	    }  
	    rs1 = st1.executeQuery(strQuery);
	    if(rs1.next())
	    {
	      int len = imgLen.length();
	      byte [] rb = new byte[len];
	      InputStream readImg = rs1.getBinaryStream("image");
	      int index=readImg.read(rb, 0, len);
	      System.out.println("index***"+index);
	      
	      st1.close();
	      response.reset();
	      response.setContentType("image/jpg");
	      response.setHeader("Content-disposition","attachment; filename=" +filename);
	      response.setContentLength(rb.length);
	      response.resetBuffer();
	     response.reset();
	      response.getOutputStream().write(rb,0,len); 
	*/
		//response.setContentType("image/jpeg");
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/test";
		final String User = "root";
		final String Password = "sarasu10";
		try {
			Class.forName(JDBC_DRIVER);
			Connection conn = DriverManager.getConnection(DB_URL, User, Password);
			// long id = Integer.parseInt(request.getParameter("id"));
			PreparedStatement stmt = conn.prepareStatement("select image from PostItemsDetails where post_id=?");

			// System.out.println("Id***" + request.getParameter("id"));
			String imgLen = "";
			// String filename = id + ".jpg";
			System.out.println("Post id **"+request.getParameter("id"));
		//	 stmt.setLong(1, Long.valueOf(request.getParameter("id")));
			//stmt.setLong(1, 1);
			stmt.setInt(1, Integer.parseInt(request.getParameter("id")));
			ResultSet rs = stmt.executeQuery();
			
		//	 ResultSet rs = ps.executeQuery();
	            rs.next();
	            Blob  b = rs.getBlob("image");
	            System.out.println("b length***"+b.length());
	            response.setContentType("image/jpeg");
	            response.setContentLength( (int) b.length());
	           // response.setContentLength(10);
	            InputStream is = b.getBinaryStream();
	            OutputStream os = response.getOutputStream();
	            byte buf[] = new byte[(int) b.length()];
	            System.out.println("Buffer length"+b.length());
	            is.read(buf);
	            os.write(buf);
	            os.close();
		
		/*	if (rs.next()) {
			System.out.println("get Bytes"+rs.getBytes(1));	

				response.getOutputStream().write(rs.getBytes(1));

			}
			*/
			conn.close();
		//} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		

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
