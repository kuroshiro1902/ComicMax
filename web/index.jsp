<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/f8624d60dd.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="./css/globalStyle.css">
    <link rel="stylesheet" href="./css/home/home.css">
    <title>Comic Max - Comic & Manga Shop</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <section class="body-container">
        <div class="body">
            <div class="slideshow-container">
                <div class="slideshow">
                    <div class="slide1 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>NEW MANGA RELEASES</h1>
                                <p>We've updated all of the new manga series releasing in 2023 in everyweek! A comprehensive and up-to-date list. Check it out!</p>
                            </div>
                        </div>
                    </div>
                    <div class="slide2 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>ALL COMIC CATEGORIES</h1>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Perspiciatis sapiente mollitia quam. Placeat temporibus atque vero molestiae nesciunt facere velit ab harum, maxime numquam? Non, architecto. Illo dolorem consectetur veniam?</p>
                            </div>
                        </div>
                    </div>
                    <div class="slide3 slide">
                        <div class="slide__img"></div>
                        <div class="slide__content">
                            <div>
                                <h1>CHARACTER FIGURES</h1>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Necessitatibus neque dolor libero saepe. Natus, incidunt! Vero, amet! Accusantium voluptatum placeat veritatis aperiam facilis pariatur reprehenderit numquam aut veniam. Neque, voluptatem.</p>
                            </div>
                        </div>
                    </div>
                    <div class="slidedot center-block">
                        <span class="dot dot1"></span>
                        <span class="dot dot2"></span>
                        <span class="dot dot3"></span>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script type="module" src="./js/home/home.js"></script>
</body>
</html>