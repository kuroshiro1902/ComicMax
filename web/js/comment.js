import convertSingleToArray from "../js/utils/convertSingleToArray.js"
const ratingState = $("#ratingState")
const ratingStates ={
    1: `<p class="rating-state" style="color: var(--warning)"> Bad!! <i class="fa-solid fa-face-angry"></i> </p>`,
    2: `<p class="rating-state" style="color: var(--warning)"> Not Good! <i class="fa-solid fa-face-frown"></i> </p>`,
    3: `<p class="rating-state" style="color: var(--info)"> Normal <i class="fa-solid fa-face-meh"></i> </p>`,
    4: `<p class="rating-state" style="color: var(--confirm)"> Good! <i class="fa-solid fa-face-smile"></i> </p>`,
    5: `<p class="rating-state" style="color: var(--confirm)"> Awesome!!! <i class="fa-solid fa-face-smile-beam"></i> </p>`        
}
const star_grayImg = "./img/star_gray.svg"
const star_yellowImg = "./img/star_yellow.svg"
const inputs = convertSingleToArray($("#rating input"))
const labels = []
inputs.forEach(input=>{
    try{
        labels.push(input.parentNode)
    
    input.onchange = (e)=>{
        if(input.checked){
            const value = input.value
            ratingState.innerHTML = ratingStates[value]
            for(let i=0;i<value;i++) labels[i].style.backgroundImage = `url("${star_yellowImg}")`
            for(let i=value;i<labels.length;i++) labels[i].style.backgroundImage = `url("${star_grayImg}")`
        }
    }
    }catch(e){}
})
function Textarea(text){
    const e = document.createElement('textarea')
    e.rows = "3";
    e.className = "text-area"
    e.placeholder = "Edit comment"
    e.name = "content"
    e.title = "Edit comment"
    e.required = true
    e.value = text
    return e
}
function backup(id){
    const buttonsHTML = `<button type="button" data-id="${id}" onclick="editComment(this)" style="color: teal"> Edit </button> | <button type="button" data-id="${id}" style="color: #6f6f6f"> Delete </button>`
    return [$(`#comment${id}`).innerText, buttonsHTML]
}
function btnsHTML(id){
    return `<button type="submit" style="color: teal"> Submit </button> | 
            <button type="button" style="color: #6f6f6f" data-id="cancelbtn${id}"> Cancel </button>`
}

function editComment(btn){
    const id = btn.getAttribute('data-id')
    const comment = $(`#comment${id}`)
    //backup
    const [backupComment, backupButtons] = backup(id)
    // change Content
    const text = comment.innerText
    comment.innerText=""
    const textarea = Textarea(text)
    comment.appendChild(textarea)
    textarea.focus()
    $(`#btns${id}`).innerHTML = btnsHTML(id)
    //addEventListener for cancel button
    $(`button[data-id="cancelbtn${id}"]`).onclick = ()=>{
        $(`#comment${id}`).innerText = backupComment
        $(`#btns${id}`).innerHTML = backupButtons
    }
}
function deleteComment(id){
    const searchParams = new URLSearchParams((new URL(window.location.href).searchParams))
    const pid = searchParams.get('pid');
    Confirm('deleteComment',()=>{window.location.href = `./comment?method=delete&book_id=${pid}&id=${id}`})
}