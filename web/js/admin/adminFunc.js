const editContainer = $("#edit-container")
//

//
function showEdit(e){
    console.log(e.target.parentElement.parentElement)
    editContainer.style.display = "flex";
}
function hideEdit(){
    editContainer.style.display = "none"
}
export default {showEdit, hideEdit}