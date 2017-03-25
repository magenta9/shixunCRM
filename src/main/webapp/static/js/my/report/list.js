$(function () {
    //日期组件初始化
    {
        //初始化日期
        var today = new Date();
        $('.startDate').val(getPreMonthDay(today.Format("yyyy-MM-dd"),5));
        $('.endDate').val(today.Format("yyyy-MM-dd"));

        $('.startDate').datetimepicker({
            language:'zh-CN',
            format: 'yyyy-mm-dd',
            endDate:today,
            autoclose:true,
            startView: 2,
            minView: 2
        });

        $('.endDate').datetimepicker({
            language:'zh-CN',
            format: 'yyyy-mm-dd',
            endDate:today,
            autoclose:true,
            startView: 2,
            minView: 2
        });

        $("#sale_startDate").on('changeDate',function () {
            $("#sale_endtDate").datetimepicker('setStartDate', $("#sale_startDate").val());
        });

        $("#sale_endtDate").on('changeDate',function () {
            $("#sale_startDate").datetimepicker('setEndDate', $("#sale_endtDate").val());
        });

        $("#user_startDate").on('changeDate',function () {
            $("#user_endDate").datetimepicker('setStartDate', $("#user_startDate").val());
        });

        $("#user_endDate").on('changeDate',function () {
            $("#user_startDate").datetimepicker('setEndDate', $("#user_endDate").val());
        });

    }

    //报表组件初始化
    //1.销售报表
    {

        var saleCountChart = echarts.init(document.getElementById('saleCount'));
        var option = {
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['当月销售']
            },
            toolbox: {
                feature: {
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    },
                    dataView: {}
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
                    data : []
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
                    data: []
                }
            ]
        };
        saleCountChart.setOption(option);
        monthSaleByDate(saleCountChart);
        /**
         * 点击按钮
         */
        $("#btn_sale").click(function () {
            monthSaleByDate(saleCountChart);
        });
    }


    //报表组件初始化
    //2.会员增加报表
    {
        var userAddChart = echarts.init(document.getElementById('userAdd'));
        option = {
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            toolbox: {
                feature: {
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    },
                    dataView: {}
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
                    data : [],
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
                    data: []
                }
            ]
        };
        userAddChart.setOption(option);
        userAddByDate(userAddChart);
        /**
         * 点击按钮
         */
        $("#btn_user").click(function () {
            userAddByDate(userAddChart);
        });
    }

    //报表组件初始化
    //3.男女比例的报表
    {
        var userSexRadioChart = echarts.init(document.getElementById("userSexRadio"));

        var another = ["男", "女"];

        option = {
            title: {
                text: '性别统计',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            toolbox: {
                feature: {
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    },
                    dataView: {}
                }
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data: another
            },
            series: [
                {
                    name:'性别统计',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[]
                }
            ]
        };
        userSexRadioChart.setOption(option);
        userSexRadio(userSexRadioChart);
    }

    //报表组件初始化
    //4.类别种类比例
    {
        var catagoryRadioChart = echarts.init(document.getElementById("catagoryRadio"));
        option = {
            title: {
                text: '各类别销售统计',
                x: 'center'
            },

            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },

            toolbox: {
                feature: {
                    saveAsImage : {
                        show : true,
                        title : '保存为图片',
                        type : 'png',
                        lang : ['点击保存']
                    },
                    dataView: {}
                }
            },

            legend: {
                orient: 'vertical',
                left: 'left',
                data: []
            },
            series: [
                {
                    name: '种类',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '50%'],
                    data: [],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        catagoryRadioChart.setOption(option);
        catagoryRadio(catagoryRadioChart);
    }

});

//查找类别比例的报表
function catagoryRadio(catagoryRadioChart) {
    var timenow = new Date().getTime();
    var url = "catagoryRadio?timenow=" + timenow;
    ajaxReport(url,catagoryRadioChart,4);
}

//查找男女比例的报表
function userSexRadio(userSexRadioChart) {
    var timenow = new Date().getTime();
    var url = "userSexRadio?timenow=" + timenow;
    ajaxReport(url,userSexRadioChart,3);
}

