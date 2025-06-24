package payment_package;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/ViewServlet")
// INHERITANCE (extends HttpServlet)
public class ViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 // POLYMORPHISM (method overriding)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        // ENCAPSULATION (parameter handling)
        // Get the search query parameter from the request
        String searchQuery = request.getParameter("search");
        List<Payment> list;
        
        // If a search query is provided, use it to filter results
        if (searchQuery != null && !searchQuery.isEmpty()) {
            list = PaymentDao.searchPaymentsByName(searchQuery);
        } else {
            // Otherwise, get all payments
            list = PaymentDao.getAllPayments();
        }

        // Start HTML document with styling
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>All Payments</title>");
        out.println("    <link rel='preconnect' href='https://fonts.googleapis.com'>");
        out.println("    <link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>");
        out.println("    <link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap' rel='stylesheet'>");
        out.println("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css'>");
        out.println("    <style>");
        out.println("        * { padding: 0; margin: 0; box-sizing: border-box; }");
        out.println("        :root {");
        out.println("            --primary-color: #4361ee;");
        out.println("            --primary-light: #4895ef;");
        out.println("            --secondary-color: #3f37c9;");
        out.println("            --text-color: #333;");
        out.println("            --text-light: #555;");
        out.println("            --background-color: #f8f9fa;");
        out.println("            --error-color: #e63946;");
        out.println("            --success-color: #06d6a0;");
        out.println("            --shadow: 0 10px 30px rgba(0, 0, 0, 0.1);");
        out.println("            --border-radius: 12px;");
        out.println("            --transition: all 0.3s ease;");
        out.println("        }");
        out.println("        ::-webkit-scrollbar { width: 8px; }");
        out.println("        ::-webkit-scrollbar-track { background: var(--background-color); }");
        out.println("        ::-webkit-scrollbar-thumb { background: var(--primary-color); border-radius: 6px; }");
        out.println("        ::-webkit-scrollbar-thumb:hover { background: var(--secondary-color); }");
        out.println("        body {");
        out.println("            font-family: 'Poppins', sans-serif;");
        out.println("            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);");
        out.println("            color: var(--text-color);");
        out.println("            min-height: 100vh;");
        out.println("            line-height: 1.6;");
        out.println("            font-size: 16px;");
        out.println("            padding: 20px;");
        out.println("        }");
        out.println("        .page-container {");
        out.println("            max-width: 1200px;");
        out.println("            margin: 0 auto;");
        out.println("            padding: 20px;");
        out.println("        }");
        out.println("        .content-card {");
        out.println("            background: white;");
        out.println("            border-radius: var(--border-radius);");
        out.println("            box-shadow: var(--shadow);");
        out.println("            padding: 30px;");
        out.println("            margin-bottom: 30px;");
        out.println("            position: relative;");
        out.println("            overflow: hidden;");
        out.println("        }");
        out.println("        .content-card::before {");
        out.println("            content: \"\";");
        out.println("            position: absolute;");
        out.println("            top: 0;");
        out.println("            left: 0;");
        out.println("            width: 100%;");
        out.println("            height: 5px;");
        out.println("            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));");
        out.println("        }");
        out.println("        h1 {");
        out.println("            color: var(--primary-color);");
        out.println("            font-size: 28px;");
        out.println("            font-weight: 600;");
        out.println("            margin-bottom: 20px;");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        h3 {");
        out.println("            color: var(--text-light);");
        out.println("            font-size: 18px;");
        out.println("            margin-bottom: 15px;");
        out.println("        }");
        out.println("        .search-container {");
        out.println("            display: flex;");
        out.println("            margin-bottom: 30px;");
        out.println("            max-width: 600px;");
        out.println("            margin-left: auto;");
        out.println("            margin-right: auto;");
        out.println("        }");
        out.println("        .search-container input[type='text'] {");
        out.println("            flex: 1;");
        out.println("            padding: 12px 15px;");
        out.println("            border: 1px solid #ddd;");
        out.println("            border-radius: 8px 0 0 8px;");
        out.println("            font-family: 'Poppins', sans-serif;");
        out.println("            font-size: 16px;");
        out.println("            transition: var(--transition);");
        out.println("        }");
        out.println("        .search-container input[type='text']:focus {");
        out.println("            border-color: var(--primary-color);");
        out.println("            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);");
        out.println("            outline: none;");
        out.println("        }");
        out.println("        .search-container button {");
        out.println("            background: var(--primary-color);");
        out.println("            color: white;");
        out.println("            border: none;");
        out.println("            padding: 0 20px;");
        out.println("            border-radius: 0 8px 8px 0;");
        out.println("            cursor: pointer;");
        out.println("            transition: var(--transition);");
        out.println("            display: flex;");
        out.println("            align-items: center;");
        out.println("            justify-content: center;");
        out.println("        }");
        out.println("        .search-container button:hover {");
        out.println("            background: var(--secondary-color);");
        out.println("        }");
        out.println("        table {");
        out.println("            width: 100%;");
        out.println("            border-collapse: separate;");
        out.println("            border-spacing: 0;");
        out.println("            margin-bottom: 30px;");
        out.println("            overflow: hidden;");
        out.println("            border-radius: 8px;");
        out.println("        }");
        out.println("        table thead {");
        out.println("            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));");
        out.println("            color: white;");
        out.println("        }");
        out.println("        table th {");
        out.println("            text-align: left;");
        out.println("            padding: 15px;");
        out.println("            font-weight: 500;");
        out.println("            font-size: 14px;");
        out.println("            text-transform: uppercase;");
        out.println("            letter-spacing: 0.5px;");
        out.println("        }");
        out.println("        table td {");
        out.println("            padding: 15px;");
        out.println("            border-bottom: 1px solid #eee;");
        out.println("            font-size: 14px;");
        out.println("        }");
        out.println("        table tbody tr {");
        out.println("            background-color: #fff;");
        out.println("            transition: var(--transition);");
        out.println("        }");
        out.println("        table tbody tr:hover {");
        out.println("            background-color: #f6f9fc;");
        out.println("        }");
        out.println("        table tr:last-child td {");
        out.println("            border-bottom: none;");
        out.println("        }");
        out.println("        .button {");
        out.println("            display: inline-block;");
        out.println("            padding: 8px 16px;");
        out.println("            border-radius: 30px;");
        out.println("            text-decoration: none;");
        out.println("            font-weight: 500;");
        out.println("            font-size: 14px;");
        out.println("            transition: var(--transition);");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        .button.edit {");
        out.println("            background-color: var(--primary-light);");
        out.println("            color: white;");
        out.println("        }");
        out.println("        .button.delete {");
        out.println("            background-color: var(--error-color);");
        out.println("            color: white;");
        out.println("        }");
        out.println("        .button.edit:hover {");
        out.println("            background-color: var(--primary-color);");
        out.println("            box-shadow: 0 4px 8px rgba(67, 97, 238, 0.2);");
        out.println("        }");
        out.println("        .button.delete:hover {");
        out.println("            background-color: #d62828;");
        out.println("            box-shadow: 0 4px 8px rgba(230, 57, 70, 0.2);");
        out.println("        }");
        out.println("        .add-payment {");
        out.println("            display: inline-block;");
        out.println("            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));");
        out.println("            color: white;");
        out.println("            padding: 14px 30px;");
        out.println("            border-radius: 30px;");
        out.println("            text-decoration: none;");
        out.println("            font-weight: 500;");
        out.println("            font-size: 16px;");
        out.println("            transition: var(--transition);");
        out.println("            box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);");
        out.println("            display: flex;");
        out.println("            align-items: center;");
        out.println("            justify-content: center;");
        out.println("            gap: 8px;");
        out.println("            max-width: 200px;");
        out.println("            margin: 0 auto;");
        out.println("        }");
        out.println("        .add-payment:hover {");
        out.println("            transform: translateY(-3px);");
        out.println("            box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4);");
        out.println("        }");
        out.println("        .empty-message {");
        out.println("            text-align: center;");
        out.println("            padding: 40px 0;");
        out.println("            color: var(--text-light);");
        out.println("            font-size: 18px;");
        out.println("        }");
        out.println("        footer {");
        out.println("            margin-top: 40px;");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        @media (max-width: 768px) {");
        out.println("            .page-container { padding: 10px; }");
        out.println("            .content-card { padding: 20px 15px; }");
        out.println("            h1 { font-size: 24px; }");
        out.println("            table { display: block; overflow-x: auto; }");
        out.println("            table th, table td { padding: 12px 10px; }");
        out.println("            .button { padding: 6px 12px; font-size: 13px; }");
        out.println("        }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='page-container'>");
        out.println("        <div class='content-card'>");
        out.println("            <h1>Payments List</h1>");
        
        // Search form with better styling
        out.println("            <form action='ViewServlet' method='get'>");
        out.println("                <div class='search-container'>");
        out.println("                    <input type='text' name='search' placeholder='Search by name' value='" + (searchQuery != null ? searchQuery : "") + "'/>");
        out.println("                    <button type='submit'><i class='fas fa-search'></i></button>");
        out.println("                </div>");
        out.println("            </form>");
        
        if (searchQuery != null && !searchQuery.isEmpty()) {
            out.println("            <h3>Search Results for: '" + searchQuery + "'</h3>");
        }
        
        // Display payment records in a styled table
        if (list.size() > 0) {
            out.println("            <div class='table-responsive'>");
            out.println("                <table>");  
            out.println("                    <thead>");
            out.println("                        <tr>");
            out.println("                            <th>ID</th>");
            out.println("                            <th>Full Name</th>");
            out.println("                            <th>Email</th>");
            out.println("                            <th>Phone</th>");
            out.println("                            <th>Medicine</th>");
            out.println("                            <th>Qty</th>");
            out.println("                            <th>Method</th>");
            out.println("                            <th>Amount (LKR)</th>");
            out.println("                            <th>Edit</th>");
            out.println("                            <th>Delete</th>");
            out.println("                        </tr>");
            out.println("                    </thead>");
            out.println("                    <tbody>");
            
            for (Payment e : list) {  
                out.println("                        <tr>");
                out.println("                            <td>" + e.getId() + "</td>");
                out.println("                            <td>" + e.getName() + "</td>");
                out.println("                            <td>" + e.getEmail() + "</td>");
                out.println("                            <td>" + e.getPhone() + "</td>");
                out.println("                            <td>" + e.getMedicine() + "</td>");
                out.println("                            <td>" + e.getQuantity() + "</td>");
                out.println("                            <td>" + e.getMethod() + "</td>");
                out.println("                            <td>" + e.getAmount() + "</td>");
                out.println("                            <td><a class='button edit' href='EditServlet?id=" + e.getId() + "'><i class='fas fa-edit'></i> Edit</a></td>");
                out.println("                            <td><a class='button delete' href='DeleteServlet?id=" + e.getId() + "'><i class='fas fa-trash'></i> Delete</a></td>");
                out.println("                        </tr>");
            }
            
            out.println("                    </tbody>");
            out.println("                </table>");
            out.println("            </div>");
        } else {
            // Show a message when no payments are found
            out.println("            <div class='empty-message'>");
            out.println("                <i class='fas fa-info-circle'></i> No payment records found.");
            out.println("            </div>");
        }
        
        out.println("        </div>");
        
        // Add New Payment button with improved styling
        out.println("        <footer>");
        out.println("            <a href='index.jsp' class='add-payment'>");
        out.println("                <i class='fas fa-plus'></i> Add New Payment");
        out.println("            </a>");
        out.println("        </footer>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();  
    }  
}
