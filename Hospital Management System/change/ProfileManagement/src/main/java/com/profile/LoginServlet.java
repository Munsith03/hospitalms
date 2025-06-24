package com.profile;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class LoginServlet
 */

// INHERITANCE (extends HttpServlet)
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ENCAPSULATION (parameter retrieval)
		// Retrieving parameters from the request
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			// Calling the UserDBUtil to fetch customer details based on name and email
			List<Profile> cusDetails = ProfileDBUtil.validate(email,password);
			request.setAttribute("cusDetails", cusDetails);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// Forwarding the request to the Details.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("Details.jsp");
			dis.forward(request, response);
	}

}
