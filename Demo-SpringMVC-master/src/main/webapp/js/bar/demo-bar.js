$(function() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($("#prdTrade")[0]);
//	myChart.showLoading({
//		text : '正在努力的读取数据中...'
//	});

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : 'ECharts 入门示例'
		},
		tooltip : {},
		legend : {
			data : [ '销s量' ]
		},
		xAxis : {
		 data : []
//		 data : [ "衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子" ]
		},
		yAxis : {
//			data :[ 5,10,15,20,25,30,35,40 ]
		},
		series : [ {
			name : '销s量',
			type : 'bar',
			data : []
//			data : [ 5, 20, 36, 10, 10, 20 ]
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
//	myChart.hideLoading();
	$(function(){
		var url = "/SpringMVC-Maven/showSum.htm";
		$.ajax({
			type : "GET",
			url : url,
			dataType : "json",
			data : {},
//			contentType: "application/json; charset=utf-8",
			success : function(result) {
				alert(result);
				alert(result.legend);
				alert(result.category);
				alert(result.series[0].data);
				if(result){
					option.legend.data = result.legend;
					option.xAxis.data = result.category;
					option.series[0].data = result.series[0].data;
					
					myChart.setOption(option);
					myChart.hideLoading();
				}
			},
			error : function(errorMsg) {
				alert("图表请求数据失败!");
				//myChart.hideLoading();
				myChart.showLoading();
			}
		});
	})
});