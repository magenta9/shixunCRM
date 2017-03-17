package controller;

import entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * Created by alienware on 2017/3/1.
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {

    @Resource
    AdminService adminService;


    /**
     * 跳转到管理员首页
     * @param tab 表示选项是否选中，0代表首页被选中
     * @param map
     * @return
     */
    @RequestMapping("/main")
    public String main(@RequestParam(value="tab",defaultValue = "0")Integer tab,ModelMap map){
        map.addAttribute("tab",tab);
        return "/admin/main";
    }

    /**
     * 管理员登录登录
     * @param admin
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login(Admin admin,ModelMap map,HttpSession session){
        //判断逻辑
        if(admin.getAdminName() != null && admin.getAdminName() != "" && admin.getAdminPassword() != null && admin.getAdminPassword() != ""){
            if(adminService.isValid(admin.getAdminName(),admin.getAdminPassword())){
                session.setAttribute("admin",admin);
                return "redirect:/admin/main";
            }else {
                map.addAttribute("msg","用户名或密码有误，请重新登陆！");
                map.addAttribute("admin",admin);
                return "/admin/login";
            }
        }else {
            return "/admin/login";
        }
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/admin/login";
    }

}
