package serviceimpl;

import dao.UserDao;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.WechatService;
import wechat.service.SendMessage;
import wechat.util.ConnUtil;
import wechat.util.Oauth2Util;

import javax.annotation.Resource;

/**
 * Created by magenta9 on 2017/3/14.
 */
@Service("wechatService")
@Transactional
public class WechatServiceImpl implements WechatService {

    @Resource
    private UserDao userDao;

    @Override
    public boolean SendMessage(int userId, String msg) {
        User user = userDao.findById(userId);
        if(user == null) return false;
        String openid = user.getOpenId();
        if(openid == null) return false;
        String jsonTextMsg = SendMessage.makeTextCustomMessage(openid, msg);
        SendMessage.sendCustomMessage(ConnUtil.getToken(), jsonTextMsg);
        return true;
    }
}
