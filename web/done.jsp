<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:useBean id="bookDAO" class="dao.BookDAO" scope="request"></jsp:useBean>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/globalStyle.css">
        <link rel="stylesheet" href="./css/home/home.css">
        <link rel="stylesheet" href="css/pay.css">
        <title>Đặt hàng thành công</title>
    </head>
    <body>
        <jsp:include page="header.jsp" />

        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>PAY</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">Home </a> >
                    <a href="cart.jsp" class="red-hover" style="opacity: 0.7">Cart </a> >
                    <span>Pay</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <div class="body">
                <div class="main" style="flex-direction: column">
                    <div>
                        <h2>Order Completed!</h2>
                        <a style="margin: .5rem 0" class="button" href="./cart.jsp">Back to cart</a>
                        <p>Thanks for choosing our products. <a href="./shop.jsp" style="color: teal">Watch more products.</a></p>
                    </div>
                    
                    <div class="product-info">
                        <div style="border: 1px solid var(--red);border-radius: 8px;">
                            <div class="item" style="font-weight: bolder">
                                <div>

                                </div>

                                <div>Name</div>
                                <div>Amount</div>
                                <div style="color: var(--red); font-weight: bold">Total</div>
                            </div>
                            <c:forEach items="${deliveryitems}" var="o">
                                <c:set var = "book" scope = "request" value = "${bookDAO.getBookById(o.getBookId())}"/>
                                <div class="item">
                                    <div>
                                        <div class="img" style="background-image: url(${book.getImg()})"></div>
                                    </div>

                                    <div>${book.getName()}</div>
                                    <div>$${book.getPrice()} x ${o.getAmount()}</div>
                                    <div data-price style="color: var(--red); font-weight: bold">$${Math.round(book.getPrice()*o.getAmount() * 100.0) / 100.0}</div>
                                </div>
                                
                            </c:forEach>
                                
                        </div>
                        <div class="total">
                            <div>
                                <span style="font-weight: bolder">Total: </span>
                                <span data-total class="num">${totalPrice} </span>
                            </div>
                        </div>
                </div>
            </div>

        </div>
    </section>

    <jsp:include page="footer.jsp" />
    <script src="./js/index.js"></script> 
</body>
</html>
