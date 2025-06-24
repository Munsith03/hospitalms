package payment_package;

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

// INHERITANCE (extends HttpServlet)
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException {  
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	          
	        // ENCAPSULATION (accessing parameters through request object)
	        String name=request.getParameter("name");  
	        String email=request.getParameter("email");  
	        String phone=request.getParameter("phone");  
	        String medicine=request.getParameter("medicine");  
	        String quantity=request.getParameter("quantity");  
	        String method=request.getParameter("method");  
	        String amount=request.getParameter("amount");  

	        // OBJECT CREATION
	        Payment e=new Payment();  
	        e.setName(name);  
	        e.setEmail(email);  
	        e.setPhone(phone);  
	        e.setMedicine(medicine);  
	        e.setQuantity(quantity);
	        e.setMethod(method); 
	        e.setAmount(amount); 

	        
	          
	        int status=PaymentDao.save(e);  
	        if(status>0){  
	        	 response.sendRedirect("ViewServlet");
	        }else{  
	            out.println("Sorry! unable to save record");  
	        }  
	          
	        out.close();  
	    }  
	  
	}  