<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="bookDAO" class="dao.BookDAO" scope="request"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section style="padding: 1.5rem;">
    <form action= "./admin">
        <input style="" name="selected" value="delivery" hidden>
            <c:if test="${type == 'order'}">
                <input style="" name="type" value="done" hidden>
                <button class="button" type="submit">Purchased products</button>
            </c:if>
            <c:if test="${type == 'done'}">
                <input style="" name="type" value="order" hidden>
                <button class="button" type="submit">Delivering products</button>
            </c:if>
                <p style="text-align: end">
                    <label for="start-time">From: 
                        <input type="date" id="start-time" name="start-time" value="${startTime}">
                    </label>
                    <label style="margin-left:1.5rem" for="end-time">To: 
                        <input type="date" id="end-time" name="end-time" value="${endTime}">
                    </label>
                    <button id="filter" type="submit" class="button" style="padding: 4px 16px 4px 16px">Filter</button>
                </p>
                <script>
                    const filterSubmit = document.getElementById("filter")
                    const startTime = document.getElementById("start-time")
                    const endTime = document.getElementById("end-time")
                    filterSubmit.title = "From: "+startTime.value+"\nTo: " + endTime.value
                    const changeTitle = ()=>{
                        filterSubmit.title = "From: "+startTime.value+"\nTo: " + endTime.value
                    }
                    startTime.onchange = changeTitle
                    endTime.onchange = changeTitle
                </script>
    </form>
    <h2 style="text-align: center; margin-bottom: .5rem"><strong>
            <c:if test="${type == 'order'}">
                Delivering products
            </c:if>
            <c:if test="${type == 'done'}">
                Purchased products
            </c:if></strong></h2>
    <div style="max-height: 80vh; overflow-y: scroll">        
    <table >
        <thead>
            <tr>
                <th>No</th>
                <th>Username</th>
                <th>Product</th>
                <th>Amount</th>
                <th>Payment</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Note</th>
                <c:if test="${type == 'order'}">
                    <th>Order time</th>
                </c:if>
                <c:if test="${type == 'done'}">
                    <th>Order time</th>
                    <th>Done time</th>
                </c:if>
                
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${deliveryItemList}" var="o"  varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${o.getUsername()}</td>
                <td style="color: var(--red)"><a href="./product?pid=${o.getBookId()}">${bookDAO.getBookById(o.getBookId()).getName()}</a></td>
                <td>${o.getAmount()}</td>
                <td>${o.getPayment()}</td>
                <td>${o.getAddress()}</td>
                <td>${o.getPhone()}</td>
                <td style="max-width: 120px">${o.getEmail()}</td>
                <td style="max-width: 90px">${o.getNote()}</td>
                <c:if test="${type == 'order'}">
                    <td>${o.getOrderTime()}</td>
                </c:if>
                <c:if test="${type == 'done'}">
                    <td style="max-width: 120px">${o.getOrderTime()}</td>
                    <td style="max-width: 120px">${o.getDoneTime()}</td>
                </c:if>
                
            </tr>
            </c:forEach>
            
        </tbody>
    </table>
            </div >

</section>