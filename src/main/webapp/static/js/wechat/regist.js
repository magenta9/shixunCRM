/**
 * Created by zwd on 2017/3/9.
 */

$(function () {
    $("#username").blur(function(){
        verifyUserName($(this).val());
    });
    $("#username").focus(function () {
        var username_warning = $("#username_warning");
        username_warning.text("");
    });
    $("#password").blur(function(){
        verifyPassword($(this).val());
    });
    $("#password").focus(function () {
        var password_warning = $("#password_warning");
        password_warning.text("");
    });
    $("#repassword").blur(function(){
        verifyRePassword($(this).val());
    });
    $("#repassword").focus(function () {
        var repassword_warning = $("#repassword_warning");
        repassword_warning.text("");
    });
    $("#email").blur(function(){
        verifyEmail($(this).val());
    });
    $("#email").focus(function () {
        var email_warning = $("#email_warning");
        email_warning.text("");
    });
    $("#phone").blur(function(){
        verifyPhone($(this).val());
    });
    $("#phone").focus(function () {
        var phone_warning = $("#phone_warning");
        phone_warning.text("");
    });

});
/**
 * 验证全部
 */
function verifyAll() {
    var username_flag = verifyUserName($("#username").val());
    var password_flag = verifyPassword($("#password").val());
    var repassword_flag = verifyRePassword($("#repassword").val());
    var email_flag = verifyEmail($("#email").val());
    var phone_flag = verifyPhone($("#phone").val());
    if(username_flag && password_flag && repassword_flag && email_flag && phone_flag ){
        return true;
    }else{
        return false;
    }
}
/**
 * 验证邮箱
 * @param phone
 */
function verifyPhone(phone) {
    var phone_warning = $("#phone_warning");
    var reg = /^1[34578]\d{9}$/;
    if(!reg.test(phone)){
        phone_warning.text("请输入正确的手机号");
        return false;
    }else {
        return true;
    }
}

/**
 * 验证邮箱
 */
function verifyEmail(email) {
    var email_warning = $("#email_warning");
    var reg = /\w+[@]{1}\w+[.]\w+/;
    if(!reg.test(email)){
        email_warning.text("请输入正确的邮箱");
        return false;
    }else {
        return true;
    }

}

/**
 * 验证再次输入的密码
 * @param repassword
 */
function verifyRePassword(repassword) {
    var repassword_warning = $("#repassword_warning");
    var password = $("#password").val();
    if(repassword != password){
        repassword_warning.text("两次输入密码不一致");
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
    var password_warning = $("#password_warning");
    var length = password.length;
    if(length < 6 || length > 12){
        password_warning.text("密码必须为6-12个字符");
        return false;
    }else{
        return true;
    }
}
/**
 * 验证用户名
 * @param userName
 */
function verifyUserName(userName) {
    var flag =  true;
    var username_warning = $("#username_warning");
    var length = userName.length;
    if(length < 4 || length > 12 ){
        username_warning.text("会员名必须为4-12个字符");
        flag = false;
    }else {
        //检验用户名是否存在
        $.ajax({
            url:"verifyUserName?userName=" + userName,
            async: false,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data == "1"){
                    username_warning.text("该会员名已被注册");
                    flag =  false;
                }
            }
        });
    }
    return flag;
}


$("#btn_regist").click(function () {
        var options = {
        dataType:"json",
        success:function (data) {
            if(data == "1")
                swal("","注册成功！","success");
            if(data == "0"){
                swal("","注册失败！","error");
            }
            if(data == "2"){
                swal("","已注册，请勿二次注册！","error");
            }
        }
    }
    if(verifyAll()){
        $("#form_regist").ajaxSubmit(options);
    }
});
