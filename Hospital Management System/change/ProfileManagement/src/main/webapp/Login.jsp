<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Page</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="CSS/login.css" />
</head>
<body>
    <!-- Include the header.jsp -->


    <div class="page-container">
        <div class="form-container">
            <h1>Welcome Back</h1>
            <p class="form-subtitle">Please log in to your account</p>
            
            <form action="login" method="post">
                <div class="input-group">
                    <i class="fas fa-envelope icon"></i>
                    <input type="email" id="email" name="email" required />
                    <label for="email">Email</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-lock icon"></i>
                    <input type="password" id="password" name="password" required />
                    <label for="password">Password</label>
                </div>

                <div class="btn-container">
                    <button type="submit" class="primary-btn">Login</button>
                </div>
            </form>
            
            <div class="link-container">
                <p>Don't have an account?</p>
                <a href="Insert.jsp" class="signup-link">Sign Up</a>
            </div>
        </div>
    </div>
</body>
</html>
