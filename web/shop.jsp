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
        <link rel="stylesheet" href="./css/shop.css">
        <title>Comic Max - Comic & Manga Shop</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>Buying books</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <span>product</span>
                </p>
            </div>   
        </div>
        <section class="body-container">
            <div class="body shop">
                <div class="filter">
                    <div class="search">
                        <div class="content-heading__title">
                            <h3>Search <strong>Product</strong></h3>
                        </div>
                        <div action="shop">
                            <input class="main-input" type="text" name="search" placeholder="Search">
                            <input class="button main-input-submit" type="submit" value="search">
                        </div>
                    </div>
                    
                    <!--Lấy các tác giả, nxb, ngôn ngữ từ result cho vào đây-->
                    <div class='filter-type-container'>
                        <div class="filter-type">
                            <div class="content-heading__title">
                                <h4>By <strong>Categories</strong></h4>
                            </div>
                            <form class="form">
                                <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
                                <c:forEach items="${loadCategory.allCategories}" var="o">
                                    <div>
                                        <input id="category${o.getId()}" name="category" value="${o.getId()}" data-value="${o.getName()}" type="checkbox" class="filter-input">
                                        <label for="category${o.getId()}" class="red-hover">${o.getName()}</label>
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                        <div class="filter-type">
                            <div class="content-heading__title">
                                <h4>By <strong>Publishers</strong></h4>
                            </div>
                            <form class="form" id="publisher-filters">
                                <c:forEach begin="1" end="9" var="o">
                                    <div>
                                        <input type="checkbox" id="publisher${o}" name="publisher" data-value="publisher${o}" class="filter-input" value="${o}">
                                        <label for="publisher${o}" class="red-hover">publisher name</label>
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                        <div class="filter-type">
                            <div class="content-heading__title">
                                <h4>By <strong>Authors</strong></h4>
                            </div>
                            <form class="form" id="author-filters">
                                <c:forEach begin="1" end="9" var="o">
                                    <div>
                                        <input type="checkbox" id="author${o}" name="author" data-value="author${o}" class="filter-input" value="${o}">
                                        <label for="author${o}" class="red-hover">Author name</label>
                                    </div>
                                </c:forEach>
                            </form>
                        </div>
                    </div>
                    
                </div>
                <div class="result" id="result">
                    <a href="#result" class="seeResult button-confirm">Result</a>
                    <div class="result-filter">
                    </div>
                    <div class="result-product">
                        <div class="result-order">
                            <select class="js-order">
                                <option value='{"orderby": "id_order", "order": "DESC"}'>Sort by</option>
                                <option value='{"orderby": "price_order", "order": "ASC"}'>Price low to high</option>
                                <option value='{"orderby": "price_order", "order": "DESC"}'>Price high to low</option>
                                <option value='{"orderby": "id_order", "order": "DESC"}'>Newest to oldest</option>
                                <option value='{"orderby": "id_order", "order": "ASC"}'>Oldest to newest</option>
                            </select>
                        </div>
                        <div class="product-container" >
                         
                        </div>
                        <div class="js-page-index"></div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script type="module" src="./js/shop.js"></script>
    </body>
</html>
        