
try{
//selected ui
const selectedValue = $(".js-menu").getAttribute("data-selected")
const selected = $(`.option[value=${selectedValue}]`)
selected.classList.add("selected")
selected.disabled = true
//page index ui
const selectedIndex = $(".js-page-index").getAttribute("data-page-index")
const currentIndexBtn = $(`.js-page-index button`)[selectedIndex-1]
currentIndexBtn.classList.add("selected")
currentIndexBtn.disabled = true
//
}catch(e){}


