function pageIndexButton(index=null,currentIndex=null,text=index){
    if(index===null) return `<span>...</span>`
    return index===currentIndex? 
    `<button class="button selected" name="page_index" value="${index}" disabled>${text}</button>`
    : `<button class="button" name="page_index" value="${index}">${text}</button>`
}
export default function generatePageIndexButtons(total, current){
    current = Number(current)
    let ans = []
    for(let i=1;i<=total;i++){
        ans.push(pageIndexButton(i,current))
    }
    return ans.join("\n")
}
