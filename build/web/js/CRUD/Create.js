const product = $("#product")
function cartItem(item){
    const child = 
            `
                <div class="cart-item__img" style="background-image: url('${item.img}')"></div>
                <div class="cart-item__title red-hover"><a href>${$(".main-product-title").innerText}</a></div>
                <div class="cart-item__price" style="position:relative">${$(".main-product-price").innerText} <span style="position:absolute;top:100%;left:0"> x ${item.amount}</span></div>
            `
    const e = createComponent('div','cart-item',false,child)
    e.setAttribute('data-pid',item.pid)
    return e
}
export default function Create(){ //Add item to cart
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
            toastMessage('confirm','Done!','Products have been added to cart')
            setTimeout(()=>{window.location.reload()},2000)
            console.log(data)
        })
        .catch(function(err){
            toastMessage('warning','Oops!','Something wrong, try again.')  
        console.log(err)
        })
    }
}