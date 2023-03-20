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
export default function productGetter(){
    fetch("./shop")
        .then(res=>res.json())
        .then(datas=>{
            const resultContainer = $(".result .product-container")
            datas.forEach((data)=>{
                let elem = createComponent('div','product',null,
                        `<a href="product?pid=${data.id}" class="product-img">
                            <img src="${data.img}" alt="${data.name}">
                        </a>
                        <div class="product-text">
                            <a href="product?pid=${data.id} " class="product-title">${data.name}</a>
                            <p class="product-price"><b>$</b>${data.price}</p>
                            <p class="rating" title="${data.star} out of 5">
                                ${starGenerate(data.star)}
                                <span>(${data.ratingnums})</span>
                            </p>
                        </div>`
                    )
                    elem.title=data.name
                resultContainer.append(elem)
            })
        })
}
