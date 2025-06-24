package com.profile;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertServlet
 */

// INHERITANCE (extends HttpServlet)
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieving parameters from the request
		String uname = request.getParameter("uname");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String cnumber = request.getParameter("cnumber");
		String type = request.getParameter("type");
		String password = request.getParameter("password");

		
		
		// Inserting customer data and getting the status of the operation
		boolean isTrue;
		
		isTrue = ProfileDBUtil.insertcustomer(uname,dob,address,email,cnumber,type,password);
		
		// Forwarding the request to the appropriate JSP based on the insertion status
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
