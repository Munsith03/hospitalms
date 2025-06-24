package com.profile;


import java.io.IOException;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */

// INHERITANCE (extends HttpServlet)
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieving parameters from the request
		String id = request.getParameter("id");
		String uname = request.getParameter("uname");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String cnumber = request.getParameter("cnumber");
		String type = request.getParameter("type");
		String password = request.getParameter("password");
		
		
		boolean isTrue;
		
		 // Updating customer details and getting the status of the operation
		isTrue = ProfileDBUtil.updatecustomer(id,uname,dob,address,email,cnumber,type,password);
		if(isTrue == true) {
			
			List<Profile> cusDetails = ProfileDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			// Forwarding the request to the Details.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("Details.jsp");
			dis.forward(request, response);
		}
		else {
			List<Profile> cusDetails = ProfileDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
		 // Forwarding the request to the Details.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("Details.jsp");
			dis.forward(request, response);
		}
	}

}
