<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Search Appointment</title>
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
          max-width: 500px;
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

        .input-group input {
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

        .input-group input:focus {
          border-color: var(--primary-color);
          box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.15);
          outline: none;
        }

        .input-group input:focus + label,
        .input-group input:not(:placeholder-shown) + label {
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

        .back-link {
          color: var(--primary-color);
          text-decoration: none;
          font-weight: 500;
          transition: var(--transition);
        }

        .back-link:hover {
          text-decoration: underline;
        }

        /* Responsive adjustments */
        @media (max-width: 768px) {
          .form-container {
            padding: 30px 20px;
          }
          
          h1 {
            font-size: 24px;
          }
          
          .input-group input {
            padding: 12px 12px 12px 40px;
          }
          
          .icon {
            left: 12px;
          }
        }
    </style>
</head>
<body>
    <div class="page-container">
        <div class="form-container">
            <h1>Search Your Appointment</h1>
            <p class="form-subtitle">Enter details to find your appointment information</p>
            
            <form action="search" method="post">
                <div class="input-group">
                    <i class="fas fa-user icon"></i>
                    <input type="text" id="patientName" name="patientName" placeholder=" " required />
                    <label for="patientName">Patient Name</label>
                </div>
                
                <div class="input-group">
                    <i class="fas fa-envelope icon"></i>
                    <input type="email" id="email" name="email" placeholder=" " required />
                    <label for="email">Email Address</label>
                </div>
                
                <div class="btn-container">
                    <button type="submit" class="primary-btn">
                        <i class="fas fa-search"></i> Search Appointment
                    </button>
                </div>
            </form>
            
           
        </div>
    </div>
</body>
</html>
