<%-- 
    Document   : login
    Created on : Mar 6, 2023, 7:23:15 PM
    Author     : emsin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/globalStyle.css">
        <link rel="stylesheet" href="./css/home/home.css">
        <link rel="stylesheet" href="./css/account.css">
        <title>Comic Max - Comic & Manga Shop</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>My Account</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <span>sign up</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <div class="body">
                <div class="signup main">
                    <h1 class="title">SIGN UP</h1>
                    <form action="signup" method="post">
                        <input type="hidden" name="action" value="signup"> 
                        <p class="exist">${exist}</p>
                        <label for="fullname-signup">Fullname</label>
                            <input name="fullname" id="fullname-signup" class="text" required>
                        <label for="username-signup">Username</label>
                            <input name="username" id="username-signup" class="text" required>
                        <label for="password-signup">Password</label>
                            <input name="password" id="password-signup" type="password" class="text" required>
                        <label for="confirm-signup">Confirm Password</label>
                            <input name="confirm" id="confirm-signup" type="password" class="text" required>
                        <p class="message">Password didn't match. Please try again!</p>
                        <input type="submit" class="button" value="sign up">
                        <p>Already had an account? <a href="login.jsp" class="direct red-hover">Login here!</a></p>
                    </form>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script src="./js/signup.js"></script>
    </body>
</html>
