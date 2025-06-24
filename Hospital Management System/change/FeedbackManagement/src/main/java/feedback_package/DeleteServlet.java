package feedback_package;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    // METHOD OVERRIDING
    // Provides specific implementation of parent's doGet()
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
		
		// DATA ENCAPSULATION
	    // Accessing parameters through request object's methods
		String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        feedbackDao.delete(id);  
        response.sendRedirect("ViewServlet");  
    }  

}
