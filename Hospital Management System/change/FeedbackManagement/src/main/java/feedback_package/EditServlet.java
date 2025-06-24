package feedback_package;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// INHERITANCE
// Extends HttpServlet to inherit functionality

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        
        String sid = request.getParameter("id");  
        int id = Integer.parseInt(sid);  
        
        // Get feedback by id from feedbackDao
        feedback e = feedbackDao.getFeedbackById(id);

        // Generate HTML with inline CSS
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Update Feedback</title>");
        
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
        out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); color: var(--text-color); min-height: 100vh; line-height: 1.6; font-size: 16px; }");
        
        // Container styling
        out.println(".page-container { display: flex; justify-content: center; align-items: center; padding: 40px 20px; }");
        out.println(".form-container { background: white; border-radius: var(--border-radius); box-shadow: var(--shadow); width: 100%; max-width: 550px; padding: 40px; margin: 20px 0; position: relative; overflow: hidden; }");
        out.println(".form-container::before { content: \"\"; position: absolute; top: 0; left: 0; width: 100%; height: 5px; background: linear-gradient(90deg, var(--primary-color), var(--primary-light)); }");
        
        // Typography styling
        out.println("h1 { color: var(--primary-color); font-size: 28px; font-weight: 600; margin-bottom: 10px; text-align: center; }");
        out.println(".form-subtitle { font-size: 16px; color: var(--text-light); margin-bottom: 30px; text-align: center; }");
        
        // Form element styling
        out.println(".input-group { position: relative; margin-bottom: 25px; }");
        out.println(".icon { position: absolute; left: 15px; top: 18px; color: var(--primary-color); z-index: 2; }");
        out.println(".input-group input, .input-group textarea { width: 100%; padding: 15px 15px 15px 45px; font-size: 16px; border: 1px solid #ddd; border-radius: 8px; background-color: var(--input-bg); transition: var(--transition); font-family: 'Poppins', sans-serif; }");
        out.println(".input-group textarea { resize: vertical; min-height: 100px; }");
        out.println(".input-group label { position: absolute; left: 45px; top: 16px; color: #888; pointer-events: none; transition: var(--transition); }");
        
        // Form interaction styling
        out.println(".input-group input:focus, .input-group textarea:focus { border-color: var(--primary-color); box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15); outline: none; }");
        out.println(".input-group input:focus + label, .input-group input:not(:placeholder-shown) + label, .input-group textarea:focus + label, .input-group textarea:not(:placeholder-shown) + label, .input-group input[type=\"date\"] + label { top: -10px; left: 15px; font-size: 12px; background-color: white; padding: 0 5px; color: var(--primary-color); }");
        out.println(".input-group input::placeholder, .input-group textarea::placeholder { color: transparent; }");
        
        // Button styling
        out.println(".btn-container { text-align: center; margin-top: 30px; }");
        out.println(".primary-btn { background: linear-gradient(90deg, var(--primary-color), var(--primary-light)); color: white; border: none; padding: 14px 30px; border-radius: 30px; font-size: 16px; font-weight: 500; cursor: pointer; transition: var(--transition); box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3); width: 100%; max-width: 250px; }");
        out.println(".primary-btn:hover { transform: translateY(-3px); box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4); }");
        out.println(".primary-btn:active { transform: translateY(0); }");
        
        // Link styling
        out.println(".link-container { text-align: center; margin-top: 25px; }");
        out.println(".view-link { color: var(--primary-color); text-decoration: none; font-weight: 500; transition: var(--transition); display: inline-flex; align-items: center; gap: 8px; }");
        out.println(".view-link:hover { text-decoration: underline; }");
        
        // Responsive styling
        out.println("@media (max-width: 768px) { .form-container { padding: 30px 20px; } h1 { font-size: 24px; } .input-group input, .input-group textarea { padding: 12px 12px 12px 40px; } .icon { left: 12px; top: 15px; } }");
        
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='page-container'>");
        out.println("<div class='form-container'>");
        out.println("<h1>Update Feedback</h1>");
        out.println("<p class='form-subtitle'>Edit your feedback details below</p>");
        
        out.println("<form action='EditServlet2' method='post'>");
        
        // Hidden ID field
        out.println("<input type='hidden' name='id' value='" + e.getId() + "'/>");
        
        // Customer Name input group
        out.println("<div class='input-group'>");
        out.println("<i class='fas fa-user icon'></i>");
        out.println("<input type='text' id='cname' name='cname' value='" + e.getCname() + "' placeholder=' ' required />");
        out.println("<label for='cname'>Customer Name</label>");
        out.println("</div>");
        
        // Hospital Event Name input group
        out.println("<div class='input-group'>");
        out.println("<i class='fas fa-hospital icon'></i>");
        out.println("<input type='text' id='ename' name='ename' value='" + e.getEname() + "' placeholder=' ' required />");
        out.println("<label for='ename'>Hospital Event Name</label>");
        out.println("</div>");
        
        // Feedback Date input group
        out.println("<div class='input-group'>");
        out.println("<i class='fas fa-calendar icon'></i>");
        out.println("<input type='date' id='fdate' name='fdate' value='" + e.getFdate() + "' required />");
        out.println("<label for='fdate'>Feedback Date</label>");
        out.println("</div>");
        
        // Feedback Comment input group
        out.println("<div class='input-group'>");
        out.println("<i class='fas fa-comment icon'></i>");
        out.println("<textarea id='fcomment' name='fcomment' rows='4' placeholder=' ' required>" + e.getFcomment() + "</textarea>");
        out.println("<label for='fcomment'>Feedback Comment</label>");
        out.println("</div>");
        
        // Submit button
        out.println("<div class='btn-container'>");
        out.println("<button type='submit' class='primary-btn'>Update & Save</button>");
        out.println("</div>");
        
        out.println("</form>");
        
        // Back link
        out.println("<div class='link-container'>");
        out.println("<a href='ViewServlet' class='view-link'>");
        out.println("<i class='fas fa-arrow-left'></i> Back to Feedback List");
        out.println("</a>");
        out.println("</div>");
        
        out.println("</div>");
        out.println("</div>");
        
        out.println("</body>");
        out.println("</html>");

        out.close();  
    }
}
