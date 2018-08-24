$(function() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($("#prdTrade")[0]);
	 myChart.showLoading({
	 text : '正在努力的读取数据中...'
	 });

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : 'ECharts 示例'
		},
		tooltip : {},
		legend : {
			data : [ ]
		},
		xAxis : {
			data : []
		},
		yAxis : {
		},
		series : [ {
			name : '',
			type : 'bar',
			data : []
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
	myChart.showLoading();
	$(function() {
		var url = "showSum.htm";
		$.ajax({
			type : "GET",
			url : url,
			dataType : "json",
			data : {},
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			success : function(result) {
				
				if (result) {
					option.legend.data = result.legend;
					option.xAxis.data = result.category;
					option.series[0].data = result.series[0].data;
					option.series[0].name = result.series[0].name;

					myChart.setOption(option);
					myChart.hideLoading();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("图表请求数据失败!!!");
				alert(XMLHttpRequest.status);
				alert(XMLHttpRequest.readyState);
				alert(textStatus);
				myChart.hideLoading();

			}
		});
	})
});