<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <jsp:useBean id="loadCategory" class="dao.DAO" scope="request"></jsp:useBean>
</head>
<section class="head-container container">
    <div class="header">
        <div class="header-logo" title="Comic Max - Comic & Manga Shop">
            <a href="#"></a>
        </div>
        <div class="header-nav navbar">
            <div class="subnav-switch">
                <a class="header-nav__item red-hover">
                    <i class="fa-solid fa-fire-flame-curved"></i>
                    <h4>Action</h4>
                    <i class="fa-solid fa-caret-down"></i>
                </a>
                <div class="subnav">
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                </div>
            </div>
            <div class="subnav-switch">
                <a class="header-nav__item red-hover">
                    <i class="fa-solid fa-bolt"></i>
                    <h4>Fantasy</h4>
                    <i class="fa-solid fa-caret-down"></i>
                </a>
                <div class="subnav">
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/flash.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                    <a class="subnav__book" href="">
                        <img src="./img/home_product/anime-coloring-book.webp" alt="">
                        <h2 style="margin-top: 8px">Anime</h2>
                        <p>$ 20.00</p>
                    </a>
                </div>
            </div>
            <div class="subnav-switch mb-menu">
                <a class="header-nav__item red-hover">
                    <i class="fa-solid fa-bars"></i>
                    <h4>Category</h4>
                    <i class="fa-solid fa-caret-down"></i>
                </a>
                <div class="subnav">
                    <c:forEach items="${loadCategory.allCategories}" var="o" begin="0" end="3">
                        <a class="subnav__category" href="">
                            <img src="./img/home_product/${o.img}" alt="">
                            <div class="button" style=" max-width: 146px; text-align: center;">${o.value}</div>
                        </a>
                    </c:forEach>
                    <a class="subnav__category" href="" title="More">
                        <i class="fa-solid fa-table-cells"></i>
                    </a>
                </div>
                <div class="mb-subnav">
                    <div class="mb-subnav__btn">
                        <a href="">
                            <i class="fa-solid fa-tag"></i>
                            <span>BUY COMIC</span>
                        </a>
                    </div>
                    <div class="mb-subnav__btn">
                        <a href="">
                            <i class="fa-solid fa-pen"></i>
                            <span>BLOG</span>
                        </a>
                    </div>
                </div>
            </div>
            <div>
                <a href="" class="header-nav__item red-hover">
                    <i class="fa-solid fa-pen"></i>
                    <h4>Blog</h4>
                </a>
            </div>
            <div class="searchbar center-block">
                <input type="text">
            </div>
        </div>
        <div class="header-usernav navbar">
            <a href="" class="header-usernav__item red-hover cart">
                <i class="fa-solid fa-cart-shopping"></i>
                <span class="amount">0</span>
            </a>
            <a href="" class="header-usernav__item red-hover user">
                <i class="fa-solid fa-user"></i>
                <!-- <img src="./img/l.png" alt=""> -->
            </a>
        </div>
    </div>
</section>