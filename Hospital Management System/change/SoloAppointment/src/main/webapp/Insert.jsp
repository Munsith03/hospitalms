<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Book Appointment</title>
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
        }

        .page-container {
          display: flex;
          justify-content: center;
          align-items: center;
          padding: 40px 20px;
        }

        .form-container {
          background: white;
          border-radius: var(--border-radius);
          box-shadow: var(--shadow);
          width: 100%;
          max-width: 550px;
          padding: 40px;
          margin: 20px 0;
          position: relative;
          overflow: hidden;
        }

        .form-container::before {
          content: "";
          position: absolute;
          top: 0;
          left: 0;
          width: 100%;
          height: 5px;
          background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
        }

        h1 {
          color: var(--primary-color);
          font-size: 28px;
          font-weight: 600;
          margin-bottom: 10px;
          text-align: center;
        }

        .form-subtitle {
          font-size: 16px;
          color: var(--text-light);
          margin-bottom: 30px;
          text-align: center;
        }

        .input-group {
          position: relative;
          margin-bottom: 25px;
        }

        .icon {
          position: absolute;
          left: 15px;
          top: 50%;
          transform: translateY(-50%);
          color: var(--primary-color);
          z-index: 2;
        }

        .input-group input, .input-group select {
          width: 100%;
          padding: 15px 15px 15px 45px;
          font-size: 16px;
          border: 1px solid #ddd;
          border-radius: 8px;
          background-color: var(--input-bg);
          transition: var(--transition);
        }

        .input-group label {
          position: absolute;
          left: 45px;
          top: 50%;
          transform: translateY(-50%);
          color: #888;
          pointer-events: none;
          transition: var(--transition);
        }

        .input-group input:focus,
        .input-group select:focus {
          border-color: var(--primary-color);
          box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);
          outline: none;
        }

        .input-group input:focus + label,
        .input-group input:not(:placeholder-shown) + label,
        .input-group select:focus + label,
        .input-group select:not([value=""]):valid + label {
          top: 0;
          left: 15px;
          font-size: 12px;
          background-color: white;
          padding: 0 5px;
          color: var(--primary-color);
        }

        .input-group input::placeholder {
          color: transparent;
        }

        .hint {
          font-size: 12px;
          color: var(--text-light);
          margin-top: 5px;
          display: block;
          margin-left: 45px;
        }

        .btn-container {
          text-align: center;
          margin-top: 30px;
        }

        .primary-btn {
          background: linear-gradient(90deg, var(--primary-color), var(--primary-light));
          color: white;
          border: none;
          padding: 14px 30px;
          border-radius: 30px;
          font-size: 16px;
          font-weight: 500;
          cursor: pointer;
          transition: var(--transition);
          box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);
          width: 100%;
          max-width: 250px;
        }

        .primary-btn:hover {
          transform: translateY(-3px);
          box-shadow: 0 6px 20px rgba(67, 97, 238, 0.4);
        }

        .primary-btn:active {
          transform: translateY(0);
        }

        .link-container {
          text-align: center;
          margin-top: 25px;
          display: flex;
          justify-content: center;
          align-items: center;
          gap: 8px;
        }

        .login-link {
          color: var(--primary-color);
          text-decoration: none;
          font-weight: 500;
          transition: var(--transition);
        }

        .login-link:hover {
          text-decoration: underline;
        }
        
        .section-title {
          color: var(--primary-color);
          font-size: 18px;
          font-weight: 500;
          margin: 25px 0 15px 0;
          position: relative;
          padding-bottom: 8px;
        }

        .section-title::after {
          content: "";
          position: absolute;
          bottom: 0;
          left: 0;
          width: 40px;
          height: 3px;
          background: var(--primary-light);
        }

        .input-group textarea {
          width: 100%;
          padding: 15px 15px 15px 45px;
          font-size: 16px;
          border: 1px solid #ddd;
          border-radius: 8px;
          background-color: var(--input-bg);
          transition: var(--transition);
          font-family: 'Poppins', sans-serif;
          resize: vertical;
        }

        .input-group textarea:focus {
          border-color: var(--primary-color);
          box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);
          outline: none;
        }

        .input-group textarea:focus + label,
        .input-group textarea:not(:placeholder-shown) + label {
          top: -10px;
          left: 15px;
          font-size: 12px;
          background-color: white;
          padding: 0 5px;
          color: var(--primary-color);
        }

        .input-group textarea::placeholder {
          color: transparent;
        }

        /* Responsive adjustments */
        @media (max-width: 768px) {
          .form-container {
            padding: 30px 20px;
          }
          
          h1 {
            font-size: 24px;
          }
          
          .input-group input, .input-group select, .input-group textarea {
            padding: 12px 12px 12px 40px;
          }
          
          .icon {
            left: 12px;
          }
        }
    </style>
 <script>
        function validateForm() {
            const namePattern = /^[A-Za-z\s]+$/;
            const phonePattern = /^\d{10}$/;

            const patientName = document.getElementById("patientName").value.trim();
            const doctorName = document.getElementById("doctorName").value.trim();
            const phone = document.getElementById("contactNumber").value.trim();
            const age = document.getElementById("patientAge").value;

            if (!namePattern.test(patientName)) {
                alert("Patient name must contain only letters and spaces.");
                return false;
            }

            if (!namePattern.test(doctorName)) {
                alert("Doctor name must contain only letters and spaces.");
                return false;
            }

            if (!phonePattern.test(phone)) {
                alert("Contact number must be a 10-digit number.");
                return false;
            }

            if (age < 0 || age > 120) {
                alert("Please enter a valid age between 0 and 120.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <div class="page-container">
        <div class="form-container">
            <h1>Book Your Appointment</h1>
            <p class="form-subtitle">Please fill in your appointment details below</p>

            <form action="insert" method="post" onsubmit="return validateForm();">
                <!-- Patient Info -->
                <h2 class="section-title">Patient Information</h2>

                <div class="input-group">
                    <i class="fas fa-user icon"></i>
                    <input type="text" id="patientName" name="patientName" pattern="[A-Za-z\s]+" placeholder=" " required />
                    <label for="patientName">Patient Name</label>
                    <span class="hint">Only letters and spaces</span>
                </div>

                <div class="input-group">
                    <i class="fas fa-birthday-cake icon"></i>
                    <input type="number" id="patientAge" name="patientAge" min="0" max="120" placeholder=" " required />
                    <label for="patientAge">Patient Age</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-venus-mars icon"></i>
                    <select id="gender" name="gender" required>
                        <option value="" disabled selected>Select Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                    <label for="gender">Gender</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-phone icon"></i>
                    <input type="tel" id="contactNumber" name="contactNumber" pattern="\d{10}" placeholder=" " required />
                    <label for="contactNumber">Contact Number</label>
                    <span class="hint">10 digit phone number</span>
                </div>

                <div class="input-group">
                    <i class="fas fa-envelope icon"></i>
                    <input type="email" id="email" name="email" placeholder=" " required />
                    <label for="email">Email Address</label>
                </div>

                <!-- Appointment Info -->
                <h2 class="section-title">Appointment Details</h2>

                <div class="input-group">
                    <i class="fas fa-user-md icon"></i>
                    <input type="text" id="doctorName" name="doctorName" pattern="[A-Za-z\s]+" placeholder=" " required />
                    <label for="doctorName">Doctor Name</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-stethoscope icon"></i>
                    <select id="specialization" name="specialization" required>
                        <option value="" disabled selected>Select Specialization</option>
                        <option value="General Medicine">General Medicine</option>
                        <option value="Cardiology">Cardiology</option>
                        <option value="Dermatology">Dermatology</option>
                        <option value="Pediatrics">Pediatrics</option>
                        <option value="Orthopedics">Orthopedics</option>
                    </select>
                    <label for="specialization">Specialization</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-calendar-alt icon"></i>
                    <input type="date" id="appointmentDate" name="appointmentDate"
                           min="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) %>" placeholder=" " required />
                    <label for="appointmentDate">Appointment Date</label>
                </div>

                <div class="input-group">
                    <i class="fas fa-comment-medical icon"></i>
                    <textarea id="reasonForVisit" name="reasonForVisit" rows="4" minlength="10" maxlength="500" placeholder=" " required></textarea>
                    <label for="reasonForVisit">Reason for Visit</label>
                    <span class="hint">10-500 characters</span>
                </div>

                <div class="btn-container">
                    <button type="submit" class="primary-btn">Book Appointment</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>