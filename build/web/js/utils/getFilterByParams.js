function findInputByNameAndValue({key,value}){
    return  $(`.filter-input[name='${key}'][value='${value}']`)
}
export default function getFilterByParams(filters){
    let inputs = []
    const currentURLSearchParams = new URLSearchParams((new URL(window.location.href).searchParams))
    for( let [key,value] of currentURLSearchParams.entries()){
        const input = findInputByNameAndValue({key,value})
        input? inputs.push(input):null
    }
    let ans = []
    filters.forEach(filter=>{
        for(let input of inputs){
            
            if(input.value===filter.value && input.getAttribute("data-value") === filter.displayValue){
                ans.push(filter)
                break
            }
        }
    })
    return ans
}
