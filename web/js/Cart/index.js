import cartFunc from "./cartFunc.js"
import Update from "../CRUD/Update.js"
import Delete from "../CRUD/Delete.js"
$(".js-select").forEach(selectBtn=>{
    selectBtn.onclick = ()=>{
        cartFunc.totalCalculate()
        const selects = $(".js-select")
        if (selects.reduce(
            (total,slctBtn)=> total + (slctBtn.checked ? 1 : 0)
        ,0) === selects.length){
            $(".js-select-all").forEach(selectAllBtn => {
                selectAllBtn.checked = true
            })
        }
        else{
            $(".js-select-all").forEach(selectAllBtn => {
                selectAllBtn.checked = false
            })
        }
    }
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
    addBtn.addEventListener('click',()=>{
        Update(addBtn.parentElement.parentElement)
    })
})    
$(".js-minus").forEach(minusBtn=>{
    minusBtn.onclick = cartFunc.minus
    minusBtn.addEventListener('click',()=>{
        Update(minusBtn.parentElement.parentElement)
    })
})
$(".js-select-all").forEach(selectAllBtn=>{
    selectAllBtn.onclick = cartFunc.totalCalculate
})
$(".js-delete").forEach(deleteBtn=>{
    deleteBtn.onclick = ()=>{Delete(deleteBtn.parentElement)}
})