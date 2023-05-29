const publisherFilterContainer = $("#publisher-filters")
const authorFilterContainer = $("#author-filters")
export default function generateFilters(list, type) {
    const filteredObjs = list.filter((obj, index, self) =>
        index === self.findIndex((b) => b.id === obj.id)
    )
    const uniqueObjs = filteredObjs.reduce((ans, obj) => {
        if (!ans.some((o) => o.id === obj.id)) {
            ans.push(obj);
        }
        return ans;
    }, []);
    if(type==='publisher'){
        publisherFilterContainer.innerHTML = uniqueObjs.reduce((htmlStr,obj,index)=>{
            return htmlStr+`
            <div>
                <input type="checkbox" id="publisher${index}" name="publisher" data-value="${obj.name}" class="filter-input" value="${obj.id}">
                <label for="publisher${index}" class="red-hover">${obj.name}</label>
            </div>
            `      
        },"")
    }
    else if(type==='author'){
        authorFilterContainer.innerHTML = uniqueObjs.reduce((htmlStr,obj,index)=>{
            return htmlStr+`
            <div>
                <input type="checkbox" id="author${index}" name="author" data-value="${obj.name}" class="filter-input" value="${obj.id}">
                <label for="author${index}" class="red-hover">${obj.name}</label>
            </div>
            `      
        },"")
    }
}

