$(function () {
    var openid = $("#openid").val();
    var goods_ul = $("#goods_ul");
  $.ajax({
      url:"recommand?openid=" + openid,
      type:"GET",
      dataType:"json",
      success:function (data) {
          for(var i=0;i<data.length;i++){
              var productItem = data[i];
              goods_ul.append
              (
                "<li>" +
                    "<div>" +
                        "<a href=''>" +
                            "<img src='"+ productItem.productImage +"'/>" +
                        "</a>" +
                        "<div>" + productItem.productName + "</div>" +
                        "<div>简介：" + productItem.produceContext + "</div>" +
                        "<div>单价：<span>" + productItem.productPrice + "</span></div>" +
                    "</div>" +
                "</li>"
              );

          }
      }
  });
});