/**
 * Created by zwd on 2017/3/4.
 */
$(function () {

    //搜索框的验证
    $("#form_search").submit(function(){
        var condition = $(" #form_search #condition").val();
        var radio = $(".div_radio :radio:checked").val();
        if(null == radio || radio == "") {
            alert("请选择条件类型！");
            return false;
        }else if(null == condition || condition == ""){
            alert("请输入查询条件！");
            return false;
        }
        else if(radio == 2 ) {
            if(isNaN(condition)){
                alert("请输入1-5之间的数字！");
                return false;
            }else if(Number(condition) < 1 || Number(condition) > 5){
                alert("请输入1-5之间的数字！");
                return false;
            }
        } else {
            return true;
        }
    });


    /**
     *  文件上传
     */
    $("#input_file").change(function () {
        var file_warning = $("#file_warning");
        var file_name = $("#file_name");
        var file_img = $("#file_img");
        var filepath = $("#input_file").val();
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length).toUpperCase();
        if(ext != ".XLS"){
            file_warning.text("文件格式有误！");
            file_img.attr("src","");
            file_name.text("只支持xls文件");
        }else{
            file_img.attr("src","/static/img/timg.jpg");
            file_name.text(filepath);
            file_warning.text("正在验证，请稍等...");
            verifyFile();
        }
    });

    /**
     * 验证全部
     */
    $("#model_append form").submit(function () {
        if(verifyAll()){
            return true;
        }else {
            return false;
        }
    });


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
 * 验证文件
 */
function verifyFile() {
    var file_warning = $("#file_warning");
    var sub_file = $("#sub_file");
    var options = {
        url:"verifyFile",
        type:"POST",
        async: false,
        dataType:"json",
        success:function (data) {
            var line = data.line;
            var errors = data.errors;
            if(errors != null && errors.length > 0 ){
                var str = '';
                for(var i=0 ; i< errors.length;i++){
                    str = str +errors[i] + "<br>";
                }
                file_warning.html("第"+ line +"行："+"<br>" + str);
            }else {
                file_warning.text("可以上传");
                sub_file.attr("disabled",false);
            }
        }
    }

    $("#form_file").ajaxSubmit(options);
}

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
        password_warning.text("密码必须为6-12个字符")
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
                alert("注册成功！");
            if(data == "0"){
            }
        }
    }
    if(verifyAll()){
        $("#form_regist").ajaxSubmit(options);
    }
});


/**
 * 批量删除会员
 */
function deleteUsers(currentPage,pageSize,radio,condition){
    var s = $(".check_user:checked").size();
    if(s <= 0){
        alert("请至少选择一个！");
        return
    }
    if(!confirm("你确定删除么")){
        return;
    }
    $("#form_delete").attr("action","deleteUsers");
    $("#form_delete").prepend("<input type='hidden' name='currentPage' value='" + currentPage +"'/>");
    $("#form_delete").prepend("<input type='hidden' name='pageSize' value='"+ pageSize +"'/>");
    if(null != radio && ""!= radio ){
        $("#form_delete").prepend("<input type='hidden' name='radio' value='"+ radio +"'/>");
    }
    if(null != condition && ""!= condition ){
        $("#form_delete").prepend("<input type='hidden' name='condition' value='"+ condition +"'/>");
    }
    $("#form_delete").attr("method","post").submit();
}


/**
 * checkbox的全选全不选
 * @param name
 * @param checked
 */
function checkBox(name,checked) {
    $("input[name='" + name + "']").prop("checked",checked);
}


/*
 *跳转到修改会员的界面
 */
function updateUser(userId,currentPage,pageSize,radio,condition){
    $.ajax({
        type:"get",
        url:"toUpdate?userId=" + userId + "&t="+( new Date() ).getTime().toString(),
        success:function (user) {
            $("#model_append form").attr("action","update");
            $("#model_append form").prepend("<input type='hidden' name='userId' id='userId' value='"+ userId +"'/>");
            $("#model_append form").prepend("<input type='hidden' name='currentPage' value='" + currentPage +"'/>");
            $("#model_append form").prepend("<input type='hidden' name='pageSize' value='"+ pageSize +"'/>");
            if(null != radio && ""!= radio ){
                $("#model_append form").prepend("<input type='hidden' name='radio' value='"+ radio +"'/>");
            }
            if(null != condition && ""!= condition ){
                $("#model_append form").prepend("<input type='hidden' name='condition' value='"+ condition +"'/>");
            }

            $("#myModalLabel").text("修改会员信息");
            $("#username").val(user.userName).attr("disabled",true);
            $("#password").val(user.userPassword).attr("disabled",true);
            $("#repassword").val(user.userPassword).attr("disabled",true);
            if(user.userSex == '男'){
                $("#radio1").prop("checked",true);
                $("#radio2").prop("checked",false);
            }else if(user.userSex == '女'){
                $("#radio2").prop("checked",true);
                $("#radio1").prop("checked",false);
            }
            $("#email").val(user.userEmail);
            $("#phone").val(user.userPhone);


            $("#btn_append").trigger("click");
        }
    });
}