
$(function() {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($("#prdTrade")[0]);
	
	
	for(var i=0; i<list.length; i++){
		
		var code = list[i].prodCode;
		var vue = list[i].num;
		
	}
	var data = eval(list);
	console.log(data);
	var builderJson = {
		  "all": $("#sum").val(),
		  "charts": {
//			 data
			 
			"map": 3237,
		    "lines": 2164,
		    "bar": 7561,
		    "line": 7778,
		    "pie": 7355,
		    "scatter": 2405,
		    "candlestick": 1842
//		    "radar": 2090,
//		    "heatmap": 1762,
//		    "treemap": 1593,
//		    "graph": 2060,
//		    "boxplot": 1537,
//		    "parallel": 1908,
//		    "gauge": 2107,
//		    "funnel": 1692,
//		    "sankey": 1568
		  }
		};

		var waterMarkText = 'ECHART';

		var canvas = document.createElement('canvas');
		var ctx = canvas.getContext('2d');
		canvas.width = canvas.height = 100;
		ctx.textAlign = 'center';
		ctx.textBaseline = 'middle';
		ctx.globalAlpha = 0.08;
		ctx.font = '20px Microsoft Yahei';
		ctx.translate(50, 50);
		ctx.rotate(-Math.PI / 4);
		ctx.fillText(waterMarkText, 0, 0);

		var option = {
		    backgroundColor: {
		        type: 'pattern',
		        image: canvas,
		        repeat: 'repeat'
		    },
		    tooltip: {},
		    title: [{
		        text: '在线构建',
		        subtext: '总计 ' + builderJson.all,
		        x: '25%',
		        textAlign: 'center'
		    }],
		    grid: [{
		        top: 50,
		        width: '90%',
		        bottom: '35%',
		        left: 20,
		        containLabel: true
		    }],
		    xAxis: [{
		        type: 'value',
		        max: builderJson.all,
		        splitLine: {
		            show: false
		        }
		    }],
		    yAxis: [{
		        type: 'category',
		        data: Object.keys(builderJson.charts),
		        axisLabel: {
		            interval: 0,
		            rotate: 30
		        },
		        splitLine: {
		            show: false
		        }
		    }],
		    series: [{
		        type: 'bar',
		        stack: 'chart',
		        z: 3,
		        label: {
		            normal: {
		                position: 'right',
		                show: true
		            }
		        },
		        data: Object.keys(builderJson.charts).map(function (key) {
		            return builderJson.charts[key];
		        })
		    }, {
		        type: 'bar',
		        stack: 'chart',
		        silent: true,
		        itemStyle: {
		            normal: {
		                color: '#eee'
		            }
		        },
		        data: Object.keys(builderJson.charts).map(function (key) {
		            return builderJson.all - builderJson.charts[key];
		        })
		    }
		    
		    ]
		}

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
		console.log(builderJson.charts);
});