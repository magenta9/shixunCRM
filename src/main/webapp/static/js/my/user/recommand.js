function imgPreview(fileDom){
    var span_warning = $("#span_warning");
    var a_picture = $("#a_picture");
    Bmob.initialize("077f3d85cb8c98c115678689fa6a10e3", "e1e6a5e3f209376b8b0d96911fa8c026");
    //判断是否支持FileReader
    if (window.FileReader) {
        var reader = new FileReader();
    } else {
        alert("您的设备不支持图片预览功能，如需该功能请升级您的设备！");
    }

    //获取文件
    var file = fileDom.files[0];
    var imageType = /^image\//;
    //是否是图片
    if (!imageType.test(file.type)) {
        span_warning.text("请选择图片！");
        return;
    }
    //读取完成
    reader.onload = function(e) {
        //获取图片dom
        var img = document.getElementById("user_pic");
        //图片路径设置为读取的图片
        img.src = e.target.result;
    };
    reader.readAsDataURL(file);
    var savefile = new Bmob.File(file.name, file);
    savefile.save().then(function  (obj) {
        var pictureUrl = obj.url();
        span_warning.text("正在识别,请稍等...");
        a_picture.attr("disabled",true);
        $.ajax({
            url:"recommand?pictureUrl=" + pictureUrl,
            async: false,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(typeof (data.user)=="undefined"){
                    span_warning.text("可能图库中无该会员的信息奥！");
                }else{
                    if(data != null){
                        var user = data.user;
                        $("#id").text(user.userId);
                        $("#username").text(user.userName);
                        $("#sex").text(user.userSex);
                        $("#phone").text(user.userPhone);
                        $("#email").text(user.userEmail);
                        $("#grade").text(user.userLevel);
                        $("#credit").text(user.userScore);
                        span_warning.text("");
                        if(null != data.products && data.products.length > 0){
                            for(var i=0; i<data.products.length;i++){
                                var productItem = data.products[i];
                                var div_product = $("#div_product");
                                div_product.append(
                                    "<div class='panel panel-info'>" +
                                    "<div class='panel-heading'>" +
                                    "<table>" +
                                    "<tbody>" +
                                    "<td class='col-xs-3'>种类：" + productItem.productCatagory +"</td>" +
                                    "<td class='col-xs-3'>品牌："+ productItem.productBrand +"</td>"+
                                    "<td class='col-xs-3'>价格："+ productItem.productPrice +"</td>" +
                                    "</tbody>" +
                                    "</table>" +
                                    "</div>" +
                                    "<div class='panel-body'>" +
                                    "<table>" +
                                    "<tbody>" +
                                    "<td class='col-md-2'>" +
                                    "<img src='" + productItem.productImage + "'style='width: 120px;height: 120px'>" +
                                    "</td>" +
                                    "<td class='col-md-2'>"+ productItem.productName +"</td>" +
                                    "<td class='col-md-8'>" +
                                    productItem.produceContext +
                                    "</td>" +
                                    "</tbody>" +
                                    "</table>" +
                                    "</div>" +
                                    "</div>"
                                );
                            }
                        }

                    }else{
                        span_warning.text("该用户没有可推荐商品！");
                    }
                }
                a_picture.attr("disabled",false);

            }
        });
    }, function  (error) {
        // body...
        console.log(JSON.stringify(error));
    });
}