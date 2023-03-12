const message = $(".message")
const username = $("#username-login")
const password = $("#password-login")
const submit = $(".login input[type=\"submit\"]")

username.value = localStorage.getItem('username')

submit.onclick = ()=>{
    localStorage.setItem('username', username.value);
}
wrongPasswordHandler()

function wrongPasswordHandler(){
    if(message.innerText !== ''){
        {message.classList.add("alert-message")}
    }
}