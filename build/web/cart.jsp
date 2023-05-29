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
        <link rel="stylesheet" href="./css/item.css">        
        <title>Comic Max - Comic & Manga Shop</title>
        <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
        <jsp:useBean id="loadItem" class="dao.ItemDAO" scope="request"></jsp:useBean>
        <jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>Cart</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <span>cart</span>
                </p>
            </div>   
        </div>
        <section class="body-container">
            <div class="body">
                <div class="itemlist">
                    <div class="item-head">
                        <div class="checkbox">
                            <input type="checkbox" title="Select all" class="js-select-all">
                        </div>
                        <div class="image">Image
                        </div>
                        <div class="title" style="justify-content: center">
                            Title
                        </div>
                        <div class="price">Price</div>
                        <div class="amount">Amount</div>
                        <div class="total">Total</div>
                        <div class="delete" style="visibility: hidden"></div>
                    </div>
                    <c:forEach items="${loadItem.getAllItemsByUser(sessionScope.account)}" var="o">
                    <c:set var = "b" scope = "request" value = "${loadBook.getBookById(o.getPid())}"/>
                    <div class="item" data-pid="${o.getPid()}">
                        <div class="checkbox">
                            <input type="checkbox" class="js-select">
                        </div>
                        <div class="image" title="${b.getName()}">
                            <a href="product?pid=${o.getPid()}">
                                <img src="${b.getImg()}" alt="${b.getName()}">
                            </a>
                        </div>
                        <a href="product?pid=${o.getPid()}" class="title red-hover" title="${b.getName()}">
                            <span>${b.getName()}</span>
                        </a>
                        <div class="price">$${b.getPrice()}</div>
                        <div class="amount">
                            <button type="button" class="js-minus">-</button>
                            <input type="number" class="js-amount" value="${o.getAmount()}" min="1" max="100">
                            <button type="button" class="js-add">+</button>
                        </div>
                        <div class="total">$${o.getTotal(b.getPrice())}</div>
                        <div class="delete js-delete" title="Delete this product">
                            <span>x</span>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div class="item-list sticky">
                    <div class="item-head pay">
                        <div class="checkbox select">
                            <input type="checkbox" title="Select all" class="js-select-all">
                        </div>
                        <div class="select-all">
                            <label for="select-all" class="option select-all-btn">Select all</label>
                            <input id="select-all" type="checkbox" title="Select all" class="js-select-all" style="display: none">
                        </div>
                        <div class="delete-all">
                            <div class="option js-delete-all">Delete all</div>
                        </div>
                        <div class="total-payment">
                            <div>
                                Total payment:
                                <div style="color:var(--red); font-weight: bolder; display: inline-block">
                                    <span>$ </span>
                                    <span class="total js-total-cart" style="">0</span>
                                </div>
                            </div>
                        </div>
                        <div class="buy">
                            <div class="button">Buy</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script type="module" src="js/Cart/index.js"></script>
    </body>
</html>
