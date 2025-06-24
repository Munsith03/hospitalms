<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Delete Your Appointment</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <script type="text/javascript">
        function confirmDelete() {
            return confirm("Are you sure you want to delete this appointment record?");
        }
    </script>
    <style>
        /* Base reset and general styles */
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        :root {
            --primary-color: #e63946; /* Red tone for delete action */
            --primary-light: #ff6b6b;
            --secondary-color: #d00000;
            --text-color: #333;
            --text-light: #555;
            --background-color: #f8f9fa;
            --shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            --border-radius: 12px;
            --input-bg: #f8f9fa;
            --transition: all 0.3s ease;
        }

        /* Scrollbar styling */
        ::-webkit-scrollbar {
            width: 8px;
        }

        ::-webkit-scrollbar-track {
            background: var(--background-color);
        }

        ::-webkit-scrollbar-thumb {
            background: var(--primary-color);
            border-radius: 6px;
        }

        ::-webkit-scrollbar-thumb:hover {
            background: var(--secondary-color);
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            color: var(--text-color);
            min-height: 100vh;
            line-height: 1.6;
            font-size: 16px;
            padding: 40px 20px;
        }

        h1 {
            color: var(--primary-color);
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 30px;
            text-align: center;
        }

        .container {
            background: white;
            border-radius: var(--border-radius);
            box-shadow: var(--shadow);
            width: 100%;
            max-width: 700px;
            margin: 0 auto;
            padding: 40px;
            position: relative;
            overflow: hidden;
        }

        .container::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 5px;
            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
        }

        .warning-banner {
            background-color: rgba(230, 57, 70, 0.1);
            border-left: 4px solid var(--primary-color);
            padding: 15px;
            margin-bottom: 25px;
            border-radius: 6px;
            display: flex;
            align-items: center;
        }

        .warning-banner i {
            color: var(--primary-color);
            font-size: 20px;
            margin-right: 10px;
        }

        .warning-text {
            color: var(--text-color);
            font-size: 15px;
        }

        .details-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
        }

        @media (max-width: 600px) {
            .details-grid {
                grid-template-columns: 1fr;
            }
        }

        .detail-group {
            margin-bottom: 15px;
        }

        .detail-label {
            display: block;
            color: var(--text-light);
            font-size: 14px;
            margin-bottom: 5px;
        }

        .detail-value {
            font-weight: 500;
            color: var(--text-color);
            background-color: var(--input-bg);
            padding: 12px 15px;
            border-radius: 8px;
            border: 1px solid #ddd;
            width: 100%;
            font-family: 'Poppins', sans-serif;
        }

        .reason-for-visit {
            grid-column: span 2;
        }

        @media (max-width: 600px) {
            .reason-for-visit {
                grid-column: span 1;
            }
        }

        textarea.detail-value {
            resize: none;
            min-height: 100px;
        }

        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-top: 30px;
        }

        .btn {
            padding: 12px 30px;
            border-radius: 30px;
            border: none;
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            font-size: 16px;
            cursor: pointer;
            transition: var(--transition);
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .btn-delete {
            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
            color: white;
            box-shadow: 0 4px 15px rgba(230, 57, 70, 0.3);
        }

        .btn-delete:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(230, 57, 70, 0.4);
        }

        .btn-cancel {
            background-color: white;
            color: var(--text-color);
            border: 1px solid #ddd;
        }

        .btn-cancel:hover {
            background-color: #f8f9fa;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: var(--text-color);
            text-decoration: none;
            font-weight: 500;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<%
    String id = request.getParameter("id");
    String patientName = request.getParameter("patientName");
    String patientAge = request.getParameter("patientAge");
    String gender = request.getParameter("gender");
    String contactNumber = request.getParameter("contactNumber");
    String email = request.getParameter("email");
    String doctorName = request.getParameter("doctorName");
    String specialization = request.getParameter("specialization");
    String appointmentDate = request.getParameter("appointmentDate");
    String reasonForVisit = request.getParameter("reasonForVisit");
%>

    <h1>Delete Appointment</h1>
    <div class="container">
        <div class="warning-banner">
            <i class="fas fa-exclamation-triangle"></i>
            <div class="warning-text">
                You are about to delete this appointment. This action cannot be undone. Please confirm to proceed.
            </div>
        </div>

        <form action="DeleteServlet" method="post" onsubmit="return confirmDelete();">
            <div class="details-grid">
                <div class="detail-group">
                    <label class="detail-label">Appointment ID</label>
                    <input type="text" class="detail-value" name="id" value="<%= id %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Patient Name</label>
                    <input type="text" class="detail-value" name="patientName" value="<%= patientName %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Patient Age</label>
                    <input type="text" class="detail-value" name="patientAge" value="<%= patientAge %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Gender</label>
                    <input type="text" class="detail-value" name="gender" value="<%= gender %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Contact Number</label>
                    <input type="text" class="detail-value" name="contactNumber" value="<%= contactNumber %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Email</label>
                    <input type="email" class="detail-value" name="email" value="<%= email %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Doctor Name</label>
                    <input type="text" class="detail-value" name="doctorName" value="<%= doctorName %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Specialization</label>
                    <input type="text" class="detail-value" name="specialization" value="<%= specialization %>" readonly />
                </div>
                
                <div class="detail-group">
                    <label class="detail-label">Appointment Date</label>
                    <input type="text" class="detail-value" name="appointmentDate" value="<%= appointmentDate %>" readonly />
                </div>
                
                <div class="detail-group reason-for-visit">
                    <label class="detail-label">Reason for Visit</label>
                    <textarea class="detail-value" name="reasonForVisit" readonly><%= reasonForVisit %></textarea>
                </div>
            </div>
            
            <div class="action-buttons">
                <button type="submit" class="btn btn-delete">
                    <i class="fas fa-trash-alt"></i> Confirm Delete
                </button>
                <a href="Search.jsp" class="btn btn-cancel">
                    <i class="fas fa-times"></i> Cancel
                </a>
            </div>
        </form>
        
        <a href="Search.jsp" class="back-link">
            <i class="fas fa-arrow-left"></i> Back to Appointment Details
        </a>
    </div>
</body>
</html>
