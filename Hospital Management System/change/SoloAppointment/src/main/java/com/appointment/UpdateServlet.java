package com.appointment;

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
		String patientName = request.getParameter("patientName");
		String patientAge = request.getParameter("patientAge");
		String gender = request.getParameter("gender");
		String contactNumber = request.getParameter("contactNumber");
		String email = request.getParameter("email");
		String doctorName = request.getParameter("doctorName");
		String specialization = request.getParameter("specialization");
		String appointmentDate = request.getParameter("appointmentDate");
		String reasonForVisit = request.getParameter("reasonForVisit");
		
		boolean isTrue;
		
		 // Updating customer details and getting the status of the operation
		isTrue = AppointmentDBUtil.updateCustomer(id, patientName,patientAge,gender,contactNumber,email,doctorName,specialization,appointmentDate,reasonForVisit);
		if(isTrue == true) {
			
			List<Appointment> cusDetails = AppointmentDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			// Forwarding the request to the Details.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("Details.jsp");
			dis.forward(request, response);
		}
		else {
			List<Appointment> cusDetails = AppointmentDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
		 // Forwarding the request to the Details.jsp page
			RequestDispatcher dis = request.getRequestDispatcher("Details.jsp");
			dis.forward(request, response);
		}
	}

}
