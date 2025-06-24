package feedback_package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	  // METHOD OVERRIDING
      // Custom implementation of parent's doPost() method
	  @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	// ENCAPSULATION
	        // Accessing request parameters through getParameter() method
		  	response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        // Retrieve form parameters
	        String cname = request.getParameter("cname");
	        String ename = request.getParameter("ename");
	        String fdate = request.getParameter("fdate");
	        String fcomment = request.getParameter("fcomment");


	        // Create an event object and set properties
	        feedback e = new feedback();
	        e.setCname(cname);
	        e.setEname(ename);
	        e.setFdate(fdate);
	        e.setFcomment(fcomment);


	        // Save the event using eventDao
	        int status = feedbackDao.save(e);
	        
	        // Check if the save was successful
	        if (status > 0) {
	            // Redirect to ViewServlet to show the saved data
	            response.sendRedirect("ViewServlet");
	        } else {
	            out.println("Sorry! Unable to save the record.");
	        }

	        out.close();
	    }

}