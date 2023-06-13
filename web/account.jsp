<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="./css/home/home.css">
        <link rel="stylesheet" href="./css/account.css">
        <title>Comic Max - Comic & Manga Shop</title>
        <style>
            .login-required:hover{
                text-decoration: underline;
                color: var(--red);
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <div class="breadcrumb">
            <div class="breadcrumb-content">
                <h1>My Account</h1>
                <p>
                    <a href="index.jsp" class="red-hover" style="opacity: 0.7">home</a> >
                    <span>account</span>
                </p>
            </div>   
        </div>
        <section class="body-container container">
            <div class="body">
                <c:if test="${sessionScope.account != null}">
                    <section id="account">
                        <div class="user-info card">
                            <span class="edit-btn" title="Edit information"><i class="fa-solid fa-pen-to-square"></i></span>
                            <div class="avatar">
                                <img src="${sessionScope.account.getAvatar()}" alt="Avatar">
                            </div>
                            <h2 class="full-name">${sessionScope.account.getFullname()} </h2>
                            <p class="username">Username: ${sessionScope.account.getUsername()}</p>
                            <p class="password">Password: ********</p>
                            <p >Email: example@example.com </p>
                            <p class="phone">Phone: 0123456789</p>
                            <p class="address">Address: Hà Nội, Việt Nam</p>
                        </div>
                        <div class="order-info">
                            <div style="display:flex; gap:1rem">
                                <div class="card" style="flex:1">
                                    <p class="cart-orders">Number of orders delivering: ${deliveringAmount}</p>
                                </div>
                                <div class="card" style="flex:1">
                                    <p class="purchased-orders">Number of orders purchased: ${doneAmount}</p>
                                </div>
                            </div>
                            <div class="card chart">
                                <canvas style="margin: auto" id="ColumnChart"></canvas>
                                <h4 style="text-align: center">Number of products purchased by month.</h4>
                            </div>
                        </div>

                    </section>
                    <div class="overlay">
                        <div class="edit-container" style="display: ${message!=null? flex : none}">
                            <form action="./account" method="POST" enctype="multipart/form-data">
                                <table>
                                    <tr>
                                        <td><label for="fullname">Fullname:</label></td>
                                        <td><input type="text" id="fullname" name="fullname" value="${sessionScope.account.getFullname()}" required></td>
                                    </tr>
                                    <tr>
                                        <td><label for="username">Username:</label></td>
                                        <td><input type="text" id="username" name="username" autocomplete="username" value="${sessionScope.account.getUsername()}" disabled></td>
                                    </tr>
                                    <tr>
                                        <td><label for="password">Password:</label></td>
                                        <td><input type="password" id="password" name="password" autocomplete="new-password" required></td>
                                    </tr>
                                    <tr>
                                        <td><label for="confirm-password">Confirm password:</label></td>
                                        <td><input type="password" id="confirm-password" name="confirm" autocomplete="new-password" required></td>
                                    </tr>
                                    <tr>
                                        <td><label for="avatar">Avatar:</label></td>
                                        <td><input type="file" id="avatar" name="avatar" accept=".jpg, .jpeg, .png, .webp"></td>
                                    </tr>
                                </table>
                                        <c:if test="${message != null}">
                                            <p style="display: inline-block; padding: 4px; border-radius: 4px; background: var(--red); color: #fff">
                                                <i style="font-size: .875rem">${message}</i>
                                            </p>
                                        </c:if>
                                    
                                            <p style="padding: 8px; text-align: center"><button class="button" type="submit">Submit</button></p>
                            </form>

                        </div>
                    </div>
                </c:if>
                <c:if test="${sessionScope.account == null}">
                    <h1 style="font-weight: bolder">Please <a class="login-required" href="./login.jsp"><strong>login</strong></a> to see your account</h1>
                </c:if>
            </div>
        </section>
        <jsp:include page="footer.jsp" />
        <script src="./js/index.js"></script>
        <script type="module">
            import drawColumnChart from "./js/admin/api/drawColumnChart.js"
            toastMessage('info', 'Suggest', 'Reload page if you don\'t see your avatar!')
            
            $(".overlay").style.display = ${message!='success'}?'flex':'none';
            $(".overlay").style.display = ${message!=null && message!="success"}?'flex':'none';
            //

            $(".overlay").onclick = (e) => {
                e.target.style.display = 'none'
            }
            $(".edit-container").onclick = (e) => {
                e.stopPropagation()
            }
            $(".edit-btn").onclick = () => {
                $(".overlay").style.display = 'flex'
            }
            drawColumnChart(${monthDatas})
        </script>
    </body>
</html>
