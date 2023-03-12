class Slide{
    constructor(slide){
        this.slide = slide
        this.img = slide.children[0];
        this.content = slide.children[1]
    }
    setDot(dot){
        this.dot = dot
    }
    active(){
        this.slide.classList.remove("hide")
        this.img.classList.remove('fade-img')
        this.img.classList.add('active-img')
        this.content.classList.remove('fade-content')
        this.content.classList.add('active-content')
        this.dot.classList.add('active-dot')
    }
    fade(){
        this.slide.classList.add("hide")
        this.img.classList.remove('active-img')
        this.img.classList.add('fade-img')
        this.content.classList.remove('active-content')
        this.content.classList.add('fade-content')
        this.dot.classList.remove('active-dot')

    }
    hide(){
        this.slide.classList.add("hide")
        this.img.classList.remove('fade-img')
        this.content.classList.remove('fade-content')
    }
}
//
const slides = [...document.querySelectorAll(".slide")].map((slide)=>new Slide(slide))
const dots = [...document.querySelectorAll(".dot")].map((dot,i)=>{slides[i].setDot(dot)})
const n = slides.length
var curr = 0, last = slides.length-1, timeout
function inRange(val){
    if(val>=n) return 0
    if(val<0) return n-1
    return val
}
function activeSlide(index){
    slides.forEach((slide,i) => {
        if(i===index){
            slide.active()
        }
        else if(i===last){
            slide.fade()
        }
        else{
            slide.hide()
        }
    })
    last = index
    curr = inRange(index+1)
}
export default function SlideShow(index){ //bat dau tu slide thu index
    activeSlide(index)
    timeout = setTimeout(()=>{
        SlideShow(curr)
    },7000)
    
}