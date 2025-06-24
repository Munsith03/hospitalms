<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Delete Account</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="CSS/delete.css" />
    
    <script type="text/javascript">
        function confirmDelete() {
            return confirm("Are you sure you want to delete this account? This action cannot be undone.");
        }
    </script>
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
        <div class="form-container delete-container">
            <div class="warning-icon">
                <i class="fas fa-exclamation-triangle"></i>
            </div>
            <h1>Delete Account</h1>
            <p class="form-subtitle">Please review your information before confirming deletion</p>

            <form action="DeleteCustomerServlet" method="post" onsubmit="return confirmDelete();">
                <div class="input-group">
                    <i class="fas fa-id-card icon"></i>
                    <input type="text" id="id" name="id" value="<%= id %>" readonly />
                    <label for="id">ID</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-user icon"></i>
                    <input type="text" id="username" name="uname" value="<%= uname %>" readonly />
                    <label for="username">Username</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-calendar icon"></i>
                    <input type="date" id="bday" name="dob" value="<%= dob %>" readonly />
                    <label for="bday">DOB</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-map-marker-alt icon"></i>
                    <input type="text" id="address" name="address" value="<%= address %>" readonly />
                    <label for="address">Address</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-envelope icon"></i>
                    <input type="email" id="email" name="email" value="<%= email %>" readonly />
                    <label for="email">Email</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-phone icon"></i>
                    <input type="text" id="phone" name="cnumber" value="<%= cnumber %>" readonly />
                    <label for="phone">Contact Number</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-users icon"></i>
                    <input type="text" id="type" name="type" value="<%= type %>" readonly />
                    <label for="type">Type</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-lock icon"></i>
                    <input type="password" id="password" name="password" value="<%= password %>" readonly />
                    <label for="password">Password</label>
                </div>

                <div class="alert-message">
                    <i class="fas fa-exclamation-circle"></i>
                    <p>Warning: This action will permanently delete your account and cannot be undone.</p>
                </div>

                <div class="btn-container">
                    <button type="submit" class="delete-btn">Delete Account</button>
                    <a href="Login.jsp" class="cancel-btn">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
