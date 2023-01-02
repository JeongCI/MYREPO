<%--
/**
  Class Name: line.jsp
  Description: 라이차트
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 12. 15        최초작성 
    
    author eclass 개발팀 :ITSC
    since 2022.11.24
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="CP" value="${pageContext.request.contextPath }"></c:set>
<c:set var="RES" value="/resources" ></c:set>
<c:set var="CP_RES" value="${CP}${RES}" ></c:set>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
          let method  ="GET";
          let url     ="/chart/drawLineChart.do";
          let async   =true;
          let params  = {};
          PClass.callAjax(method,url,async,params,function(chartData){
              console.log(chartData);
              
              let parsedJson = JSON.parse(chartData);
              let data = google.visualization.arrayToDataTable(
            		  parsedJson
            	);	
              
              let options = {
                      title: 'Company Performance',
                      curveType: 'function',
                      legend: { position: 'bottom' }
                    };

              let chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

              chart.draw(data, options);              
          });    



      }
    </script>
<meta charset="UTF-8">
<title>제목</title>
<script >
  $(document).ready(function(){
	  console.log("document.ready");
	  
  });
</script>

</head>
<body>
  <!-- div container -->   
  <div class="container">
    <!-- 제목 -->
    <div class="page-header">
       <h2>구글 라인차트</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    
    <!--Div that will hold the pie chart-->
    <div id="curve_chart"></div>
  </div>   
  <!-- div container ---------------------------------------------------------->
     
     
          
</body>
</html>