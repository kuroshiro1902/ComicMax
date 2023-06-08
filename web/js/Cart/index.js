import cartFunc from "./cartFunc.js"
import Update from "../CRUD/Update.js"
import Delete from "../CRUD/Delete.js"
import convertSingleToArray from "../utils/convertSingleToArray.js"
//select product btns
let selectProductBtns = convertSingleToArray($(".js-select"))   
//
selectProductBtns.forEach(selectBtn=>{
    selectBtn.onclick = ()=>{
        cartFunc.totalCalculate()
        const selects = selectProductBtns
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
convertSingleToArray($(".js-amount")).forEach(input=>{
    input.oninput = cartFunc.onInput
    input.onblur = cartFunc.onFocusout

})
convertSingleToArray($(".js-add")).forEach(addBtn=>{
    addBtn.onclick = cartFunc.add
    addBtn.addEventListener('click',()=>{
        Update(addBtn.parentElement.parentElement)
    })
})    
convertSingleToArray($(".js-minus")).forEach(minusBtn=>{
    minusBtn.onclick = cartFunc.minus
    minusBtn.addEventListener('click',()=>{
        Update(minusBtn.parentElement.parentElement)
    })
})
$(".js-select-all").forEach(selectAllBtn=>{
    selectAllBtn.onclick = cartFunc.totalCalculate
})
convertSingleToArray($(".js-delete")).forEach(deleteBtn=>{
    deleteBtn.onclick = ()=>{Delete(deleteBtn.parentElement)}
})
$("#buy").onclick = cartFunc.buy