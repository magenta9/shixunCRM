package wechat.util;

import java.util.List;

/**
 * 网页授权获取的用户信息
 * Created by magenta9 on 2017/3/8.
 */
public class SNSUserInfo {
    private String openId;  //标识
    private String nickname;//昵称
    private int sex;        //性别
    private String country; //国家
    private String province;//省份
    private String city;    //城市
    private String headImgUrl;  //头像链接地址

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

}
