const searchField = $(".searchbar input[type=\"text\"]")
const searchBtn = $(".searchbar input[type=\"submit\"]")
const userSubnav = $(".usersubnav-switch .subnav")
const toastContainer = $("#toast")
const confirm = $("#confirm")
const confirm_action = {
    'login':{
        icon : '<i class="fa-solid fa-user"></i>',
        title : "Login Required!",
        message : "Do you want to log in?",
        href : 'login.jsp'
    }
}
init()
searchBtnAppearance()
try{loginRequire()}catch(err){}

function $(selector){
    let doms = document.querySelectorAll(selector)
    return doms.length>1?[...doms]:doms[0]
}
function createComponent(tag='div', className=null, styles=null, child=null) {
    const e = document.createElement(tag==null? 'div':tag);
    e.className = className
    e.style = styles
    child===null? null:e.innerHTML = child
    return e
}
function init(){
    //disable spellcheck
    $("input").forEach((input)=>{input.setAttribute("spellcheck","false")})
    //show, hide confirm alert
    confirm.addEventListener('click',function(){
        hideConfirm()
    })
    $("#confirm .confirm").addEventListener('click',function(e){
        e.stopPropagation()
    })
    $(".button-cancel").addEventListener('click',function(){
        hideConfirm()
    })
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
function hideConfirm(){
    confirm.className=""
}
function showConfirm(){
    confirm.className="show"
}

//
function Confirm(action){
    $("#confirm .confirm-title").innerHTML = `${confirm_action[action].icon} ${confirm_action[action].title}`
    $("#confirm .button-confirm").href = confirm_action[action].href
    $("#confirm .confirm-content").innerHTML = confirm_action[action].message
    showConfirm()
}
function loginRequire(){
    const reqs = $(".js-login-require")
    reqs.forEach(req=>{
        req.addEventListener('click',()=>{Confirm('login')})
    })

}
        
