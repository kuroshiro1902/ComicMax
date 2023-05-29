<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section id="comment" loading="lazy">
    <h1>Reviews</h1>
    <c:forEach begin="1" end="4">
    <div class="comment">
        <div class="comment__user-info">
            <div class="avatar">
                <img src="./img/default.webp" alt="">
            </div>
            <div class="username">
                Username
            </div>
        </div>
        <div class="rating">
        <c:forEach begin="1" end="4"><i></i></c:forEach>
        <c:forEach begin="5" end="5"><u></u></c:forEach>
        <span>Feb/20/2023</span>
        </div>
        <div class="comment__user-content">
            I'm very happy with the quality of this manga. The book itself is so nice with the hard covers and large pages. This is my first berserk experience and It's been a joy to read
        </div>
    </div>
    </c:forEach>
</section>