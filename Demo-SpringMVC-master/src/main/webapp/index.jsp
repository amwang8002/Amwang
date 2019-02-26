<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
// response.sendRedirect(path+"/index.htm");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctxPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" href="${ctxPath }/bootstrap/bootstrapDatepickr-1.0.0.css">
<script type="text/javascript" src="${ctxPath }/bootstrap/jquery-1.7.2.min.js"></script>
<script src="${ctxPath }/bootstrap/bootstrap.min.js"></script>
<script src="${ctxPath }/bootstrap/bootstrapDatepickr-1.0.0.min.js"></script>
<%-- <script type="text/javascript" src="${ctxPath }/jquery/jquery.js"></script> --%>
<script type="text/javascript">
	var url = "${ctxPath }/culDate.htm";
        //按钮单击时执行
        $(function(){
        	$("#culdate").prop('disabled', true);
        	$("#calendar").bootstrapDatepickr();
    		$("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
    		$("#calendar2").bootstrapDatepickr({date_format: "l, do F Y"});
    		
    		var flag = 999;
        	$("#startDate").blur(function() {
        		var date = $("#startDate").val();
        		if (date != ""){
        			flag = 000;
        		} else {
        			flag = 999;
        		}
        		if ($("#startDate").val() != "" && $("#dateNums").val() != ""){
        			$("#culdate").prop('disabled', false);
        		}
        	})
        	$("#dateNums").blur(function(){
        		var num = $("#dateNums").val();
        		if (num != ""){
        			flag = 000;
        		} else {
        			flag = 999;
        		}
        		if ($("#startDate").val() != "" && $("#dateNums").val() != ""){
        			$("#culdate").prop('disabled', false);
        		}
        	})
            $("#culdate").click(function(){
            	if ($("#startDate").val() != "" && $("#dateNums").val() != ""){
            		
	            	 //Ajax调用处理
	                $.ajax({
	                   type: "POST",
	                   url: url,
	                   data: {
	                	   "startDate":$("#startDate").val(),
	                	   "dateNums" :$("#dateNums").val()
	                   },
	                   dataType: "text",
	                   success: function(data){
	                       $("#results").html('<h3>'+data+'</h3>');
	                    },
	                   error: function(e){
	                	   console.log(e);
	                	   alert(e);
	                   }
	                });
            	} else {
            		alert("请先填写时间和计算天数")
            	}
             });
        });
</script> 
</head>
<body>
<form action="index.htm" method="post">
	<button type="submit">跳转演示页面</button>
</form> <br>
<form action="sumPrd.htm" method="post">
	<button type="submit">产品交易汇总页面</button>
</form> <br>
<form action="showAjaxPage.htm" method="post">
	<button type="submit">ajax测试页面</button>
</form> <br>

<h5>日期计算</h5>
<hr>
<div id="cul_date_form" class="container">
	<div class="row">
	   <label class="col-sm-2 control-label">开始日期</label>
	   <div class="col-md-4">
	     <div class="input-group">
			<span class="input-group-addon" id="basic-addon1"><i class="fa fa-calendar"></i></span>
			<input type="text" id="startDate" placeholder="格式yyyy-MM-dd/yyyyMMdd" required="required" readOnly class="form-control">
		 </div>
	   </div>
	</div>
	<hr>
	<div class="row">
	   <label class="col-sm-2 control-label">加减天数</label>
	   <div class="col-md-4">
	     <input type="text" id="dateNums" value="" placeholder="输入正整数或负整数" required="required" class="form-control">
	   </div>
	</div>
	<hr>
	<div class="row">
	   <div class="col-sm-offset-2 col-sm-10">
	     <button type="submit" id="culdate" class="btn btn-default">开始计算</button>
	   </div>
	</div>
	<div class="row">
	   <label class="col-sm-2 control-label">计算结果</label>
	   <div class="col-md-4">
	     <div id="results"></div>
	   </div>
	</div>
</div>
<!-- <div class="container"> -->
<!-- 	<h3>输入与input-group插件</h3> -->
<!-- 	<p>一个输入和一个引导input-group插件和Fontawesome图标。</p> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-4"> -->
<!-- 			<span>起始日期：</span> -->
<!-- 			<div class="input-group"> -->
<!-- 				<span class="input-group-addon" id="basic-addon1"><i class="fa fa-calendar"></i></span> -->
<!-- 				<input type="text" id="calendar1" placeholder="test" class="form-control"> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<hr/> -->
<!-- 	<h3>格式化日期——d-m-Y</h3> -->
<!-- 	<p>格式化日期的两位数的一天,两个月和4位。</p> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-4"> -->
<!-- 			<input type="text" id="calendar1" placeholder="test" class="form-control"> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<hr/> -->
<!-- 	<h3>格式化日期- l,F Y</h3> -->
<!-- 	<p>格式化日期的天的名字,两位八进制数字(例如:1、22日)天,全月和4位数。</p> -->
<!-- 	<div class="row"> -->
<!-- 		<div class="col-md-4"> -->
<!-- 			<input type="text" id="calendar2" placeholder="test" class="form-control"> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->

</body>
</html>