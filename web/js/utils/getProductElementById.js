export default function getProductElementById(id,element){
        const Element =  $(`.item[data-pid='${id}']`)
    return {element: Element,
        id: id,
        img: Element.children[1].children[0].href,
        title: Element.children[2].title,
        price: Element.children[3].children[0].innerText.substring(1),
        amount: Element.children[4].children[0].innerText,
        setImg(url){
            Element.children[1].children[0].setAttribute("href",url.trim())
        },
        setTitle(title){
            Element.children[2].setAttribute("title",title.trim())
            Element.children[2].children[0].innerText = title.trim()
        },
        setPrice(price){
            Element.children[3].children[0].innerText = `$${price}`
        },
        setAmount(amount){
            Element.children[4].children[0].innerText = amount
        }
    }
}