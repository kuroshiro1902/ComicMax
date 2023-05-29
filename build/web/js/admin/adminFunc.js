import getProductElementById from "../utils/getProductElementById.js"

const editContainer = $("#edit-container")
const editId = $("#edit-id")
const editImg = $("#edit-img")
const editTitle = $("#edit-title")
const editPrice = $("#edit-price")
const editAmount = $("#edit-amount")
//

function showEdit(e){
    const productElement = e.target.parentElement.parentElement
    const product = getProductElementById(productElement.getAttribute("data-pid"))
    editId.setAttribute("value",product.id)
    editImg.value = product.img
    editTitle.value = product.title
    editPrice.value = product.price
    editAmount.value = product.amount
    editContainer.style.display = "flex";
}
function hideEdit(){
    editContainer.style.display = "none"
}

function reRenderProductByid(id){
    const productItem = $(`.item[data-pid=${id}]`)
}

function submitEditProduct () {
    const data = {id: editId.value.trim(),
            name: editTitle.value.trim(),
            img: editImg.value.trim(),
            price: editPrice.value.trim(),
            amount: editAmount.value.trim()}
        console.log(data)
    fetch('./editproductapi',{
        method: 'POST',
        body: JSON.stringify(data)
    })
        .then(res=>res.json())
        .then(data=> {
            console.log(data)
            toastMessage("confirm", "Done", "Update product complete!")
            const product = getProductElementById(data.id)
            product.setImg(data.img)
            product.setTitle(data.name)
            product.setPrice(data.price)
            product.setAmount(data.amount)
        })
        .catch(error => {
            console.log(error)
            toastMessage("warning", "Error", "Something wrong. Try again!")
        })
}
function submitDeleteProduct(productElement){
    console.log(productElement)
    fetch('./editproductapi',{
        method: 'DELETE',
        body: JSON.stringify(+productElement.id)
    })
        .then(res=>res.json())
        .then(data=> {
            console.log(data)
            toastMessage("confirm", "Done", "Delete product complete!")
            productElement.element.remove()
        })
        .catch(error => {
            console.log(error)
            toastMessage("warning", "Error", "Something wrong. Try again!")
        })
}
function deleteProduct(productElement){
    Confirm("delete",
    (e)=>{submitDeleteProduct(productElement)},
    `Do you want to delete ${productElement.title}?`)
}
export default {showEdit, hideEdit,submitEditProduct, deleteProduct}