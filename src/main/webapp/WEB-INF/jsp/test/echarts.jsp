<%--
  Created by IntelliJ IDEA.
  User: magenta9
  Date: 2017/3/13
  Time: 下午5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>echarts</title>

    <script src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vendor/jquery.min.js"></script>
</head>
<body>
<div id="main" style="width: 600px; height: 400px;"></div>
<div id="saleCount" style="width: 600px; height: 400px;"></div>
<div id="catagory" style="width: 300px; height: 300px;"></div>
<script type="application/javascript">
    var saleCountChart = echarts.init(document.getElementById("saleCount"));
    var date = [];
    var count = [];
    var json = ${MonthSale};
    var len = json.length;
    for (var i = 0; i < len; ++i) {
        date.push(json[i].date);
        count.push(json[i].salesNum);
    }
    var option = {
        title: {
            text: '近期销售额'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['当月销售']
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : date
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售额',
                type:'line',
                stack: '总量',
                areaStyle: {normal: {}},
                data: count
            }
        ]
    };
    saleCountChart.setOption(option);
</script>

<script type="application/javascript">
    var myChart = echarts.init(document.getElementById("catagory"));
    var json = ${catagory};
    var data = [];
    var len = json.length;
    for (var i = 0; i < len; ++i) {
        var item = {value:"", name:""};
        item.value = json[i].number;
        item.name = json[i].name;
        data.push(item);
    }
    option = {
        backgroundColor: '#2c343c',

        title: {
            text: '各类别销售统计',
            left: 'center',
            top: 20,
            textStyle: {
                color: '#ccc'
            }
        },

        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        visualMap: {
            show: false,
            min: 100,
            max: 100,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series : [
            {
                name:'种类',
                type:'pie',
                radius : '55%',
                center: ['50%', '50%'],
                data: data.sort(function (a, b) { return a.value - b.value}),
                roseType: 'angle',
                label: {
                    normal: {
                        textStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        lineStyle: {
                            color: 'rgba(255, 255, 255, 0.3)'
                        },
                        smooth: 0.2,
                        length: 10,
                        length2: 20
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#c23531',
                        shadowBlur: 200,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    myChart.setOption(option);
</script>

<script type="application/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var date = [];
    var count = [];
    var json = ${addUserCount};
    var len = json.length;
    for (var i = 0; i < len; ++i) {
        date.push(json[i].date);
        count.push(json[i].count);
    }
    option = {
        title: {
            text: '会员注册数'
        },
        color: ['#3398DB'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                type : 'category',
                data : date,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'用户增长数',
                type:'bar',
                barWidth: '60%',
                data: count
            }
        ]
    };
    myChart.setOption(option);
</script>


</body>
</html>
