<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Your Profile Details</title>
    <!-- Add Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="CSS/display.css" />
</head>
<body>
    <!-- Include the header.jsp -->
 

    <div class="page-container">
        <div class="profile-container">
            <h1>Your Profile Details</h1>
            <p class="profile-subtitle">Review your account information below</p>

            <c:forEach var="cus" items="${cusDetails}">
                <c:set var="id" value="${cus.id}" />
                <c:set var="uname" value="${cus.uname}" />
                <c:set var="dob" value="${cus.dob}" />
                <c:set var="address" value="${cus.address}" />
                <c:set var="email" value="${cus.email}" />
                <c:set var="cnumber" value="${cus.cnumber}" />
                <c:set var="type" value="${cus.type}" />
                <c:set var="password" value="${cus.password}" />

                <div class="details-grid">
                    <div class="detail-group">
                        <i class="fas fa-id-card icon"></i>
                        <div class="detail-content">
                            <label>ID</label>
                            <span>${cus.id}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-user icon"></i>
                        <div class="detail-content">
                            <label>Username</label>
                            <span>${cus.uname}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-calendar icon"></i>
                        <div class="detail-content">
                            <label>DOB</label>
                            <span>${cus.dob}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-map-marker-alt icon"></i>
                        <div class="detail-content">
                            <label>Address</label>
                            <span>${cus.address}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-envelope icon"></i>
                        <div class="detail-content">
                            <label>Email</label>
                            <span>${cus.email}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-phone icon"></i>
                        <div class="detail-content">
                            <label>Contact Number</label>
                            <span>${cus.cnumber}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-users icon"></i>
                        <div class="detail-content">
                            <label>Type</label>
                            <span>${cus.type}</span>
                        </div>
                    </div>
                    
                    <div class="detail-group">
                        <i class="fas fa-lock icon"></i>
                        <div class="detail-content">
                            <label>Password</label>
                            <span></span>
                        </div>
                    </div>
                </div>
                
                <div class="action-buttons">
                    <c:url value="Update.jsp" var="cusupdate">
                        <c:param name="id" value="${id}" />
                        <c:param name="uname" value="${uname}" />
                        <c:param name="dob" value="${dob}" />
                        <c:param name="address" value="${address}" />
                        <c:param name="email" value="${email}" />
                        <c:param name="cnumber" value="${cnumber}" />
                        <c:param name="type" value="${type}" />
                        <c:param name="password" value="${password}" />
                    </c:url>
                    
                    <c:url value="Delete.jsp" var="cusdelete">
                        <c:param name="id" value="${id}" />
                        <c:param name="uname" value="${uname}" />
                        <c:param name="dob" value="${dob}" />
                        <c:param name="address" value="${address}" />
                        <c:param name="email" value="${email}" />
                        <c:param name="cnumber" value="${cnumber}" />
                        <c:param name="type" value="${type}" />
                        <c:param name="password" value="${password}" />
                    </c:url>
                    
                    <a href="${cusupdate}" class="update-btn"><i class="fas fa-edit"></i> Update Profile</a>
                    <a href="${cusdelete}" class="delete-btn"><i class="fas fa-trash-alt"></i> Delete Account</a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
