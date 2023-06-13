<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="./css/globalStyle.css">
        <link rel="stylesheet" href="./css/home/home.css">
        <title>Comic Max - Comic & Manga Shop</title>
        <style>
            .required:hover{
                text-decoration: underline;
                color: var(--red);
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>My Account</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home</a> >
                    <span>Error</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <div class="body">
              
                    <h1 style="font-weight: bolder">Page does not exist! Go to <a class="required" href="./"><strong>ComicMax</strong></a>.</h1>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        
    </body>
</html>
