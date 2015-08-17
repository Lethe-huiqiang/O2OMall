
require.config({
            paths:{ 
                'echarts' :'http://echarts.baidu.com/build/echarts',
                'echarts/chart/pie' : 'http://echarts.baidu.com/build/echarts'
            }
        });
        
       
        require(
            [
                'echarts',
                'echarts/chart/pie' 
            ],
            function (ec) {
              
                var myChart = ec.init(document.getElementById('main')); 
                
                var labelTop = {
    normal : {
        label : {
            show : true,
            position : 'center',
            textStyle: {
                baseline : 'bottom'
            }
        },
        labelLine : {
            show : false
        }
    }
};
var labelBottom = {
    normal : {
		
        color: '#ccc',
        label : {
            show : true,
            position : 'center',
            formatter : function (a,b,c){return 100 - c + '%'},
            textStyle: {
                baseline : 'top'
            }
        },
        labelLine : {
            show : false
        }
    },
    emphasis: {
        color: 'rgba(0,0,0,0)'
    }
};
var radius = [40, 55];
var option = {
    legend: {
        x : 'center',
        y : 'center',
        data:[
            '总结','好评'
        ],
		fontSize:36
    },
   
   
    series : [
        {
            type : 'pie',
            center : ['30%', '30%'],
            radius : radius,
            data : [
                {name:'other', value:46, itemStyle : labelBottom},
                {name:'总结', value:54,itemStyle : labelTop}
            ]
        },
        {
            type : 'pie',
            center : ['70%', '30%'],
            radius : radius,
            data : [
                {name:'other', value:56, itemStyle : labelBottom},
                {name:'好评', value:44,itemStyle : labelTop}
            ]
        },
        
    ]
};
                    
        
               
                myChart.setOption(option); 
            }
        );