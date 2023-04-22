//class Item{
//    constructor(item){
//        this.id = item.getAttribute("data-pid")
//        this.checkbox = item.children[0].getElementsByTagName('input')[0]
//        this.price = item.children[3]
//        this.amount = item.children[4].getElementsByTagName('input')[0]
//        this.minusBtn = item.children[4].getElementsByClassName("js-minus")[0]
//        this.addBtn = item.children[4].getElementsByClassName("js-add")[0]
//        this.total = item.children[5]
//        this.deleteBtn = item.children[6]
//        this.addEventListener()
//    }
//    addEventListener(){
//        //bind
//        this.add = this.add.bind(this)
//        this.minus = this.minus.bind(this)
//        this.delete = this.delete.bind(this)
//        this.update = this.update.bind(this)
//        //add event listeners
//        this.addBtn.onclick = this.add
//        this.minusBtn.onclick = this.minus
//        this.deleteBtn.onclick = this.delete
//        //
//    }
//    add(){
//        this.amount.value = this.amount.value? parseInt(this.amount.value)+1 : 1
//        this.update()
//    }
//    minus(){
//        this.amount.value = this.amount.value>1? parseInt(this.amount.value)-1 : this.delete()
//        this.update()
//    }
//    delete(){
//        Confirm('delete')
//        return 1
//    }
//    update(){
//        this.setTotal(Math.round(this.amount.value*this.getPrice()*100)/100)
//    }
//    getPrice(){
//        return parseFloat(this.price.innerText.substring(1))
//    }
//    getTotal(){
//        return parseFloat(this.total.innerText.substring(1))
//    }
//    setTotal(x){
//        this.total.innerText = `$${x}`
//    }
//}
//export default $(".item").slice(1,-1).map(item=>new Item(item))