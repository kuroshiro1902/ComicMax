<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <jsp:useBean id="bookDAO" class="dao.BookDAO" scope="request"></jsp:useBean>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/globalStyle.css">
        <link rel="stylesheet" href="./css/home/home.css">
        <link rel="stylesheet" href="css/pay.css">
        <title>Comic Max - Comic & Manga Shop</title>
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
                <div class="main">
                
                
                        <c:if test="${items.size()<=0}">
                            Không có mặt hàng này trong giỏ hàng!
                        </c:if>
                        <c:if test="${items.size()>0}">
                            <form class="product-form" method="POST" action="./pay">
                    <div class="row">
                        <label for="fullname">Họ tên: </label>
                        <input id="fullname" name="fullname" type="text" value="${sessionScope.account.getFullname()}" disabled="disabled">
                    </div>
                    <div class="row">
                        <label for="address">Địa chỉ: </label>
                        <input id="address" name="address" type="text" required>
                    </div>

                    <div class="row">
                        <label for="phone">Số điện thoại: </label>
                        <input id="phone" name="phone" type="text" required>
                    </div>

                    <div class="row">
                        <label for="email">Email: </label>
                        <input id="email" name="email" type="email" required>
                    </div>

                    <div class="row">
                        <label for="note">Ghi chú: </label>
                        <textarea id="note" name="note" rows="6"></textarea>
                    </div>

                    <div class="row">
                        <label for="payment">Phương thức thanh toán: </label>
                        <select id="payment" name="payment" style="padding: 8px">
                            <option value="cash">Tiền mặt</option>
                            <option value="credit">Thẻ tín dụng</option>
                            <option value="bank">Chuyển khoản ngân hàng</option>
                            <option value="paypal">PayPal</option>
                        </select>
                    </div>
                    <button type="submit" style="padding: 16px 36px 16px 36px; font-size: 18px;" class="button" >Thanh Toán</button>
                </form>
                    <div class="product-info">
                        <div style="border: 1px solid var(--red);border-radius: 8px;">
                            <div class="item" style="font-weight: bolder">
                                <div>
                                     
                                </div>
                               
                                <div>Name</div>
                                <div>Amount</div>
                                <div style="color: var(--red); font-weight: bold">Total</div>
                        </div>
                            <c:forEach items="${items}" var="o">
                             <c:set var = "book" scope = "request" value = "${bookDAO.getBookById(o.getPid())}"/>
                            <div class="item">
                                <div>
                                     <div class="img" style="background-image: url(${book.getImg()})"></div>
                                </div>
                               
                                <div>${book.getName()}</div>
                                <div>$${book.getPrice()} x ${o.getAmount()}</div>
                                <div style="color: var(--red); font-weight: bold">$${Math.round(book.getPrice()*o.getAmount() * 100.0) / 100.0}</div>
                        </div>
                        </c:forEach>
                            
                        </div>
                        <div class="total">
                            <div>
                                <span style="font-weight: bolder">Total: </span>
                                <span data-total class="num">${totalPrice} </span>
                            </div>
                        </div>
                        </c:if>
                        
                </div>
                </div>
                
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
    </body>
</html>