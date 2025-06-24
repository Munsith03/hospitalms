package payment_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        Payment e = PaymentDao.getPaymentById(id);

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("    <meta charset='UTF-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("    <title>Edit Payment Details</title>");
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
        out.println("            --input-bg: #f8f9fa;");
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
        out.println("        }");
        out.println("        .page-container {");
        out.println("            display: flex;");
        out.println("            justify-content: center;");
        out.println("            align-items: center;");
        out.println("            padding: 40px 20px;");
        out.println("        }");
        out.println("        .form-container {");
        out.println("            background: white;");
        out.println("            border-radius: var(--border-radius);");
        out.println("            box-shadow: var(--shadow);");
        out.println("            width: 100%;");
        out.println("            max-width: 550px;");
        out.println("            padding: 40px;");
        out.println("            margin: 20px auto;");
        out.println("            position: relative;");
        out.println("            overflow: hidden;");
        out.println("        }");
        out.println("        .form-container::before {");
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
        out.println("            margin-bottom: 10px;");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        .form-subtitle {");
        out.println("            font-size: 16px;");
        out.println("            color: var(--text-light);");
        out.println("            margin-bottom: 30px;");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        .input-group {");
        out.println("            position: relative;");
        out.println("            margin-bottom: 25px;");
        out.println("        }");
        out.println("        .icon {");
        out.println("            position: absolute;");
        out.println("            left: 15px;");
        out.println("            top: 50%;");
        out.println("            transform: translateY(-50%);");
        out.println("            color: var(--primary-color);");
        out.println("            z-index: 2;");
        out.println("        }");
        out.println("        .input-group input, .input-group select {");
        out.println("            width: 100%;");
        out.println("            padding: 15px 15px 15px 45px;");
        out.println("            font-size: 16px;");
        out.println("            border: 1px solid #ddd;");
        out.println("            border-radius: 8px;");
        out.println("            background-color: var(--input-bg);");
        out.println("            transition: var(--transition);");
        out.println("            font-family: 'Poppins', sans-serif;");
        out.println("        }");
        out.println("        .input-group label {");
        out.println("            position: absolute;");
        out.println("            left: 45px;");
        out.println("            top: 50%;");
        out.println("            transform: translateY(-50%);");
        out.println("            color: #888;");
        out.println("            pointer-events: none;");
        out.println("            transition: var(--transition);");
        out.println("        }");
        out.println("        .input-group input:focus, .input-group select:focus {");
        out.println("            border-color: var(--primary-color);");
        out.println("            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);");
        out.println("            outline: none;");
        out.println("        }");
        out.println("        .input-group input:focus + label,");
        out.println("        .input-group input:not(:placeholder-shown) + label,");
        out.println("        .input-group select:focus + label,");
        out.println("        .input-group select:not([value=\"\"]):valid + label {");
        out.println("            top: 0;");
        out.println("            left: 15px;");
        out.println("            font-size: 12px;");
        out.println("            background-color: white;");
        out.println("            padding: 0 5px;");
        out.println("            color: var(--primary-color);");
        out.println("        }");
        out.println("        .input-group input::placeholder {");
        out.println("            color: transparent;");
        out.println("        }");
        out.println("        .hint {");
        out.println("            font-size: 12px;");
        out.println("            color: var(--text-light);");
        out.println("            margin-top: 5px;");
        out.println("            display: block;");
        out.println("            margin-left: 45px;");
        out.println("        }");
        out.println("        .btn-container {");
        out.println("            text-align: center;");
        out.println("            margin-top: 30px;");
        out.println("            display: flex;");
        out.println("            justify-content: space-between;");
        out.println("            gap: 15px;");
        out.println("        }");
        out.println("        .primary-btn {");
        out.println("            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));");
        out.println("            color: white;");
        out.println("            border: none;");
        out.println("            padding: 14px 30px;");
        out.println("            border-radius: 30px;");
        out.println("            font-size: 16px;");
        out.println("            font-weight: 500;");
        out.println("            cursor: pointer;");
        out.println("            transition: var(--transition);");
        out.println("            box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);");
        out.println("            flex: 1;");
        out.println("        }");
        out.println("        .cancel-btn {");
        out.println("            background: #f1f1f1;");
        out.println("            color: var(--text-color);");
        out.println("            border: none;");
        out.println("            padding: 14px 30px;");
        out.println("            border-radius: 30px;");
        out.println("            font-size: 16px;");
        out.println("            font-weight: 500;");
        out.println("            cursor: pointer;");
        out.println("            transition: var(--transition);");
        out.println("            flex: 1;");
        out.println("            text-decoration: none;");
        out.println("            text-align: center;");
        out.println("        }");
        out.println("        .primary-btn:hover {");
        out.println("            transform: translateY(-3px);");
        out.println("            box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4);");
        out.println("        }");
        out.println("        .cancel-btn:hover {");
        out.println("            background: #e9e9e9;");
        out.println("        }");
        out.println("        @media (max-width: 768px) {");
        out.println("            .form-container { padding: 30px 20px; }");
        out.println("            h1 { font-size: 24px; }");
        out.println("            .input-group input, .input-group select { padding: 12px 12px 12px 40px; }");
        out.println("            .icon { left: 12px; }");
        out.println("            .btn-container { flex-direction: column; }");
        out.println("        }");
        out.println("    </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class='page-container'>");
        out.println("        <div class='form-container'>");
        out.println("            <h1>Edit Payment Details</h1>");
        out.println("            <p class='form-subtitle'>Update your payment information below</p>");

        out.println("            <form action='EditServlet2' method='post' onsubmit='return validateForm()'>");
        out.println("                <input type='hidden' name='id' value='" + e.getId() + "'/>");

        // Full Name Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-user icon'></i>");
        out.println("                    <input type='text' id='name' name='name' value='" + e.getName() + "' required placeholder=' '/>");
        out.println("                    <label for='name'>Full Name</label>");
        out.println("                    <span class='hint'>Only letters and spaces</span>");
        out.println("                </div>");

        // Email Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-envelope icon'></i>");
        out.println("                    <input type='email' id='email' name='email' value='" + e.getEmail() + "' required placeholder=' '/>");
        out.println("                    <label for='email'>Email Address</label>");
        out.println("                </div>");

        // Phone Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-phone icon'></i>");
        out.println("                    <input type='text' id='phone' name='phone' value='" + e.getPhone() + "' required placeholder=' '/>");
        out.println("                    <label for='phone'>Phone Number</label>");
        out.println("                    <span class='hint'>10 digit phone number</span>");
        out.println("                </div>");

        // Medicine Name Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-pills icon'></i>");
        out.println("                    <input type='text' id='medicine' name='medicine' value='" + e.getMedicine() + "' required placeholder=' '/>");
        out.println("                    <label for='medicine'>Medicine Name</label>");
        out.println("                </div>");

        // Quantity Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-sort-amount-up icon'></i>");
        out.println("                    <input type='number' id='quantity' name='quantity' value='" + e.getQuantity() + "' min='1' required placeholder=' '/>");
        out.println("                    <label for='quantity'>Quantity</label>");
        out.println("                </div>");

        // Payment Method Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-credit-card icon'></i>");
        out.println("                    <select id='method' name='method' required>");
        out.println("                        <option value='Card Payment' " + ("Card Payment".equals(e.getMethod()) ? "selected" : "") + ">Card Payment</option>");
        out.println("                        <option value='Paypal' " + ("Paypal".equals(e.getMethod()) ? "selected" : "") + ">Paypal</option>");
        out.println("                        <option value='Cash on Delivery' " + ("Cash on Delivery".equals(e.getMethod()) ? "selected" : "") + ">Cash on Delivery</option>");
        out.println("                    </select>");
        out.println("                    <label for='method'>Payment Method</label>");
        out.println("                </div>");

        // Amount Field
        out.println("                <div class='input-group'>");
        out.println("                    <i class='fas fa-money-bill-wave icon'></i>");
        out.println("                    <input type='text' id='amount' name='amount' value='" + e.getAmount() + "' required placeholder=' '/>");
        out.println("                    <label for='amount'>Payment Amount (LKR)</label>");
        out.println("                </div>");

        // Buttons
        out.println("                <div class='btn-container'>");
        out.println("                    <a href='ViewServlet' class='cancel-btn'>Cancel</a>");
        out.println("                    <button type='submit' class='primary-btn'>Save Changes</button>");
        out.println("                </div>");
        out.println("            </form>");
        out.println("        </div>");
        out.println("    </div>");

        // JavaScript for validation
        out.println("    <script>");
        out.println("        function validateForm() {");
        out.println("            // Validate name - only letters and spaces");
        out.println("            const name = document.getElementById('name').value;");
        out.println("            const namePattern = /^[A-Za-z\\s]+$/;");
        out.println("            if (!namePattern.test(name)) {");
        out.println("                alert('Name should contain only letters and spaces');");
        out.println("                return false;");
        out.println("            }");

        out.println("            // Validate email");
        out.println("            const email = document.getElementById('email').value;");
        out.println("            if (!email.includes('@')) {");
        out.println("                alert('Please enter a valid email address');");
        out.println("                return false;");
        out.println("            }");

        out.println("            // Validate phone - 10 digits only");
        out.println("            const phone = document.getElementById('phone').value;");
        out.println("            const phonePattern = /^\\d{10}$/;");
        out.println("            if (!phonePattern.test(phone)) {");
        out.println("                alert('Phone number must be exactly 10 digits');");
        out.println("                return false;");
        out.println("            }");

        out.println("            // Validate medicine name - only letters and spaces");
        out.println("            const medicine = document.getElementById('medicine').value;");
        out.println("            if (!namePattern.test(medicine)) {");
        out.println("                alert('Medicine name should contain only letters and spaces');");
        out.println("                return false;");
        out.println("            }");

        out.println("            // Validate amount - only numbers and decimal point");
        out.println("            const amount = document.getElementById('amount').value;");
        out.println("            const amountPattern = /^\\d+(\\.\\d{1,2})?$/;");
        out.println("            if (!amountPattern.test(amount)) {");
        out.println("                alert('Please enter a valid amount (e.g., 100 or 100.50)');");
        out.println("                return false;");
        out.println("            }");

        out.println("            return true;");
        out.println("        }");

        out.println("        // Live input validation");
        out.println("        document.getElementById('name').addEventListener('input', function() {");
        out.println("            this.value = this.value.replace(/[^A-Za-z\\s]/g, '');");
        out.println("        });");

        out.println("        document.getElementById('phone').addEventListener('input', function() {");
        out.println("            this.value = this.value.replace(/[^0-9]/g, '');");
        out.println("            if (this.value.length > 10) {");
        out.println("                this.value = this.value.substring(0, 10);");
        out.println("            }");
        out.println("        });");

        out.println("        document.getElementById('medicine').addEventListener('input', function() {");
        out.println("            this.value = this.value.replace(/[^A-Za-z\\s]/g, '');");
        out.println("        });");

        out.println("        document.getElementById('amount').addEventListener('input', function() {");
        out.println("            this.value = this.value.replace(/[^0-9.]/g, '');");
        out.println("        });");
        out.println("    </script>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
