export default async function fetchData(url){
    try {
        const response = await fetch(url.toString().replace(".jsp","api"));
        const data = await response.json();
        return data;
    }
    catch (error) {
        const data = {count:1,currentPageIndex:1,list:[]}
        return data;
    }
}