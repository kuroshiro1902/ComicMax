export default function convertSingleToArray(element){
   if (!Array.isArray(element)) return [element]
   return element
}