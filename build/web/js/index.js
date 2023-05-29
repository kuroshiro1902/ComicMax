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
    },
    'delete':{
        icon : '<i class="fa-solid fa-mark"></i>',
        title : "Delete",
        message : "Do you want to delete this product!",
        href : false
    }
}
init()
try{loginRequire();searchBtnAppearance()}catch(err){}

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
    
}
function searchBtnAppearance(){
    searchField.addEventListener('keyup',(e)=>{
        if(e.target.value === '')
            searchBtn.style.display='none'
        else searchBtn.style.display='block'
    })
}
function toastMessage(type, title, message){
    //type = ["confirm", "info", "warning"]
    const toast_content = `<div class="toast__icon">
          <i class="fas fa-check-circle"></i>
     </div>
     <div class="toast__text">
          <h3 class="toast__title">${title}</h3>
          <div class="toast_message">${message}</div>
     </div>
     <div class="toast__close">
          <i class="fas fa-close"></i>
     </div>`
    const toast = createComponent('div',`toast toast_${type}`,null,null)
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
confirm.onclick = hideConfirm
$(".button-cancel").onclick = hideConfirm
$("#confirm .button-confirm").addEventListener('click',hideConfirm)
//$("#confirm .confirm").onclick = function(e){
//    e.stopPropagation()
//}
function Confirm(action,cb=undefined,mes){
    $("#confirm .confirm-title").innerHTML = `${confirm_action[action].icon} ${confirm_action[action].title}`
    confirm_action[action].href ? $("#confirm .button-confirm").href = confirm_action[action].href : null
    $("#confirm .button-confirm").onclick = cb
    $("#confirm .confirm-content").innerHTML = mes? mes : confirm_action[action].message
    showConfirm()
    return 1
}
function loginRequire(){
    const reqs = $(".js-login-require")
    try{
        reqs.forEach(req=>{
            req.addEventListener('click',()=>{Confirm('login')})
        })
    }
    catch(err){
        reqs.addEventListener('click',()=>{Confirm('login')})
    }
    
}
        
