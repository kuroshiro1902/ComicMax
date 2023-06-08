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
    <link rel="stylesheet" href="./css/delivery.css">
    <title>Comic Max - Comic & Manga Shop</title>
    <jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
    <jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>Delivery</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home </a> >
                    <a href="cart.jsp" class="red-hover" style="opacity: 0.7">Cart </a> >
                    <span>Delivery</span>
                </p>
            </div>   
        </div>
        <section class="body-container">
            <div class="body">
                <a href="cart.jsp" class="button" style="float:right">Cart</a>
                <div style="clear:both"></div>
                <div class="itemlist">
                    <div class="item-head">
                        
                        <div class="image">Image
                        </div>
                        <div class="title" style="justify-content: center">
                            Title
                        </div>
                        <div class="price">Price</div>
                        <div class="amount">Amount</div>
                        <div class="total">Total</div>
                        <div>State</div>
                    </div>
                    <c:forEach items="${orderDeliveryItem}" var="o">
                    <c:set var = "b" scope = "request" value = "${loadBook.getBookById(o.getBookId())}"/>
                    <div class="item" data-id="${o.getId()}">

                        <div class="image" title="${b.getName()}">
                            <a href="product?pid=${o.getBookId()}">
                                <img src="${b.getImg()}" alt="${b.getName()}" loading="lazy">
                            </a>
                        </div>
                        <a href="product?pid=${o.getBookId()}" class="title red-hover" title="${b.getName()}">
                            <span>${b.getName()}</span>
                        </a>
                        <div class="price">$${b.getPrice()}</div>
                        <div class="amount">
                            <div> ${o.getAmount()}</div>
                        </div>
                        <div class="total">$${o.getTotal(b.getPrice())}</div>
                        <button id="deliveringBtn" style="font-weight: bold; color: green; padding: 4px; border-radius: 4px;" title="Click for more detail">Delivering</button>
                    </div>
                    </c:forEach>
                    <c:forEach items="${doneDeliveryItem}" var="o">
                    <c:set var = "b" scope = "request" value = "${loadBook.getBookById(o.getBookId())}"/>
                    <div class="item" data-id="${o.getId()}">

                        <div class="image" title="${b.getName()}">
                            <a href="product?pid=${o.getBookId()}">
                                <img src="${b.getImg()}" alt="${b.getName()}" loading="lazy"> 
                            </a>
                        </div>
                        <a href="product?pid=${o.getBookId()}" class="title red-hover" title="${b.getName()}">
                            <span>${b.getName()}</span>
                        </a>
                        <div class="price">$${b.getPrice()}</div>
                        <div class="amount">
                            <div> ${o.getAmount()}</div>
                        </div>
                        <div class="total">$${o.getTotal(b.getPrice())}</div>
                        <button id="doneBtn" style="font-weight: bold; color: #0194d1; padding: 4px; border-radius: 4px;" title="Click for more detail">Done</button>
                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="overlay">
                <div class="delivery-detail">
                    <img src="./img/temp.webp" class="detail-img">
                    <h2 id="title">Loading...</h2>
                    <p><strong>Total: $</strong><strong id="total">Loading...</strong></p>
                    <p>Price: $<span id="price">Loading...</span></p>
                    <p>Amount: <span id="amount">55</span></p>
                    <p>Address: <span id="address">Loading...</span></p>
                    <p>Phone: <span id="phone">Loading...</span></p>
                    <p>Payment: <span id="payment">Loading...</span></p>
                    <p>Note: <span style="font-size: 14px" id="note">Loading...</span></p>
                    <p>Order time: <span id="order-time">Loading...</span></p>
                    <p>Done time: <span id="done-time">Loading...</span></p>
                    <p id="buttons" style="display: flex; flex-direction: column; justify-content: center; align-items: center; margin-top: 1rem">
                        <button class="button-confirm">I have received the package.</button>
                    </p>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script defer type="module" src="./js/delivery.js"></script>
    </body>
</html>
