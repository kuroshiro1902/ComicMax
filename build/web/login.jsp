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
                    <span>LoGIN</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <div class="body">
                <div class="login main">
                    <h1 class="title">LOGIN</h1>
                    <form action="login" method="post">
                        <label for="username-login">Username</label>
                            <input name="username" id="username-login" class="text" required>
                        <label for="password-login">Password</label>
                            <input name="password" id="password-login" type="password" class="text" required>
                        <p class="message">${message}</p>
                        <a class="forget red-hover">Forget password?</a>
                        <br>
                        <input type="submit" class="button" value="log in">
                        <p>Don't have an account? <a href="signup.jsp" class="direct red-hover">Sign up here!</a></p>
                    </form>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script src="./js/login.js"></script>
    </body>
</html>
