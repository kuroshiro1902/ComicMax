<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadAuthor" class="dao.AuthorDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadPublisher" class="dao.PublisherDAO" scope="request"></jsp:useBean>
<div style="padding: 1rem 2rem">
    <div style="margin-bottom: 6px; padding-bottom: 10px" class="row card-container">
        <div class="card">
            <div class="label">Books</div>
            <div id="countBooks" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Users</div>
            <div id="countAccounts" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Current Month's Sold</div>
            <div id="currentMonthSold" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Current Month's Revenue</div>
            <div id="currentMonthRevenue" class="value">Loading...</div>  
        </div>
    </div>
    <div class="chart-container">
        <h3 class='row' style="color:var(--red);text-transform: uppercase">revenue growth</h3>
        <div class="bookChart" >
            <div class="card">
                <canvas id="LineChart" ></canvas>
            </div>
            <div class="card" style="display: flex; flex-direction: column; justify-content: space-evenly;">
                
                <canvas id="PieChart" ></canvas>
                <div style="display: flex; width: 100%; color: #333; justify-content: space-evenly; padding: 1rem .5rem">
                    
                    <div>
                        <c:forEach begin="1" end="6" var="o">
                            <div><span class="note" id="note${o}"></span> <span id="textnote${o}">${o}</span></div>
                        </c:forEach>
                    </div>
                    <div>
                        <c:forEach begin="7" end="12" var="o">
                            <div><span class="note" id="note${o}"></span> <span id="textnote${o}">${o}</span></div>
                        </c:forEach>
                    </div>
                </div>
                <h3 style="text-align: center; color: #333">Revenue percentage.</h3>
                
            </div>

        </div> 
        <h3 class='row' style="color:var(--red);text-transform: uppercase">Selling books statistics</h3>
        <div class="bookChart" >
            <div>
                <canvas id="ColumnChart" class="card"></canvas>
            </div>
            <div style="width:290px">
                <p>Number of books sold in <strong id="dataTooltip" style="font-weight: bold">Jun</strong></p>
                <p>Best Seller Book in <strong id="month" style="font-weight: bold">Month: </strong> <strong id="bestSellerAmount"></strong></p>
                <div id="topBook" class="product-container"></div>

            </div>
        </div>
    </div>

    <script src="./js/index.js"></script>
    <script type="module">
        import {getTopBookByMonth, getMonthData, drawColumnChart, drawLineChart, getData, drawPieChart} from "./js/admin/api/index.js"
                //Ve canvas
                window.onload = () => {
            async function fetchData() {
                try {
                    const [monthData, data1, data2] = await Promise.all([
                        getMonthData(),
                        getData("dataapi"),
                        getData("revenuedataapi")
                    ]);

                    drawColumnChart(monthData);

                    $("#countBooks").innerHTML = data1.countBooks;
                    $("#countAccounts").innerHTML = data1.countAccounts;
                    $("#currentMonthSold").innerHTML = data1.currentMonthSold;
                    $("#currentMonthRevenue").innerHTML = "$" + data1.currentMonthRevenue;

                    const chartData = data2.map(monthdata => 
                        
                         ({
                            label: monthdata.label,
                            data: monthdata.floatData
                        })
                        
                                );
                    drawLineChart(chartData);
                    drawPieChart(chartData);
                    
                } catch (err) {
                    toastMessage('warning', 'Error', 'Cannot get Month datas');
                }
            }

            fetchData();

        }
        const month = {
            'Jan': 1,
            'Feb': 2,
            'Mar': 3,
            'Apr': 4,
            'May': 5,
            'Jun': 6,
            'Jul': 7,
            'Aug': 8,
            'Sep': 9,
            'Oct': 10,
            'Nov': 11,
            'Dec': 12
        };
        function getMonthIndex(showData = 'Jan') {
            return month[showData.substring(0, 3)]
        }
        let lastData = ''
        const showData = $("#dataTooltip")
        $("#ColumnChart ").addEventListener('mousemove', function () {
            if (showData.innerHTML !== '') {
                const currentData = showData.innerHTML
                if (currentData !== lastData) {
                    lastData = currentData
                    $("#month").innerHTML = currentData.substring(0, 3)
                    getTopBookByMonth(getMonthIndex(currentData))
                            .then(([topBook, amount]) => {
                                $("#topBook").innerHTML = topBook
                                $("#bestSellerAmount").innerHTML = "(" + amount + " sold)"
                            })
                            .catch(err => {
                                toastMessage('confirm', 'Done!', 'Fetch month data done!')
                            })
                }
            }
        })
        //



    </script>
</div>