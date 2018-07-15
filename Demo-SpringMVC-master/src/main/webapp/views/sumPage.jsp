<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="${ctxPath }/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${ctxPath }/js/echarts.js"></script>
<script type="text/javascript" src="${ctxPath }/js/bar/demo-bar2.js"></script>
<script type="text/javascript">
	var list = ${result};
</script>
</head>
<body>
	<input type="hidden" id="sum" value="${sum }"/>
	<input type="hidden" id="list" value="${result }"/>
<!-- 	产品交易量 -->
	<div id="prdTrade" style="width: 70%;height:500px;"></div>
</body>
</html>