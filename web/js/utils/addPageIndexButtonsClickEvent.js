import handleURL from "./handleURL.js"
import fetchData from "./fetchData.js"
import renderProducts from "./renderProducts.js"
export default function addPageIndexButtonsClickEvent(pageIndexButtons){
    pageIndexButtons.forEach((button)=>{
        button.addEventListener('click',(e)=>{
            const index = e.target.value
            pageIndexButtons.forEach((button)=>{
                if(button.value != index){
                    //neu gia tri cua button khong trung voi pageIndex hien tai
                    button.classList.remove("selected")
                    button.disabled = false
                }
                else{
                    //neu gia tri cua button trung voi pageIndex hien tai
                    button.classList.add("selected")
                    button.disabled = true
                }
            });
            fetchData(handleURL(null,{index}))
            .then(data=>{
                    renderProducts(data)    
            })
            .catch(err=>{
                    renderProducts()   
            })
        })
    })
}