package controller.wechat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wechat.service.CoreService;
import wechat.util.ConnUtil;
import wechat.util.Oauth2Util;
import wechat.util.SNSUserInfo;
import wechat.util.WeixinOauth2Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by magenta9 on 2017/3/3.
 */
@Controller
@RequestMapping("/wechat")
public class WeChatController {

    /**
     * 确认界面
     */
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public String verify() {
        System.out.print("verify");
        return "/wechat/verify";
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public void verifyPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        if (ConnUtil.checkSignature(signature, timestamp, nonce)) {
            CoreService.processRequest(request, response);
        }
    }

    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public String oauth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");

        String code = request.getParameter("code");
        if(!"authdeny".equals(code)) {
            WeixinOauth2Token weixinOauth2Token = Oauth2Util.getOauth2AccessToken(code);
            String accesstoken = weixinOauth2Token.getAccessToken();
            String openid = weixinOauth2Token.getOpenId();
            request.setAttribute("openid", Oauth2Util.getSNSUserInfo(accesstoken, openid).getOpenId());
        }

        return "forward:/admin/toLogin";
    }
}
