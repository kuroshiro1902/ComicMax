function totalCalculate(){
    $(".js-total-cart").innerText = Math.round($(".item").reduce((total,item)=>
        item.children[0].firstElementChild.checked? total + Number(item.children[5].innerText.substring(1)) : total
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
        totalCalculate()
    })
    .catch((data)=>{
        console.log("Delete failed: ", data)
    })
}
export default function Delete(item){
    Confirm('delete',()=>{doDelete(item)})
    return 1
}