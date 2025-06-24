package feedback_package;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// METHOD OVERRIDING
    // Overrides parent class's implementation   
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        
			// ENCAPSULATION
        	// Using request object to access encapsulated parameters
			response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	        String cname=request.getParameter("cname");  
	        String ename=request.getParameter("ename");  
	        String fdate=request.getParameter("fdate");  
	        String fcomment=request.getParameter("fcomment");  

	          
	        feedback e=new feedback();  
	        e.setId(id);  
	        e.setCname(cname);  
	        e.setEname(ename);  
	        e.setFdate(fdate);  
	        e.setFcomment(fcomment);  

	          
	        int status=feedbackDao.update(e);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  

}
