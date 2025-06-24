<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Your Appointment Details</title>
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

        .details-container {
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

        .details-container::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 5px;
            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
        }

        .appointment-card {
            margin-bottom: 30px;
        }

        .appointment-header {
            display: flex;
            align-items: center;
            margin-bottom: 25px;
        }

        .appointment-id {
            background: var(--primary-light);
            color: white;
            padding: 8px 15px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 500;
            margin-right: 15px;
        }

        .appointment-title {
            font-size: 20px;
            color: var(--text-color);
            font-weight: 600;
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

        textarea.detail-value {
            resize: none;
            min-height: 100px;
        }

        .appointment-reason {
            grid-column: span 2;
        }

        @media (max-width: 600px) {
            .appointment-reason {
                grid-column: span 1;
            }
        }

        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-top: 30px;
        }

        .btn {
            padding: 12px 25px;
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

        .btn-update {
            background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
            color: white;
            box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);
        }

        .btn-update:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4);
        }

        .btn-delete {
            background-color: white;
            color: var(--error-color);
            border: 1px solid var(--error-color);
        }

        .btn-delete:hover {
            background-color: var(--error-color);
            color: white;
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
    </style>
</head>
<body>
    <h1>Your Appointment Details</h1>

    <div class="details-container">
        <c:forEach var="cus" items="${cusDetails}">
            <c:set var="id" value="${cus.id}" />
            <c:set var="patientName" value="${cus.patientName}" />
            <c:set var="patientAge" value="${cus.patientAge}" />
            <c:set var="gender" value="${cus.gender}" />
            <c:set var="contactNumber" value="${cus.contactNumber}" />
            <c:set var="email" value="${cus.email}" />
            <c:set var="doctorName" value="${cus.doctorName}" />
            <c:set var="specialization" value="${cus.specialization}" />
            <c:set var="appointmentDate" value="${cus.appointmentDate}" />
            <c:set var="reasonForVisit" value="${cus.reasonForVisit}" />
            
            <div class="appointment-card">
                <div class="appointment-header">
                    <div class="appointment-id">#${cus.id}</div>
                    <div class="appointment-title">${cus.patientName}'s Appointment</div>
                </div>
                
                <div class="details-grid">
                    <div class="detail-group">
                        <label class="detail-label">Patient Name</label>
                        <input type="text" class="detail-value" value="${cus.patientName}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Patient Age</label>
                        <input type="number" class="detail-value" value="${cus.patientAge}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Gender</label>
                        <input type="text" class="detail-value" value="${cus.gender}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Contact Number</label>
                        <input type="tel" class="detail-value" value="${cus.contactNumber}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Email Address</label>
                        <input type="email" class="detail-value" value="${cus.email}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Doctor Name</label>
                        <input type="text" class="detail-value" value="${cus.doctorName}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Specialization</label>
                        <input type="text" class="detail-value" value="${cus.specialization}" readonly />
                    </div>
                    
                    <div class="detail-group">
                        <label class="detail-label">Appointment Date</label>
                        <input type="date" class="detail-value" value="${cus.appointmentDate}" readonly />
                    </div>
                    
                    <div class="detail-group appointment-reason">
                        <label class="detail-label">Reason for Visit</label>
                        <textarea class="detail-value" rows="4" readonly>${cus.reasonForVisit}</textarea>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        <!-- Create URLs for update and delete actions -->
        <c:url value="Update.jsp" var="cusupdate">
            <c:param name="id" value="${id}"/>
            <c:param name="patientName" value="${patientName}"/>
            <c:param name="patientAge" value="${patientAge}"/>
            <c:param name="gender" value="${gender}"/>
            <c:param name="contactNumber" value="${contactNumber}"/>
            <c:param name="email" value="${email}"/>
            <c:param name="doctorName" value="${doctorName}"/>
            <c:param name="specialization" value="${specialization}"/>
            <c:param name="appointmentDate" value="${appointmentDate}"/>
            <c:param name="reasonForVisit" value="${reasonForVisit}"/>
        </c:url>

        <c:url value="Delete.jsp" var="cusdelete">
            <c:param name="id" value="${id}"/>
            <c:param name="patientName" value="${patientName}"/>
            <c:param name="patientAge" value="${patientAge}"/>
            <c:param name="gender" value="${gender}"/>
            <c:param name="contactNumber" value="${contactNumber}"/>
            <c:param name="email" value="${email}"/>
            <c:param name="doctorName" value="${doctorName}"/>
            <c:param name="specialization" value="${specialization}"/>
            <c:param name="appointmentDate" value="${appointmentDate}"/>
            <c:param name="reasonForVisit" value="${reasonForVisit}"/>
        </c:url>

        <div class="action-buttons">
            <a href="${cusupdate}">
                <button class="btn btn-update">
                    <i class="fas fa-edit"></i> Update Appointment
                </button>
            </a>
            <a href="${cusdelete}">
                <button class="btn btn-delete">
                    <i class="fas fa-trash-alt"></i> Delete Appointment
                </button>
            </a>
        </div>
        
        <a href="Search.jsp" class="back-link">
            <i class="fas fa-arrow-left"></i> Back to All Appointments
        </a>
    </div>
</body>
</html>
