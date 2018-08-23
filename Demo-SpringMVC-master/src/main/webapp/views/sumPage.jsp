<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>名次概率汇总</title>
<script type="text/javascript" src="${ctxPath }/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${ctxPath }/js/echarts.js"></script>
<script type="text/javascript" src="${ctxPath }/js/themes/dark.js"></script>
<script type="text/javascript" src="${ctxPath }/js/bar/demo-bar.js"></script>
</head>
<body>
<!-- 	产品交易量 -->
	<div id="prdTrade" style="width: 30%;height:250px;"></div>
</body>
</html>