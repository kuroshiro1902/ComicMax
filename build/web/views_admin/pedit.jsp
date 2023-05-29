<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
    <div style="display:flex;flex-direction: column;align-items: center">
        <div style="min-width: 678px; width: 90%;">
            <div class="item">
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
                        <div class="edit"></div>
                    </div>
        <c:forEach items="${products}" var="o">
            <div class="item" data-pid="${o.getId()}">
                <div class="checkbox">
                    <input type="checkbox" class="js-select">
                </div>
                <div class="image" title="${o.getName()}">
                    <a href="${o.getImg()}" target="_blank">${o.getImg().substring(0,25)}...</a>
                </div>
                <a href="product?pid=${o.getId()}" class="title red-hover" title="${o.getName()}">
                    <span>${o.getName()}</span>
                </a>
                <div class="price">
                    <span>$${o.getPrice()}</span>
                </div>
                <div class="amount">
                    <span>${o.getAmount()}</span>
                </div>
                <div class="edit">
                    <button class="js-show" title="Edit product">Edit</button>
                    <button class="js-delete" title="Delete product">Delete</button>
                </div>
            </div>
        </c:forEach>
        </div>
        <form method="POST" class="pages js-page-index" action="./admin" data-page-index="${index}">
             <c:forEach begin="1" end="${count}" var="o">
            <button class="button pageIndex" type="submit" name="index" value="${o}">${o}</button>
            </c:forEach>
        </form>
        <script type="module" src="./js/admin/editProduct.js"></script>
</div>
