export default function deleteFilterParams(paramObj){
    const {param,value} = {...paramObj}
    const url = new URL(window.location.href)
    const categoryParamValues = new URLSearchParams(url.searchParams).getAll(param);
    const categoryParamsValuesWithOutValue = categoryParamValues.filter((val) => val !== value);
    url.searchParams.delete(param)
    categoryParamsValuesWithOutValue.forEach(val=>{url.searchParams.append(param,val)})
    url.searchParams.delete("page_index")
//    url.searchParams.set('search', params.search)
    window.history.replaceState({}, {}, url.toString());
    return url.toString()
}