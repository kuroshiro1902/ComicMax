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
                <h1>${book.getName()}</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <a href="" class="red-hover" style="opacity: 0.7">Product </a> >
                    <span>${book.getName()}</span>
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
            <div class="body" id="product">
                <div class="product-img">
                    <img src="https://m.media-amazon.com/images/I/91eRoWSACCL.jpg" alt="">
                </div>
                <div class="product-detail">
                    <h1 class="product__title">
                        ${book.getName()}
                    </h1>
                    <div class="author">By <a href="" class="click">${book.getAuthor_id()}</a></div>
                    <div class="product__info">
                        <span class="publisher">Publisher: <a href="" class="click">${book.getAuthor_id()}</a></span>
                        <span class="language">Language: <a href="" class="click">${book.getLanguage()}</a></span>
                        <span class="sold">Sold: ${book.getSold()}</span>
                    </div>
                    <div class="product__category">Category: 
                        <a href="" class="click">Manga</a>,
                        <a href="" class="click">Fantasy</a>,
                        <a href="" class="click">Action</a>
                    </div>
                    <div class="rating">
                        <c:forEach begin="1" end="4"><i></i></c:forEach>
                        <c:forEach begin="5" end="5"><u></u></c:forEach>
                            <span>(1.269)</span>
                        </div>

                        <h2 class="product__price">
                            $ 40.00  
                        </h2>
                        <div class="product__add">
                            <label for="quantity"> </label>
                            <input type="number" id="quantity" name="quantity" min="1" max="123" placeholder="Quantity"><!--Thay max = so luong trong stock-->
                            <span class="button button-add ${sessionScope.account == null? "js-login-require":""}"></span>
                        </div>
                        <div class="product__description">
                            Have you got the Guts? Kentaro Miura's Berserk has outraged, horrified, and delighted manga and anime fanatics since 1989, creating an international legion of hardcore devotees and inspiring a plethora of TV series, feature films, and video games. And now the badass champion of adult fantasy manga is presented in an oversized 7" x 10" deluxe hardcover edition, nearly 700 pages amassing the first three Berserk volumes, with following volumes to come to serve up the entire series in handsome bookshelf collections. No Guts, no glory!
                            Have you got the Guts? Kentaro Miura's Berserk has outraged, horrified, and delighted manga and anime fanatics since 1989, creating an international legion of hardcore devotees and inspiring a plethora of TV series, feature films, and video games. And now the badass champion of adult fantasy manga is presented in an oversized 7" x 10" deluxe hardcover edition, nearly 700 pages amassing the first three Berserk volumes, with following volumes to come to serve up the entire series in handsome bookshelf collections. No Guts, no glory!

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
                                    <c:forEach begin="1" end="3"><i></i></c:forEach>
                                    <c:forEach begin="4" end="5"><u></u></c:forEach>
                                        <span>(1.269)</span>
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
</html>
