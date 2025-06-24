package feedback_package;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

// INHERITANCE
// Extends HttpServlet to inherit web servlet capabilities
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // METHOD OVERRIDING
    // Custom implementation of parent's doGet() method
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Feedback List</title>");
        
        // Add Google Fonts
        out.println("<link rel='preconnect' href='https://fonts.googleapis.com'>");
        out.println("<link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap' rel='stylesheet'>");
        
        // Font Awesome for icons
        out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css'>");
        
        // Inline CSS
        out.println("<style>");
        out.println("* { padding: 0; margin: 0; box-sizing: border-box; }");
        out.println(":root { --primary-color: #4361ee; --primary-light: #4895ef; --secondary-color: #3f37c9; --text-color: #333; --text-light: #555; --background-color: #f8f9fa; --error-color: #e63946; --success-color: #06d6a0; --shadow: 0 10px 30px rgba(0, 0, 0, 0.1); --border-radius: 12px; --input-bg: #f8f9fa; --transition: all 0.3s ease; }");

        // Scrollbar styling
        out.println("::-webkit-scrollbar { width: 8px; }");
        out.println("::-webkit-scrollbar-track { background: var(--background-color); }");
        out.println("::-webkit-scrollbar-thumb { background: var(--primary-color); border-radius: 6px; }");
        out.println("::-webkit-scrollbar-thumb:hover { background: var(--secondary-color); }");

        // Body styling
        out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); color: var(--text-color); min-height: 100vh; line-height: 1.6; font-size: 16px; padding: 20px; }");

        // Page container
        out.println(".page-container { max-width: 1200px; margin: 0 auto; padding: 20px; }");
        
        // Header styling
        out.println("h1 { color: var(--primary-color); font-size: 32px; font-weight: 600; margin-bottom: 30px; text-align: center; position: relative; padding-bottom: 15px; }");
        out.println("h1::after { content: ''; position: absolute; bottom: 0; left: 50%; transform: translateX(-50%); width: 80px; height: 4px; background: linear-gradient(90deg, var(--primary-color), var(--primary-light)); border-radius: 2px; }");
        
        // Table styling
        out.println(".table-container { background: white; border-radius: var(--border-radius); box-shadow: var(--shadow); overflow: hidden; margin-bottom: 30px; }");
        out.println("table { width: 100%; border-collapse: collapse; text-align: left; }");
        out.println("th { background: rgba(67, 97, 238, 0.1); color: var(--primary-color); font-weight: 600; padding: 15px; position: relative; }");
        out.println("td { padding: 15px; border-bottom: 1px solid #f0f0f0; }");
        out.println("tr:last-child td { border-bottom: none; }");
        out.println("tr:hover td { background-color: rgba(67, 97, 238, 0.05); }");
        
        // Button styling
        out.println(".button { display: inline-block; padding: 8px 16px; background: var(--primary-color); color: white; text-decoration: none; border-radius: 30px; font-size: 14px; font-weight: 500; transition: var(--transition); text-align: center; }");
        out.println(".button:hover { background: var(--secondary-color); transform: translateY(-2px); box-shadow: 0 4px 10px rgba(67, 97, 238, 0.2); }");
        out.println(".edit-btn { background: #4361ee; }");
        out.println(".delete-btn { background: #e63946; }");
        
        // Footer styling
        out.println(".footer { text-align: center; margin-top: 30px; }");
        out.println(".add-btn { background: linear-gradient(90deg, var(--primary-color), var(--primary-light)); padding: 12px 24px; font-size: 16px; box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3); }");
        out.println(".add-btn:hover { transform: translateY(-3px); box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4); }");
        out.println(".add-btn i { margin-right: 8px; }");
        
        // Responsive styling
        out.println("@media (max-width: 768px) {");
        out.println("  .page-container { padding: 15px; }");
        out.println("  table { display: block; overflow-x: auto; }");
        out.println("  th, td { padding: 12px 10px; }");
        out.println("  h1 { font-size: 26px; }");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='page-container'>");
        out.println("<h1>Feedback List</h1>");
        
        // Fetch all feedback records
        List<feedback> list = feedbackDao.getAllFeedbacks();
        
        out.println("<div class='table-container'>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Customer Name</th>");
        out.println("<th>Hospital Event</th>");
        out.println("<th>Date</th>");
        out.println("<th>Feedback</th>");
        out.println("<th>Edit</th>");
        out.println("<th>Delete</th>");
        out.println("</tr>");
        
        for(feedback e : list){  
            out.println("<tr>");
            out.println("<td>" + e.getId() + "</td>");
            out.println("<td>" + e.getCname() + "</td>");
            out.println("<td>" + e.getEname() + "</td>");
            out.println("<td>" + e.getFdate() + "</td>");
            out.println("<td>" + e.getFcomment() + "</td>");
            out.println("<td><a class='button edit-btn' href='EditServlet?id=" + e.getId() + "'><i class='fas fa-edit'></i> Edit</a></td>");
            out.println("<td><a class='button delete-btn' href='DeleteServlet?id=" + e.getId() + "'><i class='fas fa-trash'></i> Delete</a></td>");
            out.println("</tr>");
        }  
        
        out.println("</table>");
        out.println("</div>");
        
        // Footer with button to add new feedback
        out.println("<div class='footer'>");
        out.println("<a class='button add-btn' href='index.jsp'><i class='fas fa-plus'></i> Add New Feedback</a>");
        out.println("</div>");
        
        out.println("</div>"); // End of page-container
        out.println("</body>");
        out.println("</html>");
        
        out.close();  
    }  
}
