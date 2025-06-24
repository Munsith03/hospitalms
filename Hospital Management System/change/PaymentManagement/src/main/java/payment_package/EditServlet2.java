package payment_package;

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

// INHERITANCE (extends HttpServlet)
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// METHOD OVERRIDING - Polymorphism
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	          throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        
	        // ABSTRACTION (parameter handling)
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);  
	       
	        // ENCAPSULATION (getting parameters through request object)
	        String name=request.getParameter("name");  
	        String email=request.getParameter("email");  
	        String phone=request.getParameter("phone");  
	        String medicine=request.getParameter("medicine");  
	        String quantity=request.getParameter("quantity");  
	        String method=request.getParameter("method");  
	        String amount=request.getParameter("amount");  

	        
	        Payment e=new Payment();  
	        e.setId(id);  
	        e.setName(name);  
	        e.setEmail(email);  
	        e.setPhone(phone);  
	        e.setMedicine(medicine);  
	        e.setQuantity(quantity);  
	        e.setMethod(method);  
	        e.setAmount(amount);  

	          
	        int status=PaymentDao.update(e);  
	        if(status>0){  
	            response.sendRedirect("ViewServlet");  
	        }else{  
	            out.println("Sorry! unable to update record");  
	        }  
	          
	        out.close();  
	    }  
	  
	} 