<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Insert Your Payment Details</title>
  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <style>
    /* Base Reset */
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

    body {
      font-family: 'Poppins', sans-serif;
      background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
      color: var(--text-color);
      min-height: 100vh;
      line-height: 1.6;
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
      margin: 20px auto;
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
    }

    .input-group input,
    .input-group select {
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

    .link-container {
      text-align: center;
      margin-top: 25px;
    }

    .view-link {
      color: white;
      text-decoration: none;
      font-weight: 500;
      background: var(--primary-color);
      padding: 10px 20px;
      border-radius: 30px;
      display: inline-flex;
      align-items: center;
      gap: 8px;
      transition: var(--transition);
      box-shadow: 0 4px 15px rgba(67, 97, 238, 0.3);
    }

    .view-link:hover {
      background: var(--secondary-color);
      transform: translateY(-2px);
    }

    @media (max-width: 768px) {
      .form-container {
        padding: 30px 20px;
      }

      h1 {
        font-size: 24px;
      }

      .input-group input,
      .input-group select {
        padding: 12px 12px 12px 40px;
      }

      .icon {
        left: 12px;
      }
    }
  </style>
  <script>
    function validateName(event) {
      const char = String.fromCharCode(event.which);
      const regex = /^[a-zA-Z\s]*$/;
      if (!regex.test(char)) event.preventDefault();
    }

    function validateAmount(event) {
      const char = String.fromCharCode(event.which);
      const regex = /^[0-9.]$/;
      if (!regex.test(char)) event.preventDefault();
    }

    function validatePhone(event) {
      const char = String.fromCharCode(event.which);
      const regex = /^[0-9]$/;
      const phoneInput = document.getElementById("phone");
      if (!regex.test(char) || phoneInput.value.length >= 10) {
        event.preventDefault();
      }
    }

    function validateEmailFormat(email) {
      const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return regex.test(email);
    }

    function isNotEmptyTrimmed(value) {
      return value.trim().length > 0;
    }

    function validateForm() {
      const name = document.getElementById("name").value;
      const email = document.getElementById("email").value;
      const phone = document.getElementById("phone").value;
      const medicine = document.getElementById("medicine").value;
      const amount = document.getElementById("amount").value;

      if (!isNotEmptyTrimmed(name) || name.length < 3) {
        alert("Please enter a valid full name (at least 3 characters).");
        return false;
      }

      if (!validateEmailFormat(email)) {
        alert("Please enter a valid email address.");
        return false;
      }

      if (!/^\d{10}$/.test(phone)) {
        alert("Phone number must be exactly 10 digits.");
        return false;
      }

      if (!isNotEmptyTrimmed(medicine)) {
        alert("Please enter a valid medicine name.");
        return false;
      }

      const amountVal = parseFloat(amount);
      if (isNaN(amountVal) || amountVal <= 0) {
        alert("Please enter a valid payment amount greater than 0.");
        return false;
      }

      return true;
    }
  </script>
</head>
<body>
  <div class="page-container">
    <div class="form-container">
      <h1>Insert Your Payment Details</h1>
      <p class="form-subtitle">Please fill in your payment information below</p>

      <form action="SaveServlet" method="post" onsubmit="return validateForm()">
        <div class="input-group">
          <i class="fas fa-user icon"></i>
          <input type="text" id="name" name="name" minlength="3" required onkeypress="validateName(event)" placeholder=" " />
          <label for="name">Full Name</label>
          <span class="hint">Only letters and spaces</span>
        </div>

        <div class="input-group">
          <i class="fas fa-envelope icon"></i>
          <input type="email" id="email" name="email" required placeholder=" " />
          <label for="email">Email Address</label>
        </div>

        <div class="input-group">
          <i class="fas fa-phone icon"></i>
          <input type="text" id="phone" name="phone" required maxlength="10" onkeypress="validatePhone(event)" placeholder=" " />
          <label for="phone">Phone Number</label>
          <span class="hint">10 digit phone number</span>
        </div>

        <div class="input-group">
          <i class="fas fa-pills icon"></i>
          <input type="text" id="medicine" name="medicine" required onkeypress="validateName(event)" placeholder=" " />
          <label for="medicine">Medicine Name</label>
        </div>

        <div class="input-group">
          <i class="fas fa-sort-amount-up icon"></i>
          <input type="number" id="quantity" name="quantity" min="1" required placeholder=" " />
          <label for="quantity">Quantity</label>
        </div>

        <div class="input-group">
          <i class="fas fa-credit-card icon"></i>
          <select id="method" name="method" required>
            <option value="">-- Select Payment Method --</option>
            <option value="Card Payment">Card Payment</option>
            <option value="Paypal">Paypal</option>
            <option value="Cash on Delivery">Cash on Delivery</option>
          </select>
          <label for="method">Payment Method</label>
        </div>

        <div class="input-group">
          <i class="fas fa-money-bill-wave icon"></i>
          <input type="text" id="amount" name="amount" required onkeypress="validateAmount(event)" placeholder=" " />
          <label for="amount">Payment Amount (LKR)</label>
        </div>

        <div class="btn-container">
          <button type="submit" class="primary-btn">Submit Payment</button>
        </div>
      </form>

      <div class="link-container">
        <a href="ViewServlet" class="view-link">
          <i class="fas fa-eye"></i> View All Payments
        </a>
      </div>
    </div>
  </div>
</body>
</html>
