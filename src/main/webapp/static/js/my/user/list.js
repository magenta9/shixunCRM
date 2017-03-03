$(function () {
    $("#btn_search").click(function () {
        var condition = $(" #form_search #condition").val();
        var radio = $(".div_radio :radio:checked").val();
        if(null == radio || radio == "") {
            alert("请选择条件类型！");
        }else if(null == condition || condition == ""){
            alert("请输入查询条件！");
        }
        else if(radio == 2 && isNaN(condition)){
            alert("请输入1-5之间的数字！");
            return ;
        }else{
            $("#form_search").submit();
        }
    });
});
