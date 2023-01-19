<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 10/08/2021
  Time: 01:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>registration</title>

  <title>CBOOKSOCIAL - Connect your world</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./font-awesome/css/font-awesome.min.css">

  <link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
  <script src="./js/jquery-2.2.4.min.js"></script>
  <script src="./bootstrap/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="main.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="w3hubs.com">
  <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"
          integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  <style type="text/css">
    body {
      background-color: #f0f2f5;
      font-family: "Nunito Sans";
    }

    .login-form {
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, .1), 0 8px 16px rgba(0, 0, 0, .1);
      background-color: #fff;
      padding: 25px;
      margin-top: 25px;
      margin-left: 50px;
    }

    h3 {
      padding-left: 30px;
      padding-right: 20px;
    }

    .btn-custom {
      background-color: #1877f2;
      border: none;
      border-radius: 6px;
      font-size: 20px;
      line-height: 28px;
      color: #fff;
      font-weight: 700;
      height: 48px;
    }

    .btn-custom {
      color: #fff !important;
    }

    input {
      height: 52px;
      font-size: 18px !important;
      color: #f2f2f2;
    }

    .form-control:focus {
      box-shadow: 0 0 0 0 rgba(13, 110, 253, .25);
    }

    a {
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }

    @media (max-width: 768px) {

      .col-md-7,
      p {
        display: none;
      }

      input {
        font-size: 16px !important;
      }

      .login-form {
        box-shadow: none;

      }
    }

  </style>

</head>
<body style="display: flex; justify-content: center; align-items: center;">
<%--<h4>Sign up to FaceBook</h4>--%>
<%--<form action="<%=request.getContextPath()%>/userRegistration" method="post">--%>
<%--    &lt;%&ndash;@declare id="username"&ndash;%&gt;--%>
<%--    &lt;%&ndash;@declare id="firstname"&ndash;%&gt;--%>
<%--    &lt;%&ndash;@declare id="lastname"&ndash;%&gt;&lt;%&ndash;@declare id="country"&ndash;%&gt;&lt;%&ndash;@declare id="password"&ndash;%&gt;--%>
<%--    &lt;%&ndash;@declare id="email"&ndash;%&gt;--%>
<%--    <label for="userName">User Name:</label>--%>
<%--    <input type="text" name="userName"/>--%>
<%--    <br>--%>
<%--    <label for="firstName">First Name:</label>--%>
<%--    <input type="text" name="firstName" />--%>
<%--    <br>--%>
<%--    <label for="lastName">Last Name:</label>--%>
<%--    <input type="text" name="lastName" />--%>
<%--    <br>--%>
<%--    <label for="email">Email:</label>--%>
<%--    <input type="email" name="email" />--%>
<%--    <br>--%>
<%--    <label for="country">Country:</label>--%>
<%--    <input type="text" name="country" />--%>
<%--    <br>--%>
<%--    <label for="password">Password:</label>--%>
<%--    <input type="password" name="password" />--%>
<%--    <br>--%>
<%--    <button type="submit">Sign up</button>--%>


<%--</form>--%>

<div class="col-md-5" id="sign-up-container">
  <div style=" margin-left: 50px; display:flex; align-items: center"><img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" class="w-50"></div>
  <form class="login-form" method="POST" action="<%=request.getContextPath()%>/userRegistration">
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="User Name" name="userName" required>
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="First Name" name="firstName" required>
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="Last Name" name="lastName" required>
    </div>
    <div class="mb-3">
      <select class="form-control" name="gender" >
        <option selected disabled>Gender</option>
        <option value="Male">Male</option>
        <option value="Female">Female</option>
      </select>
    </div>
    <div class="mb-3">
      <label>Date of birth</label>
      <input type="date" class="form-control" name="dob" pattern="\d{4}-\d{2}-\d{2}" required>
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="Email address "
             name="email" required>
    </div>
    <div class="mb-3">
      <input type="password" class="form-control" placeholder="Password" name="password" required>
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" placeholder="country" name="country"
             required>
    </div>
    <button type="submit" class="btn btn-custom btn-block btn-success  btn-lg mt-3" id="create-account-2">
      Create New Account
    </button>

  </form>
  <p class="pt-3 text-center">have account already? <a id="back" href="#">Create a Page</a></p>
</div>
</div>
</div>
</body>
</html>
