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
                <form class="main" method="POST" action="">
                    <div class="row">
                        <label for="fullname">Họ tên: </label>
                        <input id="fullname" name="fullname" type="text" value="${sessionScope.account.getFullname()}" disabled="disabled">
                    </div>
                    <div class="row">
                        <label for="address">Địa chỉ: </label>
                        <input id="address" name="address" type="text">
                    </div>

                    <div class="row">
                        <label for="phone">Số điện thoại: </label>
                        <input id="phone" name="phone" type="text">
                    </div>

                    <div class="row">
                        <label for="email">Email: </label>
                        <input id="email" name="email" type="email">
                    </div>

                    <div class="row">
                        <label for="note">Ghi chú: </label>
                        <textarea id="note" name="note" rows="3"></textarea>
                    </div>

                    <div class="row">
                        <label for="payment">Phương thức thanh toán: </label>
                        <select id="payment" name="payment">
                            <option value="cash">Tiền mặt</option>
                            <option value="credit">Thẻ tín dụng</option>
                            <option value="bank">Chuyển khoản ngân hàng</option>
                            <option value="paypal">PayPal</option>
                        </select>
                    </div>
                </form>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
    </body>
</html>
