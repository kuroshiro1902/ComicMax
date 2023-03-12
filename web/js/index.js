const searchField = $(".searchbar input[type=\"text\"]")
const searchBtn = $(".searchbar input[type=\"submit\"]")
const userSubnav = $(".usersubnav-switch .subnav")
const toastContainer = $("#toast")
disableSpellcheck()
searchBtnAppearance()
function $(selector){
    let doms = document.querySelectorAll(selector)
    return doms.length>1?[...doms]:doms[0]
}
function createComponent(tag='div', className=null, styles=null, child=null) {
    const e = document.createElement(tag==null? 'div':tag);
    e.className = className
    e.style = styles
    child===null? null:e.append(...child)
    return e
}
function disableSpellcheck(){
    $("input").forEach((input)=>{input.setAttribute("spellcheck","false")})
}
function searchBtnAppearance(){
    searchField.addEventListener('keyup',(e)=>{
        if(e.target.value === '')
            searchBtn.style.display='none'
        else searchBtn.style.display='block'
    })
}
function toastMessage(type){
    let message
    if (type=='add')
        message = "Product added to cart."
    else
        message = "Deleted product from cart."
    const toast_content = `<div class="toast__icon">
          <i class="fas fa-check-circle"></i>
     </div>
     <div class="toast__text">
          <h3 class="toast__title">Done!</h3>
          <div class="toast_message">${message}</div>
     </div>
     <div class="toast__close">
          <i class="fas fa-close"></i>
     </div>`
    const toast = createComponent('div','toast',null,null)
    toast.innerHTML = toast_content
    toastContainer.append(toast)
    setTimeout(()=>{toast.remove()},4000)
}