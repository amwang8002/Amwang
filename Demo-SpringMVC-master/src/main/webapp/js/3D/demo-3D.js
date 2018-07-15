$(function() {

	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init($("#3D")[0]);
	
	function makeGaussian(amplitude, x0, y0, sigmaX, sigmaY) {
	    return function (amplitude, x0, y0, sigmaX, sigmaY, x, y) {
	        var exponent = -(
	                ( Math.pow(x - x0, 2) / (2 * Math.pow(sigmaX, 2)))
	                + ( Math.pow(y - y0, 2) / (2 * Math.pow(sigmaY, 2)))
	            );
	        return amplitude * Math.pow(Math.E, exponent);
	    }.bind(null, amplitude, x0, y0, sigmaX, sigmaY);
	}
	// 创建一个高斯分布函数
	var gaussian = makeGaussian(50, 0, 0, 20, 20);

	var data = [];
	for (var i = 0; i < 1000; i++) {
	    // x, y 随机分布
	    var x = Math.random() * 100 - 50;
	    var y = Math.random() * 100 - 50;
	    var z = gaussian(x, y);
	    data.push([x, y, z]);
	}

	var option = {
		    // 需要注意的是我们不能跟 grid 一样省略 grid3D
		    grid3D: {},
		    // 默认情况下, x, y, z 分别是从 0 到 1 的数值轴
		    xAxis3D: {},
		    yAxis3D: {},
		    zAxis3D: { max: 100 },
		    series: [{
		        type: 'scatter3D',
		        data: data
		    }]
		}
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
	
});