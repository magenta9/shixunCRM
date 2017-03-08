package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by alienware on 2017/3/1.
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {

    /**
     *  跳转用户登录
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        System.out.print("111");
//        System.out.println(request.getParameter("openid"));
        return "/admin/login";
    }

    @RequestMapping("/login")
    public String login(){
        //判断逻辑

        return "/admin/main";
    }
}
