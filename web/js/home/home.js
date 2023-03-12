import SlideShow from "./slideshow.js";
window.onload = function(){
    localStorage.removeItem('username');
    SlideShow(0);
}