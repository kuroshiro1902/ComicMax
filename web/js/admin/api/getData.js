export default async function (urlSlug){
        const response = await fetch("./"+urlSlug)
        const data = await response.json()
        return data
}