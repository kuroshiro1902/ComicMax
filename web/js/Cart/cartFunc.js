import Delete from "../CRUD/Delete.js"
const selectBtns = $(".js-select").concat($(".js-select-all"))
function selectAll(e){
    const E = e.target
    if(E.checked){ 
        selectBtns.forEach(selectBtn=>{
            selectBtn.checked = true
            $(".option.select-all-btn").innerText="Deselect all"
        })
    }
    else{
        selectBtns.forEach(selectBtn=>{
            selectBtn.checked = false
            $(".option.select-all-btn").innerText="Select all"
        })
    }
    totalCalculate()
}
function updateTotalItem(E){
    //E: .item
    let amount = parseInt(E.getElementsByClassName("amount")[0].getElementsByTagName("input")[0].value)
    const price = parseFloat(E.getElementsByClassName("price")[0].innerText.substring(1))
    if(!amount || amount<0) amount = 0
    if(amount > 100) amount = 100
    E.getElementsByClassName("total")[0].innerText = `$${Math.round(price*amount*100)/100}`
    totalCalculate()
}
function onInput(e){
    //e.target: .js-amount
    const E = e.target
    updateTotalItem(E.parentElement.parentElement)
}
function onFocusout(e){
    const E = e.target
    if(E.value<1) E.value = 1
    else if(E.value>100) E.value = 100  
    updateTotalItem(E.parentElement.parentElement)
}
function add(e){
    //e.target: .js-add
    const E = e.target
    let amount = parseInt(E.previousElementSibling.value)
    amount<100? E.previousElementSibling.value = amount+1 : toastMessage('info','Too much!','100 products is maximum.')
    updateTotalItem(E.parentElement.parentElement)
}
function minus(e){
    //e.target: .js-minus
    const E = e.target
    let amount = parseInt(E.nextElementSibling.value)
    if(!amount) amount = 0
    E.nextElementSibling.value = amount>1? amount-1 : Delete(E.parentElement.parentElement)
    updateTotalItem(E.parentElement.parentElement)
}
function totalCalculate(){
    $(".js-total-cart").innerText = Math.round($(".item").reduce((total,item)=>
        item.children[0].firstElementChild.checked? total + Number(item.children[5].innerText.substring(1)) : total
    ,0)*100)/100
}
export default {
    selectAll,
    onInput,
    onFocusout,
    add,
    minus,
    totalCalculate
}
//js-total-cart