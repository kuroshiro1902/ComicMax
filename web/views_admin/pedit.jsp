<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadAuthor" class="dao.AuthorDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadPublisher" class="dao.PublisherDAO" scope="request"></jsp:useBean>
    <form class="searchbar" >
        <input type="text" name="search">
        <input type="submit" value="Search" class="button" spellcheck="false">
    </form>
    <div style="padding: 8px 16px">
        <button id="add-book" style="float:right" class="button">Add Book</button>
        <div style="clear: both"></div>
    </div>
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
    <div id="edit-container">
        <div class="edit-field">
            <h3>Edit Product</h3>
            <input id="edit-id" style="display: none">
            <label for="edit-title">Title</label>
            <input id="edit-title" type="text" name="edit-title" placeholder="Title">
            <label for="edit-img">Image</label>
            <input id="edit-img" type="text" name="edit-img" placeholder="Image">
            <label for="edit-price">Price</label>
            <input id="edit-price" name="edit-price" type="number" placeholder="Price">
            <label for="edit-amount">Amount</label>
            <input id="edit-amount" name="edit-amount" type="text" placeholder="Amount">
            <div class="buttons">
                <button id="edit-confirm" class="button-confirm">Submit</button>
                <button id="edit-cancel" class="button-cancel">Cancel</button>
            </div>

        </div>
    </div>
    <div id="add-container">
        <form class="add-field" action="./addproduct">
            <h3>Add Product</h3>
            <label for="add-title">Title</label>
            <input id="add-title" type="text" name="name" placeholder="Title" required>
            <label for="add-category">Categories</label>
            <div>
                <c:forEach items="${loadCategory.allCategories}" var="o">

                    <label for="category${o.getId()}" class="category-tag">
                        <input id="category${o.getId()}" name="category_id" type="checkbox" value="${o.getId()}" >
                        ${o.getName()}
                    </label>
                </c:forEach>
            </div>
            <label for="add-img">Image</label>
            <input id="add-img" type="text" name="img" placeholder="Image" required>
            <label for="add-language">Language</label>
            <input id="add-language" type="text" name="language" placeholder="Language" required>
            <label for="add-publisher">Author</label>
            <div>
                <input name="author_name" placeholder="New author">
                <span>or existed author:</span>
                <select id="add-author" name="author_id" >
                    <c:forEach items="${loadAuthor.allAuthors}" var="o">
                        <option value="${o.getId()}" >${o.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <label for="add-publisher">Publisher</label>
            <div>
                <input name="publisher_name" placeholder="New publisher">
                <span> or existed Publisher: </span>
                <select id="add-publisher" name="publisher_id" >
                    <c:forEach items="${loadPublisher.allPublishers}" var="o">
                        <option value="${o.getId()}">${o.getName()}</option>
                    </c:forEach>
                </select>
            </div>

            <label for="add-price">Price</label>
            <input id="add-price" name="price" type="number" step="0.01" placeholder="Price" required>
            <label for="add-amount">Amount</label>
            <input id="add-amount" name="amount" type="text" placeholder="Amount" required>
            <div class="buttons">
                <button id="add-confirm" type="submit" class="button-confirm">Submit</button>
                <button id="add-cancel" type="button" class="button-cancel">Cancel</button>
            </div>

        </form>
    </div>
    <form method="POST" class="pages js-page-index" action="./admin" data-page-index="${index}">
        <c:forEach begin="1" end="${count}" var="o">
            <button class="button pageIndex" type="submit" name="index" value="${o}">${o}</button>
        </c:forEach>
    </form>
    <script type="module" src="./js/admin/editProduct.js"></script>
    <script type="module" src="./js/admin/addProduct.js"></script>
    <script type="module" defer>
        function hideAddContainer(){
            $("#add-container").style.display = 'none'
        }
        $("#add-container").onclick = hideAddContainer
        $("#add-cancel").onclick = hideAddContainer
        $("form.add-field").onclick = (e)=>{e.stopPropagation()}
    </script>
</div>
