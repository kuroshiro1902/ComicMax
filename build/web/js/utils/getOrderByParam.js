const selectedIndex = [
    {},
    {"orderby": "price_order", "order": "ASC"},
    {"orderby": "price_order", "order": "DESC"},
    {"orderby": "id_order", "order": "DESC"},
    {"orderby": "id_order", "order": "ASC"}
]
export default function getOrderByParam(){
        const currentURLSearchParams = new URLSearchParams((new URL(window.location.href).searchParams))
        const id_order = currentURLSearchParams.get("id_order")
        const price_order = currentURLSearchParams.get("price_order")
        if(price_order){
            if(price_order === selectedIndex[1].order) return 1
            else return 2
        }
        else if (id_order){
            if(id_order === selectedIndex[3].order) return 3
            else return 4
        }
        else{
            return 0
        }
}