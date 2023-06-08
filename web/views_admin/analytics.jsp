<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<jsp:useBean id="loadBook" class="dao.BookDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadCategory" class="dao.CategoryDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadAuthor" class="dao.AuthorDAO" scope="request"></jsp:useBean>
<jsp:useBean id="loadPublisher" class="dao.PublisherDAO" scope="request"></jsp:useBean>
<div style="padding: 4px">
    <div class="row">
        <div class="card">
            <div class="label">Users:</div>
            <div id="countAccount" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Users:</div>
            <div id="" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Users:</div>
            <div id="" class="value">Loading...</div>  
        </div>
        <div class="card">
            <div class="label">Users:</div>
            <div id="" class="value">Loading...</div>  
        </div>
    </div>
    <div class="bookChart" >
        <div>
            <canvas id="doneDeliveryItemChart" class="card"></canvas>

        </div>
        <div style="width:290px">
            <p>Number of books sold in <strong id="dataTooltip" style="font-weight: bold">Month</strong></p>
            <p>Best Seller Book in <strong id="month" style="font-weight: bold">Month</strong></p>
            <div id="topBook" class="product-container"></div>

        </div>
    </div>
    <script src="./js/index.js"></script>
    <script type="module">
        import {getTopBookByMonth, getMonthData, drawChart, getCountAccount} from "./js/admin/api/index.js"
        //Ve canvas
        window.onload = () => {
            getMonthData()
                    .then(data => {
                        drawChart(data);
                    })
                    .catch(err => {
                        console.log(err)
                        toastMessage('warning', 'Error', 'Cannot get Month datas')
                    })
            getCountAccount()
                    .then(data=>{
                        $("#countAccount").innerHTML = data.countAccount
                    })
        }
        //Xu ly su kien hover vao canvas => hien ra quyen sach ban chay nhat cua thang do
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
        $("#doneDeliveryItemChart").addEventListener('mousemove',function () {
            if (showData.innerHTML !== '') {
                const currentData = showData.innerHTML
                if (currentData !== lastData) {
                    lastData = currentData
                    $("#month").innerHTML = currentData.substring(0, 3)
                    getTopBookByMonth(getMonthIndex(currentData))
                    .then(topBook=>{
                        $("#topBook").innerHTML = topBook
                    })
                    .catch(err=>{toastMessage('warning', 'Error!', 'Get Data FAIL!')})
                }
            }
        })
        
    </script>
</div>