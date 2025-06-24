<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Feedback</title>
    
    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="CSS/feedback.css">
</head>
<body>
    <div class="page-container">
        <div class="form-container">
            <h1>Add New Feedback</h1>
            <p class="form-subtitle">We appreciate your thoughts and suggestions</p>
            
            <form action="SaveServlet" method="post" onsubmit="return validateForm()">
                
                <!-- Customer Name -->
                <div class="input-group">
                    <i class="fas fa-user icon"></i>
                    <input type="text" id="cname" name="cname" required 
                           pattern="[A-Za-z\s]{2,50}" 
                           title="Only letters and spaces allowed. Min 2, max 50 characters.">
                    <label for="cname">Customer Name</label>
                </div>
                
                <!-- Hospital Event Name -->
                <div class="input-group">
                    <i class="fas fa-hospital icon"></i>
                    <input type="text" id="ename" name="ename" required 
                           pattern="[A-Za-z0-9\s]{2,100}" 
                           title="Letters, numbers and spaces allowed. Min 2 characters.">
                    <label for="ename">Hospital Event Name</label>
                </div>
                
                <!-- Feedback Date (auto-filled) -->
                <div class="input-group">
                    <i class="fas fa-calendar icon"></i>
                    <input type="hidden" id="fdate" name="fdate" />
                    <input type="text" id="fdateDisplay" disabled />
                    <label for="fdateDisplay">Feedback Date</label>
                </div>
                
                <!-- Feedback Comment -->
                <div class="input-group">
                    <i class="fas fa-comment icon"></i>
                    <textarea id="fcomment" name="fcomment" rows="4" required 
                              minlength="10" maxlength="500"
                              title="Comment must be between 10 and 500 characters."></textarea>
                    <label for="fcomment">Feedback Comment</label>
                </div>
                
                <!-- Submit Button -->
                <div class="btn-container">
                    <button type="submit" class="primary-btn">Save Feedback</button>
                </div>
            </form>
            
            <!-- View Feedbacks Link -->
            <div class="link-container">
                <a href="ViewServlet" class="view-link">
                    <i class="fas fa-eye"></i> View All Feedbacks
                </a>
            </div>
        </div>
    </div>

    <!-- JavaScript: Auto-fill today's date -->
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const today = new Date().toISOString().split('T')[0];
            document.getElementById("fdate").value = today;
            document.getElementById("fdateDisplay").value = today;
        });

        // Optional: JavaScript validation layer (in addition to HTML5)
        function validateForm() {
            const cname = document.getElementById("cname").value.trim();
            const ename = document.getElementById("ename").value.trim();
            const comment = document.getElementById("fcomment").value.trim();

            if (cname.length < 2 || !/^[A-Za-z\s]+$/.test(cname)) {
                alert("Please enter a valid customer name.");
                return false;
            }
            if (ename.length < 2 || !/^[A-Za-z0-9\s]+$/.test(ename)) {
                alert("Please enter a valid event name.");
                return false;
            }
            if (comment.length < 10) {
                alert("Feedback comment must be at least 10 characters long.");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
