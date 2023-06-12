const canvas = document.getElementById("LineChart");
const graphColor = '#D71920'; // Màu của đồ thị
const areaColor = 'rgba(215, 25, 32, 0.5)'; // Màu của diện tích bao phủ
const textColor = 'black'; // Màu của các con số

// Kích thước của canvas
const canvasWidth = 800;
const canvasHeight = 400;
canvas.width = canvasWidth;
canvas.height = canvasHeight;

// Vẽ các đường thẳng biểu thị cho trục Ox và Oy
const ctx = canvas.getContext('2d');
ctx.strokeStyle = '#999';
ctx.lineWidth = 2;

export default function drawLineChart(data) {
  console.log("doanh thu: ", data);

  // Tìm giá trị tối đa và tối thiểu của dữ liệu để tính toán tỷ lệ vẽ
  const values = data.map(item => item.data);
  const maxValue = Math.max(...values);
  const minValue = Math.min(0, ...values);

  // Tính toán tỷ lệ vẽ trên canvas
  const padding = 50;
  const chartWidth = canvasWidth - padding * 2;
  const chartHeight = canvasHeight - padding * 2;
  const valueRange = maxValue - minValue;
  const xScale = chartWidth / (data.length - 1);
  const yScale = chartHeight / valueRange;

  // Vẽ biểu đồ đường và diện tích bao phủ
  ctx.clearRect(0, 0, canvasWidth, canvasHeight); // Xóa canvas
  ctx.fillStyle = areaColor; // Đặt màu cho diện tích bao phủ
  ctx.beginPath();
  ctx.moveTo(padding, canvasHeight - padding - (data[0].data - minValue) * yScale);
  for (let i = 1; i < data.length; i++) {
    const x = padding + i * xScale;
    const y = canvasHeight - padding - (data[i].data - minValue) * yScale;
    ctx.lineTo(x, y);
  }
  ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
  ctx.lineTo(padding, canvasHeight - padding);
  ctx.closePath();
  ctx.fill();

  // Vẽ đồ thị đường
  ctx.strokeStyle = graphColor;
  ctx.lineWidth = 2;
  ctx.beginPath();
  ctx.moveTo(padding, canvasHeight - padding - (data[0].data - minValue) * yScale);
  for (let i = 1; i < data.length; i++) {
    const x = padding + i * xScale;
    const y = canvasHeight - padding - (data[i].data - minValue) * yScale;
    ctx.lineTo(x, y);
  }
  ctx.stroke();

  // Chú thích các số trên mỗi breakpoint của đồ thị
  ctx.fillStyle = textColor;
  ctx.font = '12px Arial';
  for (let i = 1; i < data.length; i++) {
    const x = padding + i * xScale;
    const y = canvasHeight - padding - (data[i].data - minValue) * yScale - 10;
    ctx.fillText("$" + data[i].data.toString(), x, y);
  }

  // Vẽ đường thẳng cho trục Ox
  ctx.beginPath();
  ctx.moveTo(padding, canvasHeight - padding);
  ctx.lineTo(canvasWidth - padding, canvasHeight - padding);
  ctx.stroke();

  // Vẽ đường thẳng cho trục Oy
  ctx.beginPath();
  ctx.moveTo(padding, canvasHeight - padding);
  ctx.lineTo(padding, padding);
  ctx.stroke();

  // Chú thích các label trên trục Ox
  ctx.fillStyle = 'black';
  ctx.font = '11px Arial';
  data.forEach((item, index) => {
    const x = padding + index * xScale;
    const y = canvasHeight - padding + 20;
    ctx.fillText(item.label, x, y);
  });

  // Chú thích độ lớn dữ liệu trên trục Oy
  ctx.textAlign = 'right';
  ctx.textBaseline = 'middle';
  const yAxisLabels = [data[0].data, maxValue];

  ctx.fillStyle = textColor;
  yAxisLabels.forEach((label) => {
    const y = canvasHeight - padding - (label - minValue) * yScale;
    ctx.fillText(label.toString(), padding - 10, y);
  });
}
