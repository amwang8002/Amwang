<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${ctxPath }/jquery/jquery.js"></script>
<title>ajaxtext</title>
<script type="text/javascript">
	var url = "${ctxPath }/ab.htm";
    $(function(){
        //按钮单击时执行
        $("#testAjax").click(function(){
        	 //Ajax调用处理
            $.ajax({
               type: "POST",
               url: url,
               data: "name=garfield&age=18",
               contentType: "application/x-www-form-urlencoded; charset=utf-8",
               success: function(data){
                        $("#myDiv").html('<h2>'+data+'</h2>');
                  }
            });
         });
    });
</script>    
</head>
<body>
     <div id="myDiv"><h2>qwe  :${ctxPath }</h2></div>
     <button id="testAjax" type="button">Ajax改变内容</button>
 </body>
</html>