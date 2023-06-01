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
    //comment?method=delete
    Confirm('deleteComment',()=>{window.location.href = `./comment?method=delete&id=${id}`})
}