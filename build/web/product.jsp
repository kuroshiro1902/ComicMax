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
        <link rel="stylesheet" href="./css/productPage.css">
        <title>Comic Max - Comic & Manga Shop</title>
        <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1 class="main-product-title"></h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <a href="shop.jsp" class="red-hover" style="opacity: 0.7">Product </a> >
                    <span class="main-product-title"></span>
                </p>
            </div>   
        </div>
        <c:if test="${sessionScope.account != null}">
            <div class="manager-option">
                <div class="button">Edit Product</div>
                <div class="button" style="margin-left: 1rem ">Delete Product</div>
            </div>
        </c:if>
        <div class="container">
            <div class="body" id="product" data-id>
                <div class="product-img">
                    <img class=" main-product-img" src="https://m.media-amazon.com/images/I/91eRoWSACCL.jpg" alt="">
                </div>
                <div class="product-detail">
                    <h1 class="product__title main-product-title">
                    </h1>
                    <div class="author">By <a href="shop?auid=" class="main-product-author click"></a></div>
                    <div class="product__info">
                        <span class="publisher">Publisher: <a href="shop?pubid=" class="main-product-publisher click"></a></span>
                        <span class="language main-product-language">Language: <a href="" class="click"></a></span>
                        <span class="sold main-product-sold">Sold: <a></a></span>
                    </div>
                    <div class="product__category main-product-category">Category: 
                    </div>
                    <div class="rating main-product-rating">
                    </div>

                        <h2 class="product__price main-product-price">
                        </h2>
                        <div class="product__add">
                            <label for="quantity"> </label>
                            <input type="number" id="quantity" name="quantity" min="1" max="123" placeholder="Quantity"><!--Thay max = so luong trong stock-->
                            <c:if  test="${sessionScope.account == null}">
                                <span class="button button-add js-login-require"></span>
                            </c:if>
                            <c:if  test="${sessionScope.account != null}">
                                <span class="button button-add js-add-to-cart"></span>
                            </c:if>
                        </div>
                        <div class="product__description">
                            ${book.getName()} is one of the best-selling ${book.getCategories()[0]} comic series by ${book.getAuthor()}. Published by ${book.getPublisher()} in ${book.getLanguage()}, ${book.getName()} quickly received worldwide acceptance by comic lovers with ${book.getSold()} sold. With an engaging storyline, beautiful drawings, ${book.getName()} will take you on an exciting and fascinating adventure. Buy stories today on ComicMax with best deal!
                        </div>

                    </div>
                </div>
                <div class="relate-product-container">
                    <h1 style="padding-left: 24px">Related books</h1>
                    <div class="product-container">
                    <c:forEach begin="1" end="6" var="o">
                        <div class="product" title="test">
                            <a href class="product-img">
                                <img src="img/header/anime-coloring-book.webp" alt="">
                            </a>
                            <div class="product-text">
                                <a href class="product-title">Lorem ipsum dolor sit amet consectetur adipisicing elit. Inventore aliquid commodi nesciunt voluptates delectus similique temporibus eligendi molestias consectetur alias repellat tempora, maiores harum aliquam accusamus facilis amet unde repellendus.</a>
                                <p class="product-price"><b>$</b>12.00</p>
                                <p class="rating">
                                </p>
                                </div>
                            </div>
                    </c:forEach>
                </div>
            </div>

            <jsp:include page="comment.jsp" />
        </div>
    </body>
    <jsp:include page="footer.jsp" />
    <script src="./js/index.js"></script>
    <script src="./js/productInfo.js"></script>
    <c:if  test="${sessionScope.account != null}">
        <script type="module" src="./js/CRUD/index.js"></script>
    </c:if>
</html>
