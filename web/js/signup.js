const username = $("#username-signup")
const password = $("#password-signup")
const confirm = $("#confirm-signup")
const exist = $(".exist")
const message = $(".message")
const submit = $(".signup input[type=\"submit\"]")

if(exist.innerText !== ''){
    exist.classList.add("account-exist")
}
function checkPasswordConfirm(confirmPass){
    if(confirmPass.value !== password.value && confirmPass.value !== ''){
        submit.disabled = true
        message.classList.add("alert-message")
    }
    else{
        submit.disabled = false
        message.classList.remove("alert-message")
    }
}
confirm.addEventListener('keyup',(e)=>{
    if(username.value!==''){
        checkPasswordConfirm(e.target)
    }
    else{
        checkPasswordConfirm(confirm)
    }
    
})