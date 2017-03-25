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
import java.io.UnsupportedEncodingException;
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

    /**
     * 与微信服务器进行交互
     * @param request
     * @param response
     * @throws IOException
     */
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

    //登录授权转到toLogin
    @RequestMapping(value = "/loginto", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        System.out.println(request.getAttribute("openid"));
        return "forward:/wechat/toLogin";
    }

    //注册信息
    @RequestMapping(value = "/bind", method = RequestMethod.GET)
    public String bind(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toRegist";
    }

    //修改个人信息
    @RequestMapping(value = "/alter", method = RequestMethod.GET)
    public String alter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toUpdate";
    }

    //修改个人密码
    @RequestMapping(value = "/alterpwd", method = RequestMethod.GET)
    public String alterpwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toPassword";
    }

    //上传照片
    @RequestMapping(value = "/uploadPic", method = RequestMethod.GET)
    public String uppic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toPicture";
    }

    //获取个人信息
    @RequestMapping(value = "/getinfo", method = RequestMethod.GET)
    public String getInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toInformation";
    }

    //购买记录
    @RequestMapping(value = "/order1", method = RequestMethod.GET)
    public String toorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toOrder";
    }

    //推荐商品
    @RequestMapping(value = "/getrecommend", method = RequestMethod.GET)
    public String getRecommend(HttpServletRequest request, HttpServletResponse response) throws IOException {
        addOpenId(request, response);
        return "forward:/wechat/toRecommand";
    }



    //添加Openid信息
    public void addOpenId(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");
        String code = request.getParameter("code");
        if(!"authdeny".equals(code)) {
            WeixinOauth2Token weixinOauth2Token = Oauth2Util.getOauth2AccessToken(code);
            String accesstoken = weixinOauth2Token.getAccessToken();
            String openid = weixinOauth2Token.getOpenId();
            request.setAttribute("openid", Oauth2Util.getSNSUserInfo(accesstoken, openid).getOpenId());
            System.out.println("adopenid" + request.getAttribute("openid"));
        }
    }
}
