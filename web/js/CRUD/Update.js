export default function Update(item){
    const updateData = {
        pid: item.getAttribute('data-pid'),
        amount: item.children[4].children[1].value
    }
    fetch(window.location.href.split(".jsp").join("api"),{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(updateData),
    })
    .then(res=>res.json())
    .then((data)=>{
        console.log("update success: ", data)
    })
    .catch((data)=>{
        console.log("update failed: ", data)
    })
}