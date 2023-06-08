export default async function getMonthData(){
    const response = await fetch("./monthdataapi")
    const data = await response.json()
    return data;
}