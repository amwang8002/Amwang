<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
// response.sendRedirect(path+"/index.htm");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>
<html>
<body>
<form action="index.htm" method="post">
	<button type="submit">跳转演示页面</button>
</form>
<form action="sumPrd.htm" method="post">
	<button type="submit">产品交易汇总页面</button>
</form>
<form action="showAjaxPage.htm" method="post">
	<button type="submit">ajax测试页面</button>
</form>
</body>
</html>