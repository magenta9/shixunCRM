function imgPreview(fileDom){
    var span_warning = $("#span_warning");
    var a_picture = $("#a_picture");
    span_warning.text("正在识别,请稍等...");
    a_picture.attr("disabled",true);
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
        alert("请选择图片！");
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
        $.ajax({
            url:"recommand?pictureUrl=" + pictureUrl,
            async: false,
            type:"get",
            dataType:"json",
            success:function (data) {
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
                            var ProductItem = data.products[i];
                            var div_product = $("#div_product");
                            div_product.append(
                                "<div class='panel panel-info'>" +
                                    "<div class='panel-heading'>" +
                                        "<table>" +
                                            "<tbody>" +
                                                "<td class='col-xs-3'>种类：奶</td>" +
                                                "<td class='col-xs-3'>品牌：妮维雅</td>"+
                                                "<td class='col-xs-3'>价格：2.22</td>" +
                                            "</tbody>" +
                                        "</table>" +
                                    "</div>" +
                                    "<div class='panel-body'>" +
                                        "<table>" +
                                            "<tbody>" +
                                                "<td class='col-md-2'>" +
                                                    "<img src='${ pageContext.request.contextPath }/static/img/product/12.jpg'>" +
                                                "</td>" +
                                                "<td class='col-md-2'>妮维雅男士面霜保湿润肤露</td>" +
                                                "<td class='col-md-8'>" +
                                "牛奶是最古老的天然饮料之一，被誉为“白色血液”，对人体的重要性可想而知。牛奶顾名思义是从雌性奶牛身上所挤出来的。在不同国家，牛奶也分有不同的等级。目前最普遍的是全脂、低脂及脱脂牛奶。目前市面上牛奶的添加物也相当多，如高钙低脂牛奶，其中就增添了钙质 "+
                                                "</td>" +
                                             "</tbody>" +
                                        "</table>" +
                                    "</div>" +
                                "</div>"
                            );
                        }
                    }

                }else{
                    span_warning.text("可能图库中无该会员的信息奥！");
                }

                a_picture.attr("disabled",false);

            }
        });
    }, function  (error) {
        // body...
        console.log(JSON.stringify(error));
    });
}