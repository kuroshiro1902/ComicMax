export default function drawPieChart(data) {
  const canvas = $('#PieChart');
  const ctx = canvas.getContext('2d');
  
  const total = data.reduce((sum, item) => sum + item.data, 0);
  
  let startAngle = 0;
  
  data.forEach((item, index) => {
    const sliceAngle = (item.data / total) * 2 * Math.PI;
    
    ctx.beginPath();
    ctx.moveTo(canvas.width / 2, canvas.height / 2);
    ctx.arc(canvas.width / 2, canvas.height / 2, canvas.height / 2, startAngle, startAngle + sliceAngle);
    ctx.fillStyle = colors[index];
    ctx.fill();
    ctx.closePath();
    
    startAngle += sliceAngle;
    
    $("#note"+(index+1)).title = item.label+": "+Math.round((item.data/total) * 10000) / 100 +"%"
    $("#textnote"+(index+1)).innerHTML = item.label
  });
}

const colors = [ "#FCCC1A","#FEFE33", "#B2D732", "#66B032", "#347C98","#0247FE", "#4424D6","#8601AF", "#C21460", "#FE2712", "#FC600A", "#FB9902"]
$(".note").forEach((note,index)=>{
    note.parentNode.style.color = colors[index]
    note.style.backgroundColor = colors[index]
})
