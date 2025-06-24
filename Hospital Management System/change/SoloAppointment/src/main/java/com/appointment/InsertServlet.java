package com.appointment;

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
		
		// ENCAPSULATION
		// Retrieving parameters from the request
		String patientName = request.getParameter("patientName");
		String patientAge = request.getParameter("patientAge");
		String gender = request.getParameter("gender");
		String contactNumber = request.getParameter("contactNumber");
		String email = request.getParameter("email");
		String doctorName = request.getParameter("doctorName");
		String specialization = request.getParameter("specialization");
		String appointmentDate = request.getParameter("appointmentDate");
		String reasonForVisit = request.getParameter("reasonForVisit");

		// Inserting customer data and getting the status of the operation
		boolean isTrue;
		
		isTrue = AppointmentDBUtil.insertCustomer(patientName,patientAge,gender,contactNumber,email,doctorName,specialization,appointmentDate,reasonForVisit);
		
		// Forwarding the request to the appropriate JSP based on the insertion status
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Search.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
