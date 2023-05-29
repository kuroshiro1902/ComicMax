export default function setOrderParam(orderObj){
    const {orderby, order} = {...orderObj}
    const url = new URL(window.location.href)
    url.searchParams.delete("price_order")
    url.searchParams.delete("id_order")
    if(orderby) url.searchParams.set(orderby,order)
    window.history.replaceState({}, {}, url.toString());
    return url.toString()
}