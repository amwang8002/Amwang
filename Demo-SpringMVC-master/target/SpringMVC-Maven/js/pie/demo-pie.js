$(function() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($("#pieChart")[0]);

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : 'ECharts 饼图'
		},
		 series: {
             type: 'pie',
             data: [
                 {name: 'A', value: 1212},
                 {name: 'B', value: 2323},
                 {name: 'C', value: 1919}
             ]
         }
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
});