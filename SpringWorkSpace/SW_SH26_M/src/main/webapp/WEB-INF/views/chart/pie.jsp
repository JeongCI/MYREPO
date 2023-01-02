<%--
/**
  Class Name: pie.jsp
  Description: 파이차크
  
  Modification information
  
    수정일     수정자      수정내용
  -----   -----  -------------------------------------------
    2022. 11. 28        최초작성 
    
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

  <!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {
    	    let method  ="GET";
    	    let url     ="/chart/drawMemberPieChart.do";
    	    let async   =true;
    	    let params  = {};
    	      
    	    PClass.callAjax(method,url,async,params,function(chartData){
    	    	console.log(chartData);
    	    	let parsedJson = JSON.parse(chartData);
    	    	
    	    	let data = new google.visualization.DataTable();
    	      data.addColumn('string', '레벨');
    	      data.addColumn('number', '회원수');    	    	
    	      data.addRows(parsedJson);
    	      
   	        // Set chart options
   	        let options = {'title':'레벨별 회원수',
   	                       'width':400,
   	                       'height':300};

   	        // Instantiate and draw our chart, passing in some options.
   	        let chart = new google.visualization.PieChart(document.getElementById('chart_div'));
   	        chart.draw(data, options);    	      
    	    });



      }
    </script>
<meta charset="UTF-8">
<title>브트스트랩_등록</title>
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
       <h2>구글 파이차트</h2>
    </div>
    <!-- 제목 ------------------------------------------------------------------->
    
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </div>   
  <!-- div container ---------------------------------------------------------->
     
     
     
</body>
</html>





















