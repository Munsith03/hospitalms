<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Update Your Appointment Details</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        /* Base reset and general styles */
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        :root {
            --primary-color: #4361ee;
            --primary-light: #4895ef;
            --secondary-color: #3f37c9;
            --text-color: #333;
            --text-light: #555;
            --background-color: #f8f9fa;
            --error-color: #e63946;
            --success-color: #06d6a0;
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

        form {
            width: 100%;
        }

        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0 15px;
        }

        td {
            padding: 5px 0;
        }

        td:first-child {
            width: 40%;
            font-size: 14px;
            color: var(--text-light);
            padding-right: 15px;
        }

        input, select, textarea {
            width: 100%;
            padding: 12px 15px;
            border-radius: 8px;
            border: 1px solid #ddd;
            font-family: 'Poppins', sans-serif;
            font-size: 15px;
            color: var(--text-color);
            background-color: var(--input-bg);
            transition: var(--transition);
        }

        input:focus, select:focus, textarea:focus {
            outline: none;
            border-color: var(--primary-color);
            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);
        }

        input:read-only {
            background-color: #e9ecef;
            cursor: not-allowed;
        }

        textarea {
            resize: vertical;
            min-height: 100px;
        }

        .btncls {
            margin-top: 30px;
            display: flex;
            justify-content: center;
        }

        button {
            padding: 12px 40px;
            border-radius: 30px;
            border: none;
            font-family: 'Poppins', sans-serif;
            font-weight: 500;
            font-size: 16px;
            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
            color: white;
            cursor: pointer;
            transition: var(--transition);
            display: flex;
            align-items: center;
            gap: 10px;
            box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);
        }

        button:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4);
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        @media (max-width: 600px) {
            .container {
                padding: 30px 20px;
            }
            
            td {
                display: block;
                width: 100%;
            }
            
            td:first-child {
                margin-bottom: 5px;
            }
        }
    </style>
</head>
<body>
  
  <%-- Retrieving parameters from the request --%>
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

    <h1>Update Your Appointment Details</h1>
    <div class="container">
        <form action="update" method="post">
          <table>
            <tr>
              <td>Appointment ID</td>
              <td><input type="text" id="id" name="id" required value="<%= id %>" readonly /></td>
            </tr>

            <!-- Patient Details -->
            <tr>
              <td>Patient Name</td>
              <td><input type="text" name="patientName" pattern="[A-Za-z\s]+" title="Only letters and spaces are allowed." required value="<%= patientName %>" /></td>
            </tr>
            <tr>
              <td>Patient Age</td>
              <td><input type="number" name="patientAge" min="0" max="120" title="Age should be between 0 and 120." required value="<%= patientAge %>" /></td>
            </tr>
            <tr>
              <td>Gender</td>
              <td>
                <select name="gender" required>
                  <option value="">Select Gender</option>
                  <option value="Male" <%= "Male".equals(gender) ? "selected" : "" %>>Male</option>
                  <option value="Female" <%= "Female".equals(gender) ? "selected" : "" %>>Female</option>
                  <option value="Other" <%= "Other".equals(gender) ? "selected" : "" %>>Other</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Contact Number</td>
              <td><input type="tel" name="contactNumber" pattern="\d{10}" title="Please enter a 10-digit phone number." required value="<%= contactNumber %>" /></td>
            </tr>
            <tr>
              <td>Email</td>
              <td><input type="email" name="email" title="Please enter a valid email address." required value="<%= email %>" /></td>
            </tr>

            <!-- Appointment Details -->
            <tr>
              <td>Doctor Name</td>
              <td><input type="text" name="doctorName" pattern="[A-Za-z\s]+" title="Only letters and spaces are allowed." required value="<%= doctorName %>" /></td>
            </tr>
            <tr>
              <td>Specialization</td>
              <td>
                <select name="specialization" required>
                  <option value="">Select Specialization</option>
                  <option value="General Medicine" <%= "General Medicine".equals(specialization) ? "selected" : "" %>>General Medicine</option>
                  <option value="Cardiology" <%= "Cardiology".equals(specialization) ? "selected" : "" %>>Cardiology</option>
                  <option value="Dermatology" <%= "Dermatology".equals(specialization) ? "selected" : "" %>>Dermatology</option>
                  <option value="Pediatrics" <%= "Pediatrics".equals(specialization) ? "selected" : "" %>>Pediatrics</option>
                  <option value="Orthopedics" <%= "Orthopedics".equals(specialization) ? "selected" : "" %>>Orthopedics</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Appointment Date</td>
              <td><input type="date" name="appointmentDate" min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" title="Please choose a future date." required value="<%= appointmentDate %>" /></td>
            </tr>
           
            <tr>
              <td>Reason for Visit</td>
              <td><textarea name="reasonForVisit" rows="4" minlength="10" maxlength="500" title="Reason should be between 10 and 500 characters." required><%= reasonForVisit %></textarea></td>
            </tr>
          </table>
          
          <div class="btncls">
            <button type="submit"><i class="fas fa-save"></i> Update Appointment</button>
          </div>
        </form>
        
        <a href="Details.jsp" class="back-link">
            <i class="fas fa-arrow-left"></i> Back to Appointment Details
        </a>
    </div>
</body>
</html>
