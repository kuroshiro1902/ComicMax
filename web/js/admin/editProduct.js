import adminFunc from "./adminFunc.js"
const editField = $(".edit-field")
const editCancelBtns = [$("#edit-cancel"),$("#edit-container")]
const showEditBtns = $(".admin .js-show")
const deleteProductBtns = $(".admin .js-delete")

editField.onclick = (e)=>{e.stopPropagation()}
editCancelBtns.forEach(btn=>{
    btn.onclick = adminFunc.hideEdit
})
showEditBtns.forEach(btn=>{
    btn.onclick = adminFunc.showEdit
})
