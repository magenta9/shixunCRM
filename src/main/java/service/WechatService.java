package service;

/**
 * Created by magenta9 on 2017/3/14.
 */
public interface WechatService {
    public boolean SendMessage(int userId, String msg);
}
