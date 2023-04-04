const product = $("#product")
export default function AddToCart(){
    const pid = product.getAttribute('data-id')
    const amount = $("#quantity").value
    const pushObj = {pid,amount}
    if(!amount || amount==0){
        toastMessage('info','Invalid!','Quantity must be greater than 0!')
    }
    else{
        fetch(window.location.href.split("?").join("api?"),{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(pushObj),
        })
        .then(res=>res.json())
        .then(data=>{
            $("#quantity").value = null
            toastMessage('confirm','Done!','Products have been added to cart.') 
            console.log(data)
        })
        .catch(function(){
            toastMessage('warning','Oops!','Something wrong, try again.')      
        })
    }
}