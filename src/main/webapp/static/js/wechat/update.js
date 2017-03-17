/**
 * Created by zwd on 2017/3/9.
 */

$(function () {
    $("#username").blur(function(){
        verifyUserName($(this).val());
    });

    $("#email").blur(function(){
        verifyEmail($(this).val());
    });

    $("#phone").blur(function(){
        verifyPhone($(this).val());
    });

    $("#password").blur(function(){
        verifyPassword($(this).val());
    });

    $("#repassword").blur(function(){
        verifyRePassword($(this).val());
    });


});


/**
 * 验证再次输入的密码
 * @param repassword
 */
function verifyRePassword(repassword) {
    var password = $("#password").val();
    if(repassword != password){
        swal("","两次输入密码不一致！","error");
        return false;
    }else{
        return true;
    }
}
/**
 * 验证密码
 * @param password
 */
function verifyPassword(password) {
    var length = password.length;
    if(length < 6 || length > 12){
        swal("","密码格式有误！","error");
        return false;
    }else{
        return true;
    }
}



/**
 * 验证全部
 */
function verifyAll() {
    var username_flag = verifyUserName($("#username").val());
    var email_flag = verifyEmail($("#email").val());
    var phone_flag = verifyPhone($("#phone").val());
    if(username_flag && email_flag && phone_flag ){
        return true;
    }else{
        return false;
    }
}
/**
 * 验证手机
 * @param phone
 */
function verifyPhone(phone) {
    var reg = /^1[34578]\d{9}$/;
    if(!reg.test(phone)){
        swal("","电话号码格式有误！","error");
        return false;
    }else {
        return true;
    }
}

/**
 * 验证邮箱
 */
function verifyEmail(email) {
    var reg = /\w+[@]{1}\w+[.]\w+/;
    if(!reg.test(email)){
        swal("","邮箱格式有误！","error");
        return false;
    }else {
        return true;
    }

}

/**
 * 验证用户名
 * @param userName
 */
function verifyUserName(userName) {
    var flag =  true;
    var openid = $("#openid").val();
    var length = userName.length;
    if(length < 4 || length > 12 ){
        swal("","会员名必须为4-12字符！","error");
        flag = false;
    }else {
        //检验用户名是否存在
        $.ajax({
            url:"verifyUserName?userName=" + userName + "&openid=" + openid,
            async: false,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data == "1"){
                    swal("","会员名已被注册！","error");
                    flag =  false;
                }
            }
        });
    }
    return flag;
}

/**
 * 会员信息修改
 */
$("#btn_update").click(function () {
        var options = {
        dataType:"json",
        success:function (data) {
            if(data == "1")
                swal("","修改成功！","success");
            if(data == "0"){
                swal("","修改失败！","error");
            }
        }
    }
    if(verifyAll()){
        $("#form_update").ajaxSubmit(options);
    }
});

/**
 * 会员密码修改
 */
$("#btn_password").click(function () {
    var options = {
        dataType:"json",
        success:function (data) {
            if(data == "1")
                swal("","修改成功！","success");
            if(data == "0"){
                swal("","修改失败！","error");
            }
        }
    }
    if(verifyRePassword($("#repassword").val()) && verifyPassword($("#password").val())){
        $("#form_password").ajaxSubmit(options);
    }
});