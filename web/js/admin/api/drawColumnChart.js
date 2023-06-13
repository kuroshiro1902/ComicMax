var css = {
    container: '#doneDeliveryItemChart',
    width: 800,
    height: 380,
    backgroundColor: '#fff',
    padding: 30,
    columnColor: '#d93f44',
    columnSpacing: 5,
    axisColor: '#999999',
    axisWidth: 2,
    axisLabelColor: 'black',
    axisLabelPadding: 10,
    yAxisTickCount: 6
};
const tooltip = $('#dataTooltip');
const canvas = $("#ColumnChart")
const ctx = canvas.getContext('2d');
// Thiết lập kích thước canvas
canvas.width = css.width;
canvas.height = css.height;
//Tạo màu tuyến tính
//var gradient = ctx.createLinearGradient(0, 0, 0, canvas.height - css.padding * 2);
var gradient = ctx.createLinearGradient(0, 0, 0, canvas.height - css.padding * 2);
gradient.addColorStop(0, '#e33238'); // Màu bắt đầu của gradient
gradient.addColorStop(1, '#f4a261'); // Màu kết thúc của gradient
// Vẽ nền
ctx.fillStyle = css.backgroundColor;
ctx.fillRect(0, 0, canvas.width, canvas.height);
ctx.font = '11px Arial';
function calculateYAxisLabels(maxValue) {
    var labels = [];
    var interval = Math.ceil(maxValue / 5);
    for (var i = 0; i <= 5; i++) {
        labels.push(interval * i);
    }
    return labels;
}
// Hiển thị tooltip khi hover vào cột
function showDataTooltip(label, data) {
    tooltip? tooltip.innerHTML = label + ': ' + data : null;
}
export default function drawChart(data) {
    // Tính toán thông số vẽ biểu đồ
    var columnWidth = Math.floor((canvas.width - css.padding * 2) / data.length) * 0.8;
    var columnSpacing = (canvas.width - css.padding * 2 - columnWidth * data.length) / (data.length - 1);

    var maxValue = Math.max(...data.map(obj => obj.data));
    var scaleFactor = (canvas.height - css.padding * 2 - css.axisLabelPadding) / maxValue;

    // Vẽ các cột
    for (var i = 0; i < data.length; i++) {
        var columnHeight = data[i].data * scaleFactor;
        var x = css.padding + i * (columnWidth + columnSpacing);
        var y = canvas.height - css.padding - columnHeight;

//      ctx.fillStyle = css.columnColor;
        ctx.fillStyle = gradient;
        ctx.fillRect(x, y, columnWidth - columnSpacing, columnHeight);

        // Ghi chú tháng
    ctx.fillStyle = css.axisLabelColor;
    ctx.textAlign = 'center'; // Căn giữa nhãn với vị trí của cột
//    ctx.fillText(data[i].label, x + columnWidth / 2, canvas.height - css.padding + css.axisLabelPadding);
    ctx.fillText(data[i].label, x + columnWidth/3, canvas.height - css.padding + css.axisLabelPadding);
    }
    // Vẽ trục Ox
    ctx.beginPath();
    ctx.moveTo(css.padding, canvas.height - css.padding);
    ctx.lineTo(canvas.width - css.padding, canvas.height - css.padding);
    ctx.strokeStyle = css.axisColor;
    ctx.lineWidth = css.axisWidth;
    ctx.stroke();

    // Vẽ trục Oy
    ctx.beginPath();
    ctx.moveTo(css.padding, canvas.height - css.padding);
    ctx.lineTo(css.padding, css.padding - css.axisLabelPadding);
    ctx.strokeStyle = css.axisColor;
    ctx.lineWidth = css.axisWidth;
    ctx.stroke();


    // Vẽ mốc dữ liệu trên trục Oy
    ctx.fillStyle = css.axisLabelColor;
    ctx.textAlign = 'right';
    ctx.textBaseline = 'middle';
    var yAxisLabels = calculateYAxisLabels(maxValue, css.yAxisTickCount);
    var yAxisSpacing = (canvas.height - css.padding * 2 - css.axisLabelPadding) / (yAxisLabels.length - 1);
    for (var j = 0; j < yAxisLabels.length; j++) {
        var yLabel = canvas.height - css.padding - j * yAxisSpacing;
        ctx.fillText(yAxisLabels[j], css.padding - css.axisLabelPadding, yLabel);
    }

    canvas.onmousemove = function (event) {
    var rect = canvas.getBoundingClientRect();
    var mouseX = event.clientX - rect.left;
    var mouseY = event.clientY - rect.top;

    for (var i = 0; i < data.length; i++) {
        var x = css.padding + i * (columnWidth + columnSpacing);
        var y = canvas.height - css.padding - data[i].data * scaleFactor;

        if (mouseX >= x && mouseX <= x + columnWidth && mouseY >= y && mouseY <= canvas.height - css.padding) {
            // Hiển thị data của tháng đang hover
            showDataTooltip(data[i].label, data[i].data, mouseX, mouseY);
            return;
        }
    }
}

}