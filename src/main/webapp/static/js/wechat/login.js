/**
 * Created by zwd on 2017/3/9.
 */

$("#btn_login").click(function () {
    var options = {
        dataType:"json",
        success:function (data) {
            if(data == "0"){
                swal("","无该用户，请先注册！","error");
            }

            if(data == "1")
                swal("","绑定成功！","success");

            if(data == "2"){
                swal("","已绑定，请勿二次绑定！","error");
            }
        }
    }

    $("#form_login").ajaxSubmit(options);
});
