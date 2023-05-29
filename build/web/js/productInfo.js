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
window.addEventListener("DOMContentLoaded", () => {
  fetch(window.location.href.split("?").join("api?"))
        .then(res=>res.json())
        .then(data=>{
            //id (for adding to wishlist)
            $("#product").setAttribute('data-id',data.id)
            //title
            $(".main-product-title").forEach((titleField)=>{
                titleField.innerText = data.name
            })
            //author
            $(".main-product-author").href+=data.author_id
            $(".main-product-author").innerText = data.author.name
            //publisher
            $(".main-product-publisher").href+=data.publisher_id
            $(".main-product-publisher").innerText = data.publisher.name
            //language
            $(".main-product-language a").innerText = data.language
            //category
            $(".main-product-category").innerHTML = categoryGenerate(data.categories)
            //sold
            $(".main-product-sold a").innerText = data.sold
            //rating
            $(".main-product-rating").outerHTML = `<p class="rating js-rating" title="${data.star} out of 5">
                                ${starGenerate(data.star)}
                                <span style="flex-grow: 1">${data.ratingnums} rated</span>
                            </p>`
            //price
            $(".main-product-price").innerText = "$ "+data.price
            //img
            $(".main-product-img").src = data.img
        })
});