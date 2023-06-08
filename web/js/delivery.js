import convertSingleToArray from "./utils/convertSingleToArray.js"
const overlay = $(".overlay")
const detailCtn = $(".delivery-detail")
const detailBtns = convertSingleToArray($("#deliveringBtn")).concat(convertSingleToArray($("#doneBtn")))

const showDetail = ()=>{
    detailCtn.classList.remove('slide-out')
    detailCtn.classList.add('slide-in')
    overlay.style.display = 'block'
}
const hideDetail = ()=>{
    detailCtn.classList.remove('slide-in')
    detailCtn.classList.add('slide-out')
    setTimeout(()=>{
        overlay.style.display = 'none'
    },500)
}
const doneSubmit = (id)=>{
    fetch("./deliveryapi?id="+id,{method: 'POST'})
            .then(res=>{
                if(res.status == 200){
                    toastMessage('confirm','Done!','Received the package.')
                    setTimeout(()=>{window.location.reload()},1000)
                    
                }
            })
                    .catch(err=>{
                        console.log(err)
                        toastMessage('warning','Error!','Something wrong! Try again.')
                    })
}
detailCtn.onclick = (e)=>{e.stopPropagation()}
overlay.onclick = hideDetail

detailBtns.forEach(detailBtn=>{
    const item = detailBtn.parentNode
    const id = item.getAttribute('data-id')
    detailBtn.onclick = ()=>{
       showDetail()
       fetch("./deliveryapi?id="+id)
               .then(res=>res.json())
               .then(data=>{
                   const {deliveryItem, book} = data
                   $(".detail-img").src = book.img
                   $("#title").innerHTML = book.name
                   $("#total").innerHTML = Number(book.price)*Number(deliveryItem.amount)
                   $("#price").innerHTML = book.price
                   $("#phone").innerHTML = deliveryItem.phone
                   $("#amount").innerHTML = deliveryItem.amount
                   $("#address").innerHTML = deliveryItem.address
                   $("#payment").innerHTML = deliveryItem.payment
                   $("#note").innerHTML = deliveryItem.note
                   $("#order-time").innerHTML = deliveryItem.orderTime
                   $("#done-time").innerHTML = deliveryItem.doneTime??"Delivering"
                   $("#buttons").style.display = deliveryItem.doneTime? 'none' : 'flex'
                   //event
                   if(!deliveryItem.doneTime){
                       $("#buttons .button-confirm").onclick=()=>{doneSubmit(id)}
                   }
                   else{}
               })
    }
    
})