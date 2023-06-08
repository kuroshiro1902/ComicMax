import adminFunc from "./adminFunc.js"
const addBtn = $("#add-book")
addBtn.onclick = adminFunc.addProduct
console.log(adminFunc.addProduct)