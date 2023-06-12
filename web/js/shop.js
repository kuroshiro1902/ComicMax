import handleURL from "./utils/handleURL.js"
import fetchData from "./utils/fetchData.js"
import renderProduct from "./utils/renderProducts.js"
import getFilterByParams from "./utils/getFilterByParams.js"
import setFilterParams from "./utils/setFilterParams.js"
import deleteFilterParams from "./utils/deleteFilterParams.js"
import getOrderByParam from "./utils/getOrderByParam.js"
import setOrderParam from "./utils/setOrderParam.js"
import addPageIndexButtonsClickEvent from "./utils/addPageIndexButtonsClickEvent.js"
import findFilterTags from "./utils/findFilterTags.js"
let filters = []
const mainInput = $(".main-input")
export class Filter{
    constructor(input){
        this.input = input
        this.label = input.labels[0]
        this.value = input.value
        this.displayValue = input.getAttribute("data-value")
        this.tag = createComponent('div',"filter-tag",null,this.displayValue)
        this.closeTag = createComponent('div',"filter-tag__close",null,"x")
        this.closeTag.title = "Delete filter"
        this.tag.append(this.closeTag)
        this.input.onchange = (e)=>{
            if(!e.target.checked){
                this.remove()
                productRender((deleteFilterParams({param:this.input.name,value:this.value})))
            }
            else{
                this.active()
                productRender((setFilterParams({param:this.input.name,value:this.value})))
            }
            
        }
        this.closeTag.onclick = ()=>{
            this.remove()
            this.input.checked = false
            productRender((deleteFilterParams({param:this.input.name,value:this.value})))
        }
    }
    active(){
        this.input.checked = true
        $(".result-filter").append(this.tag)
    }
    remove(){
        this.input.checked = false
        this.tag.remove()
    }
}
function productRender(url){
    fetchData(handleURL(url))
        .then(data=>{
            renderProduct(data)
        })
        .catch((err)=>{
            console.log(err)
            renderProduct(null)  
        })
        .finally(()=>{
            createFilter()
            
        })
}
function createFilter(){
    filters = []
    $(".filter-input").forEach((filterInput)=>{
        filters.push(new Filter(filterInput))
    })
    $(".result-filter").innerHTML = ""
    getFilterByParams(filters).forEach(filter=>{filter.active()})
}

window.onload = function(){
    console.log(1)
    mainInput.value = new URLSearchParams(window.location.search).get("search")
    $(".result .product-container").innerHTML = `<img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif?20151024034921" alt="loading">`
    productRender(window.location.href)
    console.log(getOrderByParam())
    $(".js-order").selectedIndex = getOrderByParam()
}
mainInput.onkeypress = function(e) {
  // If the user presses the "Enter" key on the keyboard
  if (e.key === "Enter") {
    // Cancel the default action, if needed
    e.preventDefault();
    // Trigger the button element with a click
    $(".main-input-submit").click();
  }
}
$(".main-input-submit").onclick = function(e){   
    // xoa het filters
    filters.forEach((filter)=>{
        filter.remove()
    })
    //xoa het order
    setOrderParam()
    $(".js-order").selectedIndex = 0
    //reset url
    let url = "http://"+window.location.host+window.location.pathname+"?search="+mainInput.value
    productRender(url.toString())
}
$(".js-order").onchange = function(e){
    setOrderParam(JSON.parse(e.target.value))
    productRender(window.location.href)
}
