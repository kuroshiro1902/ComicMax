class Filter{
    constructor(input){
        this.input = input
        this.value = input.value
        this.tag = createComponent('div',"filter-tag",null,this.value)
        this.closeTag = createComponent('div',"filter-tag__close",null,"x")
        this.closeTag.title = "Delete filter"
        this.tag.append(this.closeTag)
        this.closeTag.onclick = ()=>{
            this.hide()
            this.input.checked = false
        }
    }
    show(parent){
        parent.append(this.tag)
    }
    hide(){
        this.tag.remove()
    }
}
window.onload = function(){
    resultFilter = $(".result-filter")
    $(".filter-input").forEach((filterInput)=>{
        const filter = new Filter(filterInput)
        filter.input.addEventListener('change',(e)=>{
            if(!e.target.checked){
                filter.hide()
            }
            else{
                filter.show(resultFilter)
            }
        })
    })
}
