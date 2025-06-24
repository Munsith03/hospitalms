<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Your Details</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="CSS/insert.css" />
    <!-- Add password validation styles -->
    <style>
        .password-requirements {
            margin-top: 10px;
            font-size: 0.8rem;
        }
        .password-requirements ul {
            padding-left: 20px;
            margin: 5px 0;
        }
        .password-requirements li {
            color: #ff6b6b;
        }
        .password-requirements li.valid {
            color: #51cf66;
        }
    </style>
</head>
<body>
    <%-- Retrieving parameters from the request --%>
    <%
      String id = request.getParameter("id");
      String uname = request.getParameter("uname");
      String dob = request.getParameter("dob");  
      String phone = request.getParameter("phone");
      String address = request.getParameter("address");
      String email = request.getParameter("email");
      String cnumber = request.getParameter("cnumber");
      String type = request.getParameter("type");
      String password = request.getParameter("password");
    %>

    <div class="page-container">
        <div class="form-container">
            <h1>Update Your Details</h1>
            <p class="form-subtitle">Update your account information below</p>
            
            <form action="update" method="post">
                <div class="input-group">
                    <i class="fas fa-id-card icon"></i>
                    <input type="text" id="id" name="id" value="<%= id %>" readonly />
                    <label for="id">ID</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-user icon"></i>
                    <input type="text" id="username" name="uname" pattern="[A-Za-z0-9]{5,20}" required value="<%= uname %>" />
                    <label for="username">Username</label>
                    <span class="hint">5-20 characters, letters and numbers only</span>
                </div>

                <div class="input-group">
                    <i class="fas fa-calendar icon"></i>
                    <input type="date" id="bday" name="dob" required value="<%= dob %>" />
                    <label for="bday">DOB</label>
                    <span class="hint">Cannot be a future date</span>
                </div>

                <div class="input-group">
                    <i class="fas fa-map-marker-alt icon"></i>
                    <input type="text" id="address" name="address" maxlength="100" required value="<%= address %>" />
                    <label for="address">Address</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-envelope icon"></i>
                    <input type="email" id="email" name="email" required value="<%= email %>" />
                    <label for="email">Email</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-phone icon"></i>
                    <input type="text" id="phone" name="cnumber" pattern="[0-9]{10}" required value="<%= cnumber %>" />
                    <label for="phone">Contact Number</label>
                    <span class="hint">10 digits only</span>
                </div>

                <div class="input-group">
                    <i class="fas fa-users icon"></i>
                    <select id="type" name="type" required>
                        <option value="Customer" <%= type.equals("Customer") ? "selected" : "" %>>Customer</option>
                        <option value="Staff" <%= type.equals("Staff") ? "selected" : "" %>>Staff</option>
                    </select>
                    <label for="type">Type</label>
                </div>

                <div class="input-group">
                   
                    <input type="password" id="password" name="password"
                           pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#._-])[A-Za-z\d@$!%*?&#._-]{8,20}$"
                           minlength="8" maxlength="20" required value="<%= password %>" />
                    <label for="password">Password</label>
                    <span class="hint">8-20 characters: must include uppercase & lowercase letters, numbers and symbols</span>
                </div>

                <div class="btn-container">
                    <button type="submit" class="primary-btn">Update Information</button>
                </div>
            </form>
        </div>
    </div>
    
    <script>
        // Set max date to today
        const today = new Date().toISOString().split('T')[0];
        document.getElementById('bday').setAttribute('max', today);
        
        // Add validation to ensure date is not in the future
        document.getElementById('bday').addEventListener('change', function() {
            const selectedDate = new Date(this.value);
            const currentDate = new Date();
            
            if (selectedDate > currentDate) {
                alert('Date of birth cannot be in the future');
                this.value = '';
            }
        });

        // Password validation
        document.addEventListener('DOMContentLoaded', function() {
            const passwordInput = document.getElementById('password');
            const passwordGroup = passwordInput.parentNode;

            // Create validation feedback element
            const feedback = document.createElement('div');
            feedback.className = 'password-requirements';
            feedback.innerHTML = `
                <p>Password must contain:</p>
                <ul>
                    <li id="length">8-20 characters</li>
                    <li id="lowercase">Lowercase letter</li>
                    <li id="uppercase">Uppercase letter</li>
                    <li id="number">Number</li>
                    <li id="symbol">Symbol (@$!%*?&#._-)</li>
                </ul>
            `;
            passwordGroup.appendChild(feedback);

            // Check password as user types
            passwordInput.addEventListener('input', validatePassword);
            
            // Validate initial password value
            validatePassword();

            function validatePassword() {
                const password = passwordInput.value;

                // Check requirements
                const requirements = {
                    length: password.length >= 8 && password.length <= 20,
                    lowercase: /[a-z]/.test(password),
                    uppercase: /[A-Z]/.test(password),
                    number: /[0-9]/.test(password),
                    symbol: /[@$!%*?&#._-]/.test(password)
                };

                // Update feedback visuals
                for (const [req, valid] of Object.entries(requirements)) {
                    const element = document.getElementById(req);
                    if (valid) {
                        element.classList.add('valid');
                    } else {
                        element.classList.remove('valid');
                    }
                }
            }
        });
    </script>
</body>
</html>
