<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>spring-mvc</title>
<script type="text/javascript" src="${ctxPath }/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${ctxPath }/js/echarts.js"></script>
<script type="text/javascript" src="${ctxPath }/js/echarts-gl.js"></script>
<script type="text/javascript" src="${ctxPath }/js/bar/demo-bar.js"></script>
<script type="text/javascript" src="${ctxPath }/js/bar/demo-bar-gradient.js"></script>
<script type="text/javascript" src="${ctxPath }/js/pie/demo-pie.js"></script>
<script type="text/javascript" src="${ctxPath }/js/pie/demo-pie-nest.js"></script>
<script type="text/javascript" src="${ctxPath }/js/dispatch/dispatch.js"></script>
<script type="text/javascript" src="${ctxPath }/js/3D/demo-3D.js"></script>
<script type="text/javascript" src="${ctxPath }/js/bar/demo-bar2.js"></script>
</head>
<body>
<!-- 	柱状图示例 -->
	<div id="main" style="width: 600px;height:400px;"></div>
<!-- 	柱状缩放例 -->
	<div id="gardient" style="width: 600px;height:400px;"></div>
<!-- 	饼图示例 -->
	<div id="pieChart" style="width: 600px;height:400px;"></div>
<!-- 	拖拽示例 -->
	<div id="dispatch" style="width: 600px;height:400px;"></div>
<!-- 	3D图示例 -->
	<div id="3D" style="width: 800px;height:500px;"></div>
<!-- 	嵌套环形图 -->
	<div id="pie-nest" style="width: 800px;height:500px;"></div>
<!-- 	产品交易量 -->
	<div id="prdTrade" style="width: 70%;height:500px;"></div>	
</body>
</html>