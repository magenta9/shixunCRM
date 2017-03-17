package wechat.response;

/**
 * 图文消息类
 * Created by magenta9 on 2017/3/5.
 */
public class Article {
    private String Title;   //图文消息名
    private String Description; //图文消息描述
    private String PicUrl;  //图片链接，(JPG/PNG)
    private String Url;     //点击图文跳转链接

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}
