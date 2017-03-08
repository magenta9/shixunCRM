package wechat.util;

/**
 * 网页授权消息
 * Created by magenta9 on 2017/3/8.
 */
public class WeixinOauth2Token {
    private String accessToken; //授权接口凭证
    private int expiresIn;      //有效时长
    private String refreshToken;//刷新凭证
    private String openId;      //用户标识
    private String scope;       //用户授权作用域

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
