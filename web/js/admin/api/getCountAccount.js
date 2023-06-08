export default async function (){
        const response = await fetch("./userdataapi")
        const data = await response.json()
        return data
}