//按月份更改会员增长数
function userAddByDate(userAddChart) {
    var timenow = new Date().getTime();
    var user_startDate = $("#user_startDate").val();
    var user_endDate = $("#user_endDate").val();
    var url = "userAddByDate?startDate="+user_startDate+"&endDate="+user_endDate + "&timenow=" + timenow;
    ajaxReport(url,userAddChart,2);
}


//按月份更改销售量的
function monthSaleByDate(saleCountChart) {
    var timenow = new Date().getTime();
    var sale_startDate = $("#sale_startDate").val();
    var sale_endDate = $("#sale_endtDate").val();
    var url = "monthSaleByDate?startDate="+sale_startDate+"&endDate="+sale_endDate + "&timenow=" + timenow;
    ajaxReport(url,saleCountChart,1);
}

/**
 * 发送ajax请求
 * @param url
 * @returns {Array}
 */
function ajaxReport(url,chart,type) {
    $.ajax({
        url:url,
        type:"get",
        dataType:"json",
        success:function (data) {
            //当type=1时，data为销售量的返回数据
            if(type == 1){
                refashMonthSaleByDate(data,chart)
            }
            //当type=2时，data为用户增长的返回
            if(type == 2){
                refashUserADDByDate(data,chart);
            }
            //当type=3时，data为男女比例的返回值
            if(type == 3){
                refashUserSexRadio(data,chart);
            }

            //当type=4时，data为种类比例的返回值
            if(type == 4){
                refashCatagoryRadio(data,chart);
            }
        }
    });
}

/**
 *更新类别的比例
 * @param data
 * @param chart
 */
function refashCatagoryRadio(json,chart){
    var data = [];
    var another = [];
    var len = json.length;
    for (var i = 0; i < len; ++i) {
        var item = {value: "", name: ""};
        item.value = json[i].number;
        item.name = json[i].name;
        data.push(item);
        another.push(item.name);
    }
    chart.setOption({
        legend:{data:another},
        series:[{
            data: data.sort(function (a, b) {
                return a.value - b.value
            })
        }]
    });
}

/**
 * 更新男女比例的图表
 * @param data
 * @param chart
 */
function refashUserSexRadio(json,chart) {
    var data = [];
    var len = json.length;
    data.push({name:"男", value:json["1"]});
    data.push({name:"女", value:json["0"]});
    chart.setOption({
        series:[{
            data:data
        }]
    });
}

/**
 * 更新用户量的图表
 * @param data
 * @param chart
 */
function refashUserADDByDate(data,chart) {
    var date = [];
    var count = [];
    var len = data.length;
    for (var i = 0; i < len; ++i) {
        date.push(data[i].date);
        count.push(data[i].count);
    }
    chart.setOption({
        xAxis:{
            data:date
        },
        series:[{
            data:count
        }]
    });
}

/**
 * 更新销售量的图表
 * @param data
 * @param chart
 */
function refashMonthSaleByDate(data,chart) {
    var date = [];
    var count = [];
    var len = data.length;
    for (var i = 0; i < len; ++i) {
        date.push(data[i].date);
        count.push(data[i].salesNum);
    }
    chart.setOption({
        xAxis:{
            data:date
        },
        series:[{
            data:count
        }]
    });
}

//获取前months月的日期
/**
*获取几个月前的输入日期
*{param:DateTime} date 输入日期(YYYY-MM-DD)
*{param:number } monthNum 月数
*/
function getPreMonthDay(date,monthNum)
{
    var dateArr = date.split('-');
    var year = dateArr[0]; //获取当前日期的年份
    var month = dateArr[1]; //获取当前日期的月份
    var day = dateArr[2]; //获取当前日期的日
    var days = new Date(year, month, 0);
    var year2 = year;
    var month2 = parseInt(month) - monthNum;
    if (month2 <=0) {
        //year2 = parseInt(year2) - parseInt(month2 / 12 == 0 ? 1 : parseInt(month2) / 12);
        year2 = parseInt(year2) - parseInt((Math.abs(month2)/12)) -1;
        month2 = 12 - (Math.abs(month2) % 12);
     }
    var day2 = day;
    var days2 = new Date(year2, month2, 0);
    days2 = days2.getDate();
    if (day2 > days2) {
        day2 = days2;
    }
    if (month2 < 10) {
     month2 = '0' + month2;
   }
  var t2 = year2 + '-' + month2 + '-' + day2;
    return t2;
}

// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
// 例子：
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}