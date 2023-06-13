<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="accountDAO" class="dao.AccountDAO" scope="request"></jsp:useBean>
<jsp:useBean id="util" class="dao.Utils" scope="request"></jsp:useBean>
    <section id="comment">
        <h1>Reviews</h1>
    <c:if  test="${sessionScope.account != null}">

        <form class="comment" action="./comment" method="POST" >

            <div class="comment__user-info">
                <div class="avatar">
                    <img src="./img/temp.webp" alt="">
                </div>
                <div class="username">
                    ${sessionScope.account.getFullname()}
                </div>
            </div>
            <p>
                <textarea 
                    rows="3" 
                    class="text-area"
                    placeholder="Comment"
                    name="content"
                    title="Comment"
                    required    
                    ></textarea>
            </p>
            <c:if test="${didUserBuyProduct}">
                <div style="display:flex; margin-bottom: .5rem"> 
                    <span style="margin-right: 1rem">Rating: </span>
                    <div id="rating" style="margin-right: 1rem">
                        <label for="1star">
                            <input type="radio" id="1star" name="rating" value="1">
                        </label>
                        

                        <label for="2star">
                            <input type="radio" id="2star" name="rating" value="2">
                        </label>
                        

                        <label for="3star">
                            <input type="radio" id="3star" name="rating" value="3">
                        </label>
                        

                        <label for="4star">
                            <input type="radio" id="4star" name="rating" value="4">
                        </label>
                        

                        <label for="5star">
                            <input checked type="radio" id="5star" name="rating" value="5">
                        </label>
                        
                    </div>
                    <div id="ratingState"></div>
                </div>
            </c:if>
            <c:if test="${!didUserBuyProduct}">
                <p style="font-size: .8rem"><i>Buy this product to rating!</i></p>
            </c:if>
            <input name="book_id" value="${book.getId()}" style="display: none">
            <button type="submit" class="button" style="padding:8px 12px">Comment</button>
        </form>
    </c:if>
    <c:if  test="${sessionScope.account == null}">
        <div class="comment">
            <a href="./login.jsp" style="color: teal"> Đăng nhập</a> để bình luận.
        </div>
    </c:if>


    <c:forEach items="${comments}" var="o">
        <div class="comment">
            <div style="display: flex; align-items: center">
                <div class="comment__user-info">
                    <div class="avatar">
                        <img src="${accountDAO.getAvatarByUsername(o.getUsername())}" alt="">
                    </div>

                    <div class="username">
                        ${accountDAO.getFullnameByUsername(o.getUsername())}
                    </div>
                </div>
                <span style="margin: 0 8px"> | </span>
                <div style="display: flex; align-items: center; font-size: 10px;">
                    <div class="rating" title="${o.getRating()}/5 stars">
                        <c:forEach begin="1" end="${o.getRating()}"><i></i></c:forEach>
                        <c:forEach begin="${o.getRating()+1}" end="5"><u></u></c:forEach>
                        </div>
                        <span style="margin-left: .75rem">${o.getPostTime()}</span>
                </div>
            </div>

            <form method="POST" id="commentForm${o.getId()}">
                <input name="id" value="${o.getId()}" style="display: none">
                <div class="comment__user-content" style="font-size: 14px" id="comment${o.getId()}">
                    ${o.getContent()}
                </div>
                <c:if  test="${sessionScope.account.getUsername() == o.getUsername()}">
                    <div style="padding: 4px 0" id="btns${o.getId()}">
                        <button type="button" data-id="${o.getId()}" onclick="editComment(this)" style="color: teal"> Edit </button> | 
                        <button type="button" data-id="${o.getId()}" onclick="deleteComment(${o.getId()})" style="color: #6f6f6f"> Delete </button>
                    </div>
                </c:if>
            </form>
        </div>
    </c:forEach>
    <script type="module" src="./js/comment.js"></script>
</section>