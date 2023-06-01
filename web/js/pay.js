console.log(123)
$('#submit').onclick = function() {
     const address = $('#address').value
     const phone = $('#phone').value
     const email = $('#email').values
     const note = $('#note').values
     const payment = $('#payment').value
     fetch(`./pay`,{
         method: 'POST'
         
     })  
}