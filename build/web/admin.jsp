<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/globalStyle.css">
    <link rel="stylesheet" href="./css/home/home.css">
    <link rel="stylesheet" href="./css/item.css"/>
    <link rel="stylesheet" href="./css/admin.css">
    <title>Administrator</title>
    <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
    <jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
</head>
    <body>
        <jsp:include page="header.jsp" />
        <div style="margin-top: 78px"></div>
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>ADMINISTRATOR</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <span>admin</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <h1 style="margin-top: 1rem">ADMIN</h1>
            <c:choose>
                <c:when test="${sessionScope.account.getIsAdmin() == 1}">
                <div class="admin">
                    <div class="left-bar">
                        <form class="js-menu" action="./admin" data-selected="${selected}">
                            <h4>Dashboard</h4>
                            <button class="option" type="submit" name="selected" value="analytics">
                                <div class="icon"><i class="fa-solid fa-chart-line"></i></div>
                                Analytics
                            </button>
                            <h4>Product</h4>
                            <button class="option" type="submit" name="selected" value="pedit">
                                <div class="icon"><i class="fa-solid fa-pen-to-square"></i></div>
                                Edit
                            </button>
                            <button class="option" type="submit" name="selected" value="delivery">
                                <div class="icon"><i class="fa-solid fa-truck"></i></div>
                                Delivery
                            </button>
                            <button class="option" type="submit" name="selected" value="sold">
                                <div class="icon"><i class="fa-solid fa-dollar-sign"></i></div>
                                Sold
                            </button>
                            <button class="option" type="submit" name="selected" value="preport">
                                <div class="icon"><i class="fa-solid fa-flag"></i></div>
                                Reported
                            </button>
                            <h4>User</h4>
                            <button class="option" type="submit" name="selected" value="editu">
                                <div class="icon"><i class="fa-solid fa-pen-to-square"></i></div>
                                Edit
                            </button>
                            <button class="option" type="submit" name="selected" value="ureport">
                                <div class="icon"><i class="fa-solid fa-flag"></i></div>
                                Reported
                            </button>
                            <h4>Setting</h4>
                            <button class="option" type="submit" name="selected" value="setting">
                                <div class="icon"><i class="fa-solid fa-gear"></i></div>
                                Setting
                            </button>
                        </form>
                    </div>
                            <div class="main" action="">
                                <form class="searchbar" >
                                    <input type="text" name="search">
                                    <input type="submit" value="Search" class="button" spellcheck="false">
                                </form>
                                <jsp:include page="./views_admin/${selected}.jsp" />
                            </div>
                </div>
                </c:when>
                <c:otherwise>
                <div class="body">
                    <div style="text-align: center">
                        <h1 style="margin-bottom: 16px">You have not permission to do this action! </h1>
                        <a href="index.jsp" class="button">Go back</a>
                    </div>
                </div>
                </c:otherwise>
            </c:choose>
            <div id="edit-container">
                <div class="edit-field">
                    <h3>Edit Product</h3>
                    <input id="edit-id" style="display: none">
                    <label for="edit-title">Title</label>
                    <input id="edit-title" type="text" name="edit-title" placeholder="Title">
                    <label for="edit-img">Image</label>
                    <input id="edit-img" type="text" name="edit-img" placeholder="Image">
                    <label for="edit-price">Price</label>
                    <input id="edit-price" name="edit-price" type="text" placeholder="Price">
                    <label for="edit-amount">Amount</label>
                    <input id="edit-amount" name="edit-amount" type="text" placeholder="Amount">
                    <div class="buttons">
                        <button id="edit-confirm" class="button-confirm">Submit</button>
                        <button id="edit-cancel" class="button-cancel">Cancel</button>
                    </div>
                    
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script defer type="module" src="./js/admin.js"></script>
    </body>
</html>
