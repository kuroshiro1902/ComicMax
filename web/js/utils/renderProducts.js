import generatePageIndexButtons from "./generatePageIndexButtons.js"
import addPageIndexButtonsClickEvent from "./addPageIndexButtonsClickEvent.js"
import generateFilters from "./generateFilters.js"
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
function categoryGenerate(categories){
    let categoryHTML = []
    let n = categories.length
    for(let i=0;i<n-1;i++){
        categoryHTML[i] = `<a href="shop?cid=${categories[i].id}" class="click">${categories[i].name}</a>`
    }
    
    return "Category: " + categoryHTML.join(", ")
}
export default function renderProducts(data={count:1,currentPageIndex:"1",list:[]},container=$(".result .product-container")){
    const {count,currentPageIndex,list} = {...data}
    container.innerHTML = `<img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif?20151024034921" alt="loading">`
    if(count>0){
        if(list.length < 0)
        {
            container.innerHTML = `<p style="grid-column: 1 / -1; text-align: center">No product matches. Search for another product.</p>`
        }
        else{
            let productsHTML = ""
            Array.from(list).forEach((product) => {
                let productElement = createComponent('div', 'product', null,
                        `<a href="product?pid=${product.id}" class="product-img">
                    <img src="${product.img}" alt="${product.name}">
                </a>
                <div class="product-text">
                    <a href="product?pid=${product.id} " class="product-title">${product.name}</a>
                    <p class="product-price"><b>$</b>${product.price}</p>
                    <p class="rating" title="${product.star} out of 5">
                        ${starGenerate(product.star)}
                        <span>(${product.sold})</span>
                    </p>
                </div>`
                        )
                productElement.title = product.name
                productsHTML += productElement.outerHTML
            })
            const pagingHTML = `<div class="pages" style="grid-column:1/-1" data-page-index="${currentPageIndex}">${generatePageIndexButtons(count,currentPageIndex)}</div>`
            container.innerHTML = productsHTML + pagingHTML
            
        }
        const pageIndexButtons = []
        try{
            pageIndexButtons.push(...$(".pages button[name='page_index']"))
        }catch(e){
        }
        generateFilters(data.list.map(book=>book.publisher),"publisher")
        generateFilters(data.list.map(book=>book.author),"author")
        addPageIndexButtonsClickEvent(pageIndexButtons)
    }
    else{
        container.innerHTML = `<p style="grid-column: 1 / -1; text-align: center">No product matches. Search for another product.</p>`
    }
}