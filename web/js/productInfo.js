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
    for(let i=0;i<n;i++){
        categoryHTML[i] = `<a href="shop.jsp?category=${categories[i].id}" class="click">${categories[i].name}</a>`
    }
    
    return "Category: " + categoryHTML.join(", ")
}
function ProductCard({id, name, img, price}){
    return `<div class="product" title="${name}">
                <a href="./product?pid=${id}" class="product-img">
                    <img src="${img}" alt="${name}">
                </a>
                <div class="product-text">
                    <a href="./product?pid=${id}" class="product-title">${name}</a>
                    <p class="product-price"><b>$</b>${price}</p>
                    <p id="star${id}" class="rating">
                    </p>
                </div>
            </div>`
}
window.addEventListener("DOMContentLoaded", () => {
  fetch(window.location.href.split("?").join("api?"))
        .then(res=>res.json())
        .then(data=>{
            
            console.log(data)
            const {book,relatedBooks} = data
            
            //book
            //id (for adding to wishlist)
            $("#product").setAttribute('data-id',book.id)
            //title
            $(".main-product-title").forEach((titleField)=>{
                titleField.innerText = book.name
            })
            //author
            $(".main-product-author").href+=book.author_id
            $(".main-product-author").innerText = book.author.name
            //publisher
            $(".main-product-publisher").href+=book.publisher_id
            $(".main-product-publisher").innerText = book.publisher.name
            //language
            $(".main-product-language a").innerText = book.language
            //category
            $(".main-product-category").innerHTML = categoryGenerate(book.categories)
            //sold
            $(".main-product-sold a").innerText = book.sold
            //rating
            $(".main-product-rating").outerHTML = `<p class="rating js-rating" title="${book.star} out of 5">
                                ${starGenerate(book.star)}
                                <span style="flex-grow: 1">${book.ratingnums} rated</span>
                            </p>`
            //price
            $(".main-product-price").innerText = "$ "+book.price
            //img
            $(".main-product-img").forEach(img=>{img.src = book.img})
            
            //related book
            let relatedBooksHTML = relatedBooks.reduce((html,book)=>{
                return html+ProductCard(book)
            }, "")
            $("#relate-product-container").innerHTML = relatedBooksHTML
            //rating
            relatedBooks.forEach((book)=>{
                $(`#star${book.id}`).outerHTML = `<p class="rating js-rating" title="${book.star} out of 5">
                                ${starGenerate(book.star)}
                                <span style="flex-grow: 1">${book.sold} sold</span>
                            </p>`
            })
            
        })
});