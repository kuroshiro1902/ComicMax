import cartFunc from "./cartFunc.js"
console.log(cartFunc)
$(".js-select").forEach(selectBtn=>{
    selectBtn.onclick = cartFunc.totalCalculate
})
$(".js-select-all").forEach(selectAllBtn=>{
    selectAllBtn.onchange = cartFunc.selectAll
})
$(".js-delete-all").onclick = function(){Confirm('delete')}
$(".js-amount").forEach(input=>{
    input.oninput = cartFunc.onInput
    input.onblur = cartFunc.onFocusout

})
$(".js-add").forEach(addBtn=>{
    addBtn.onclick = cartFunc.add
})    
$(".js-minus").forEach(minusBtn=>{
    minusBtn.onclick = cartFunc.minus
})
$(".js-select-all").forEach(selectAllBtn=>{
    selectAllBtn.onclick = cartFunc.totalCalculate
})
//Items.forEach(i=>{
//    i.checkbox.onchange = (e)=>{
//        $(".total:last-child").innerText = Items.reduce((total,item)=>{
//            return total + (item.checkbox.checked?item.getTotal():0)
//        },0)
//    }
//})