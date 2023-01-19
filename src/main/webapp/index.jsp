<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<Title>Social Media Clone</Title>
<head>
    <head>
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

</head>
<body>

<%--<div class="content-box">--%>
<%--    <section class="facebookName">--%>
<%--        <h2 id="facebook-title">Facebook</h2>--%>
<%--        <h3> Facebook helps you connect and share with the people in your life.</h3>--%>
<%--    </section>--%>
<%--    <section class="form-box">--%>
<%--        <form action="<%=request.getContextPath()%>/userLogin" method="Post">--%>
<%--            &lt;%&ndash;@declare id="email"&ndash;%&gt;&lt;%&ndash;@declare id="password"&ndash;%&gt;&lt;%&ndash;@declare id="submit"&ndash;%&gt;--%>
<%--            &lt;%&ndash;@declare id="username"&ndash;%&gt;<label for="userName">Username</label><br>--%>
<%--            <input type="text" name="userName" required/>--%>
<%--            <br><br>--%>
<%--            <label for="password">password</label><br>--%>
<%--            <input type="password" name="password" width="50%" required/>--%>
<%--            <br><br>--%>
<%--            <button id="login-button" type="submit">Login</button>--%>
<%--            <a href="registration.jsp"><button id="new-account" type="button">Create new Account</button></a>--%>
<%--        </form>--%>
<%--    </section>--%>
<%--</div>--%>


<div class="container">
    <div class="row align-items-center justify-content-center vh-100">
        <div class="col-md-7">
            <img src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" class="w-50">
            <h3>Facebook helps you connect and share with the people in your life.</h3>
        </div>
        <div class="col-md-5" id="login-container">
            <form class="login-form" method="POST" action="<%=request.getContextPath()%>/userLogin">
                <div class="mb-3">
                    <input type="text" class="form-control" name="login_username" placeholder="User name" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="login_password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-custom btn-lg btn-block mt-3" id="login-btn">Login</button>
                <div class="text-center pt-3 pb-3">
                    <a href="#" class="">Forgotten password?</a>
                    <hr>
                    <a href="registration.jsp"><button type="button" class="btn btn-success btn-lg mt-3" id="create-account-1">Create New Account
                    </button></a>
                </div>
            </form>
            <p class="pt-3 text-center"><b>Create a Page</b> for a celebrity, band or business.</p>
        </div>
</body>
</html>