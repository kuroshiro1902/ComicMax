import convertSingleToArray from "../utils/convertSingleToArray.js"
function totalCalculate(){
    $(".js-total-cart").innerText = Math.round(convertSingleToArray($(".item")).reduce((total,item)=>{
    try{
        return item.children[0].firstElementChild.checked? total + Number(item.children[5].innerText.substring(1)) : total
    }catch{
        return total
    }
    }
    ,0)*100)/100
}
function doDelete(item){
    const pid = item.getAttribute('data-pid')
    fetch(window.location.href.split(".jsp").join("api"),{
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pid)
    })
    .then(res=>res.json())
    .then((data)=>{
        console.log("Delete success: ", data)
        item.remove()
        toastMessage('confirm','Done!','Products have been deleted from cart')
        totalCalculate()
    })
    .catch((data)=>{
        console.log("Delete failed: ", data)
        toastMessage('warning','Oops!','Something wrong, try again.')
    })
}
export default function Delete(item){
    Confirm('delete',()=>{doDelete(item)})
    return 1
}