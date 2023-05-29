import adminFunc from "./adminFunc.js"
import getProductElementById from "../utils/getProductElementById.js"
const editField = $(".edit-field")
const editCancelBtns = [$("#edit-cancel"),$("#edit-container")]
const editConfirm = $("#edit-confirm")
const showEditBtns = $(".admin .js-show")
const deleteProductBtns = $(".admin .js-delete")

editField.onclick = (e)=>{e.stopPropagation()}
editCancelBtns.forEach(btn=>{
    btn.onclick = adminFunc.hideEdit
})
showEditBtns.forEach(btn=>{
    btn.onclick = adminFunc.showEdit
})
deleteProductBtns.forEach(btn=>{
    btn.onclick = (e)=>{adminFunc.deleteProduct(getProductElementById(e.target.parentElement.parentElement.getAttribute("data-pid")))}
})
editConfirm.onclick = adminFunc.submitEditProduct
editConfirm.addEventListener("click",adminFunc.hideEdit)