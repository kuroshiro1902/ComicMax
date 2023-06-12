
function topBookComponent(data) {
    return `<div class="product" title="` + data.name + `"><a href="product?pid=` + data.id + ` " class="product-img" style="text-align: center">
                    <img src="` + data.img + `" alt="` + data.name + `">
                </a>
                <div class="product-text">
                    <a href="product?pid=` + data.id + `" class="product-title" target="_blank">` + data.name + `</a>
                    <p class="product-price"><b>$</b>` + data.price + `</p>
                    <p class="rating" title="` + data.star + ` out of 5">
                        <i></i><i></i><i></i><i></i><i></i>
                        <span>(` + data.sold + `)</span>
                    </p>
                </div></div>
            `
}
export default async function getTopBookByMonth(month) {
        const response = await fetch(`./topbookbymonthapi?month=`+month)
        const data = await response.json();
        return [topBookComponent(data.topBook), data.amount];
}