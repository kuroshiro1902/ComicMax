let results = []
let filters = []
const mainInput = $(".main-input")
class Filter{
    constructor(input){
        this.input = input
        this.value = input.value
        this.param = input.getAttribute("data-param")
        this.tag = createComponent('div',"filter-tag",null,this.value)
        this.closeTag = createComponent('div',"filter-tag__close",null,"x")
        this.closeTag.title = "Delete filter"
        this.tag.append(this.closeTag)
        this.input.onchange = (e)=>{
            if(!e.target.checked){
                this.remove()
            }
            else{
                this.active()
            }
        }
        this.closeTag.onclick = ()=>{
            this.remove()
            this.input.checked = false
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
function starGenerate(star){
    star = Math.round(star)
    let starHTML = ""
    for(let i=0;i<star;i++){
        starHTML+='<i></i>'
    }
    for(let i=star;i<5;i++){
        starHTML+='<u></u>'
    }
    return starHTML
}
function productRender(url){
    const apiURL = url.replace(".jsp", "api")
    window.history.replaceState({}, {}, url);
    $(".result .product-container").innerHTML = `<img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif?20151024034921" alt="loading">`
    fetch(apiURL)
        .then(res => res.json())
        .then(datas => {
            results = [...datas]
            if (datas.length === 0) {
                $(".result .product-container").innerHTML = `<p style="grid-column: 1 / span 6; text-align: center">No product matches. Search for another product.</p>`
            } else {
                let result = ""
                Array.from(datas).forEach((data) => {
                    let elem = createComponent('div', 'product', null,
                            `<a href="product?pid=${data.id}" class="product-img">
                        <img src="${data.img}" alt="${data.name}">
                    </a>
                    <div class="product-text">
                        <a href="product?pid=${data.id} " class="product-title">${data.name}</a>
                        <p class="product-price"><b>$</b>${data.price}</p>
                        <p class="rating" title="${data.star} out of 5">
                            ${starGenerate(data.star)}
                            <span>(${data.sold})</span>
                        </p>
                    </div>`
                            )
                    elem.title = data.name
                    result += elem.outerHTML
                })
                $(".result .product-container").innerHTML = result
            }
        })

}

window.addEventListener("DOMContentLoaded", function() {
    $(".filter-input").forEach((filterInput)=>{
        const filter = new Filter(filterInput)
    })
});
window.onload = function(){
    mainInput.value = new URLSearchParams(window.location.search).get("search")
    $(".result .product-container").innerHTML = `<img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif?20151024034921" alt="loading">`
    productRender(window.location.href)
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
    //
    searchParam = new URLSearchParams(window.location.search)
    searchParam.set('search',mainInput.value)
    productRender(window.location.pathname+'?'+searchParam.toString())
}
//$("input[name='category']").forEach((input)=>{
//})