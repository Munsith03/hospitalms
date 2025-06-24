<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Insert Your Details</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="CSS/insert.css" />
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
        .error-message {
            color: red;
            font-size: 0.8rem;
            margin-top: 4px;
            display: none;
        }
        .input-group input:invalid {
            border-color: red;
        }
    </style>
</head>
<body>
<div class="page-container">
    <div class="form-container">
        <h1>Create Account</h1>
        <p class="form-subtitle">Please fill in your details below</p>

        <form id="registerForm" action="insert" method="post" novalidate>
            <div class="input-group">
                <i class="fas fa-user icon"></i>
                <input type="text" id="username" name="uname" required />
                <label for="username">Username</label>
                <span class="hint">5-20 characters, letters and numbers only</span>
                <div class="error-message" id="username-error">Invalid username.</div>
            </div>

            <div class="input-group">
                <i class="fas fa-calendar icon"></i>
                <input type="date" id="bday" name="dob" required />
                <label for="bday">DOB</label>
                <span class="hint">Cannot be a future date</span>
                <div class="error-message" id="dob-error">DOB cannot be in the future.</div>
            </div>

            <div class="input-group">
                <i class="fas fa-map-marker-alt icon"></i>
                <input type="text" id="address" name="address" maxlength="100" required />
                <label for="address">Address</label>
                <div class="error-message" id="address-error">Address is required.</div>
            </div>

            <div class="input-group">
                <i class="fas fa-envelope icon"></i>
                <input type="email" id="email" name="email" required />
                <label for="email">Email</label>
                <div class="error-message" id="email-error">Invalid email address.</div>
            </div>

            <div class="input-group">
                <i class="fas fa-phone icon"></i>
                <input type="text" id="contact" name="cnumber" required />
                <label for="contact">Contact Number</label>
                <span class="hint">10 digits only</span>
                <div class="error-message" id="contact-error">Enter a valid 10-digit number.</div>
            </div>

            <div class="input-group">
                <i class="fas fa-users icon"></i>
                <select id="type" name="type" required>
                    <option value="" disabled selected>Select type</option>
                    <option value="Customer">Customer</option>
                    <option value="Staff">Staff</option>
                </select>
                <label for="type">Type</label>
                <div class="error-message" id="type-error">Please select a type.</div>
            </div>

            <div class="input-group">
                <input type="password" id="password" name="password"
                       required />
                <label for="password">Password</label>
                <span class="hint">8-20 characters: include uppercase, lowercase, number, symbol</span>
                <div class="password-requirements">
                    <p>Password must contain:</p>
                    <ul>
                        <li id="length">8-20 characters</li>
                        <li id="lowercase">Lowercase letter</li>
                        <li id="uppercase">Uppercase letter</li>
                        <li id="number">Number</li>
                        <li id="symbol">Symbol (@$!%*?&#._-)</li>
                    </ul>
                </div>
                <div class="error-message" id="password-error">Password does not meet requirements.</div>
            </div>

            <div class="btn-container">
                <button type="submit" class="primary-btn">Create Account</button>
            </div>
        </form>

        <div class="link-container">
            <p>Already have an account?</p>
            <a href="Login.jsp" class="login-link">Log In</a>
        </div>
    </div>
</div>

<script>
    // Limit DOB to today
    const today = new Date().toISOString().split('T')[0];
    const dobInput = document.getElementById('bday');
    dobInput.setAttribute('max', today);

    // Validate on form submit
    document.getElementById('registerForm').addEventListener('submit', function (e) {
        let isValid = true;

        // Username
        const username = document.getElementById('username');
        const usernamePattern = /^[A-Za-z0-9]{5,20}$/;
        if (!usernamePattern.test(username.value)) {
            isValid = false;
            document.getElementById('username-error').style.display = 'block';
        } else {
            document.getElementById('username-error').style.display = 'none';
        }

        // DOB
        const dob = new Date(dobInput.value);
        if (dob > new Date()) {
            isValid = false;
            document.getElementById('dob-error').style.display = 'block';
        } else {
            document.getElementById('dob-error').style.display = 'none';
        }

        // Address
        const address = document.getElementById('address');
        if (address.value.trim() === '') {
            isValid = false;
            document.getElementById('address-error').style.display = 'block';
        } else {
            document.getElementById('address-error').style.display = 'none';
        }

        // Email
        const email = document.getElementById('email');
        const emailPattern = /^[^@\s]+@[^@\s]+\.[^@\s]+$/;
        if (!emailPattern.test(email.value)) {
            isValid = false;
            document.getElementById('email-error').style.display = 'block';
        } else {
            document.getElementById('email-error').style.display = 'none';
        }

        // Contact Number
        const contact = document.getElementById('contact');
        if (!/^\d{10}$/.test(contact.value)) {
            isValid = false;
            document.getElementById('contact-error').style.display = 'block';
        } else {
            document.getElementById('contact-error').style.display = 'none';
        }

        // Type
        const type = document.getElementById('type');
        if (!type.value) {
            isValid = false;
            document.getElementById('type-error').style.display = 'block';
        } else {
            document.getElementById('type-error').style.display = 'none';
        }

        // Password
        const password = document.getElementById('password');
        const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&#._-])[A-Za-z\d@$!%*?&#._-]{8,20}$/;
        if (!passwordPattern.test(password.value)) {
            isValid = false;
            document.getElementById('password-error').style.display = 'block';
        } else {
            document.getElementById('password-error').style.display = 'none';
        }

        if (!isValid) e.preventDefault(); // Stop form if any field is invalid
    });

    // Password validation real-time
    const passwordInput = document.getElementById('password');
    passwordInput.addEventListener('input', function () {
        const value = this.value;
        const checks = {
            length: value.length >= 8 && value.length <= 20,
            lowercase: /[a-z]/.test(value),
            uppercase: /[A-Z]/.test(value),
            number: /\d/.test(value),
            symbol: /[@$!%*?&#._-]/.test(value)
        };
        for (const [key, valid] of Object.entries(checks)) {
            document.getElementById(key).classList.toggle('valid', valid);
        }
    });
</script>
</body>
</html>
