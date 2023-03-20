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
    <title>Comic Max - Comic & Manga Shop</title>
    <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
</head>
<body>
    <jsp:include page="header.jsp" />
    <section class="body-container">
        <div class="">
            <div class="slideshow-container">
                <div class="slideshow">
                    <div class="slide1 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>NEW MANGA RELEASES</h1>
                                <p>We've updated all of the new manga series releasing in 2023 in everyweek! A comprehensive and up-to-date list. Check it out!</p>
                            </div>
                        </div>
                    </div>
                    <div class="slide2 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>ALL COMIC CATEGORIES</h1>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis sapiente mollitia quam. Placeat temporibus atque vero molestiae nesciunt facere velit ab harum, maxime numquam? Non, architecto. Illo dolorem consectetur veniam?</p>
                            </div>
                        </div>
                    </div>
                    <div class="slide3 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>CHARACTER FIGURES</h1>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Necessitatibus neque dolor libero saepe. Natus, incidunt! Vero, amet! Accusantium voluptatum placeat veritatis aperiam facilis pariatur reprehenderit numquam aut veniam. Neque, voluptatem.</p>
                            </div>
                        </div>
                    </div>
                    <div class="slidedot block-center">
                        <span class="dot dot1"></span>
                        <span class="dot dot2"></span>
                        <span class="dot dot3"></span>
                    </div>
                </div>
            </div>
            <div class="content-container container">
                <div class="content">
                    <div class="content-heading">
                        <div class="content-heading__title">
                            <h2>
                                Welcome to <strong>ComicMax</strong>
                            </h2>
                        </div>
                        <div class="content-heading__description">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates minima tempore cumque!</p>
                        </div>
                        <div style="padding-top: 16px">
                            <a href="${sessionScope.account != null ? 'shop.jsp' : 'javascript:void(0)'}" style="padding: 12px 36px 12px 36px; font-size:24px" class="button ${sessionScope.account == null? 'js-login-require' : ''}">Buy now</a>
                        </div>
                    </div>
                </div>
                <div class="content allcategories">
                    <div class="content-heading">
                        <div class="content-heading__title">
                            <h2>
                                All <strong>categories</strong>
                            </h2>
                        </div>
                    </div>
                    <div class="content-body">

                        <c:forEach items="${loadCategory.getAllCategories()}" begin="0" end="7" var="o">
                            <a class="category-item red-hover" href="">
                                <div>
                                    <img src="${o.getImg()}" alt="">
                                </div>

                                <span class="text-center">${o.getName()}</span>
                            </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="content">
                    <div class="content-heading">
                        <div class="content-heading__title">
                            <h2>
                                Best <strong>seller</strong>
                            </h2>
                        </div>
                        <div class="content-heading__description">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates minima tempore cumque!</p>
                        </div>
                    </div>
                    <div class="product-container">
                        <c:forEach begin="1" end="6" var="o">
                            <div class="product" title="test">
                                <a href="product?pid=2" class="product-img">
                                    <img src="img/temp.webp" alt="">
                                </a>
                                <div class="product-text">
                                    <a href="product?pid=2  " class="product-title">Lorem ipsum dolor sit amet consectetur adipisicing elit. Inventore aliquid commodi nesciunt voluptates delectus similique temporibus eligendi molestias consectetur alias repellat tempora, maiores harum aliquam accusamus facilis amet unde repellendus.</a>
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
                <div class="content">
                    <div class="content-heading">
                        <div class="content-heading__title">
                            <h2>
                                New <strong>comics</strong>
                            </h2>
                        </div>
                        <div class="content-heading__description">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates minima tempore cumque!</p>
                        </div>
                    </div>
                    <div class="product-container">
                        <c:forEach begin="1" end="6" var="o">
                            <div class="product" title="test">
                                <a href class="product-img">
                                    <img src="img/temp.webp" alt="">
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
                <div class="content">
                    <div class="content-heading">
                        <div class="content-heading__title">
                            <h2>
                                Popular <strong>products</strong>
                            </h2>
                        </div>
                        <div class="content-heading__description">
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptates minima tempore cumque!</p>
                        </div>
                    </div>
                    <div class="product-container">
                        <c:forEach begin="1" end="6" var="o">
                            <div class="product" title="test">
                                <a href class="product-img">
                                    <img src="img/temp.webp" alt="">
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
            </div>
        </div>
    </section>
    <jsp:include page="footer.jsp" />
    <script type="module" src="js/home/home.js"></script>
    <script src="./js/index.js"></script>
</body>
</html>