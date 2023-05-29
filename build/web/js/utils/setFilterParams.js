export default function setFilterParams(paramObj){
    const {param,value} = {...paramObj}
    const url = new URL(window.location.href)
    const categoryParamValues = new URLSearchParams(url.searchParams).getAll(param);
    url.searchParams.append(param,value)
    url.searchParams.delete("page_index")
//    url.searchParams.set('search', params.search)
    window.history.replaceState({}, {}, url.toString());
    return url.toString()
}