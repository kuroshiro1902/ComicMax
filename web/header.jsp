<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
        <div id="toast"></div>
        <div id="confirm">
            <div class="confirm">
                <div class="confirm-title">
                    Confirm title
                </div>
                <div>
                    <p class="confirm-content"></p>
                    <div class="confirm-buttons">
                        <a class="button-confirm">Confirm</a>
                        <div class="button-cancel">Cancel</div>
                    </div>
                </div>
            </div>
        </div>
        <section class="head-container container">
            <div class="header">
                <div class="header-logo logo" title="Comic Max - Comic & Manga Shop">
                    <a href="index.jsp"></a>
                </div>
                <div class="header-nav navbar">
                    <div class="subnav-switch">
                        <a class="header-nav__item red-hover">
                            <i class="fa-solid fa-fire-flame-curved"></i>
                            <h4>Action</h4>
                            <i class="fa-solid fa-caret-down"></i>
                        </a>
                        <div class="subnav">
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
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
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/flash.webp" alt="">
                                <h2 style="margin-top: 8px">Anime</h2>
                                <p>$ 20.00</p>
                            </a>
                            <a class="subnav__book text-center" href="">
                                <img class="bdr-8" src="./img/home_product/anime-coloring-book.webp" alt="">
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
                        </div>
                        <div class="mb-subnav">
                            <div class="mb-subnav__btn">
                                <a href="">
                                    <i class="fa-solid fa-tag"></i>
                                    <span>MUA TRUYỆN</span>
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
                        <a href="blog.jsp" class="header-nav__item red-hover">
                            <i class="fa-solid fa-pen"></i>
                            <h4>Blog</h4>
                        </a>
                    </div>
                </div>
                <form class="searchbar block-center">
                    <input type="text" name="search" placeholder="Search" title="What do want to read?" required>
                    <input type="submit" value="Search" class="button" style="display: none">
                </form>
                <div class="header-usernav navbar">
                    <c:if test="${sessionScope.account != null}">
                        <div class="usersubnav-switch user-hover">
                            <a href class="header-usernav__item red-hover cart">
                               <i class="fa-solid fa-cart-shopping"></i>
                                <span class="amount">0</span>
                            </a>
                            <div class="subnav cartlist">
                                <c:forEach begin="1" end="3">
                                    <div class="cart-item" >
                                        <div class="cart-item__img" style="background-image: url('./img/home_product/flash.webp')"></div>
                                        <div class="cart-item__title red-hover"><a href>Berserk Deluxe Volume 1</a></div>
                                        <div class="cart-item__price">$14.59</div>
                                    </div>
                                </c:forEach>
                                <div class="cart-item">
                                    <a href class="button"> See all</a>
                                </div>
                                
                            </div>
                        </div>
                        <div class="usersubnav-switch user-hover">
                            <a href="javascript:void(0)" class="header-usernav__item user user-hover"
                                title="${sessionScope.account.getFullname()}">
                                <img src="./img/default.webp" alt="" style="border-radius: 50%">
                            </a>
                            <div class="subnav">
                                <c:if test="${sessionScope.account.getIsAdmin() == 1}">
                                    <a class="usersubnav__item" href>Manager product &nbsp;<i class="fa-solid fa-bag-shopping"></i></a>
                                </c:if>
                                <a class="usersubnav__item" href>Account &nbsp;<i class="fa-solid fa-user"></i></a>
                                <a class="usersubnav__item" href>Delivery &nbsp;<i class="fa-solid fa-truck"></i></a>
                                <a class="usersubnav__item" href>Setting &nbsp;<i class="fa-solid fa-gear"></i></a>
                                <a class="usersubnav__item" href="./logout">Log out &nbsp;<i class="fa-solid fa-right-from-bracket"></i></a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.account == null}">
                        <a class="header-usernav__item red-hover cart pointer js-login-require" title="Login to see your cart!">
                            <i class="fa-solid fa-cart-shopping"></i>
                        </a>
                        <div class="usersubnav-switch">
                            <a href="signup.jsp" class="header-usernav__item red-hover user">
                                <i class="fa-solid fa-user" title="Sign up for an account"></i>
                            </a>
                        </div>
                    </c:if>
                </div>
        </section>