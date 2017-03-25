package controller.wechat;

import entity.ProductItem;
import entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.OrderFormService;
import service.RecommendService;
import service.UserService;
import util.Pagination;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wechat")
public class WeChatUserController {

    @Resource
    private UserService userService;

    @Resource
    private OrderFormService orderFormService;

    @Resource
    private RecommendService recommendService;

    /**
     * 跳转到会员的登录界面并携带openId
     *
     * @return
     */
    @RequestMapping("/toLogin")
//    public String toLogin(@RequestParam(value = "openid")String openid,ModelMap map){
    public String toLogin(HttpServletRequest request, ModelMap map) {
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if (user == null) {
            map.addAttribute("openid", openid);
            return "/wechat/login";
        } else {
            map.addAttribute("msg", "该微信号已绑定");
            return "/wechat/warn";
        }
    }

    /**
     * 使用AJAX进行会员的绑定和验证
     *
     * @param openid
     * @param userName
     * @param userPassword
     * @return msg (0:表示不存在该用户 1：表示绑定成功 2:代表已绑定)
     */
    @RequestMapping("/login")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String login(
            @RequestParam("openid") String openid,
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword)

    {
        String msg = "";
        User user = userService.getUserByUnameAndPwd(userName,userPassword);
        if(user != null){
            if(openid.equals(user.getOpenId())){
                msg = "2";
            }else{
                user.setOpenId(openid);
                userService.updateUser(user);
                msg = "1";
            }
        } else {
            msg = "0";
        }
        return msg;
    }


    /**
     * 跳转到会员的注册界面并携带openId
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/toRegist")
    public String toRegist(HttpServletRequest request, ModelMap map) {
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if (user == null) {
            map.addAttribute("openid", openid);
            return "/wechat/regist";
        } else {
            map.addAttribute("msg", "该微信号已注册！");
            return "/wechat/warn";
        }
    }

    /**
     *完成用户注册的逻辑
     * @param user
     * @return msg (0:表示注册失败 1：表示注册成功 2:代表)
     */
    @RequestMapping(value = "/regist")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String regist(User user){
        String msg = "0";
        boolean flag = false;
        flag = userService.UserNameUsed(user.getUserName());
        if(!flag){
            if(null == userService.getUserByOpenId(user.getOpenId())){
                userService.addUser(user);
                msg = "1";
            }else {
                msg = "2";
            }
        }
        return msg;
    }

    /**
     * 验证会员名是否存在
     * @param userName
     * @return
     */
    @RequestMapping(value = "/verifyUserName")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String verifyUserName(@RequestParam(value = "userName")String userName,@RequestParam(value = "openid",required = false) String openid){
        String msg = "";
        boolean flag = false;
        flag = userService.UserNameUsed(userName);
        if(openid != null && openid != "" ){
            User user =  userService.getUserByOpenId(openid);
            if(userName.equals(user.getUserName()))
                flag = false;
        }
        if(flag == true){
            msg = "1";
        }else{
            msg = "0";
        }
        return msg;
    }

    /**
     * 判断跳转到订单的列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/toOrder")
    public String toOrder(HttpServletRequest request, ModelMap map) {
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        System.out.println("fghjkghjk" + openid);
        User user = userService.getUserByOpenId(openid);
        if (user != null) {
            map.addAttribute("openid", openid);
            return "/wechat/order";
        } else {
            map.addAttribute("msg", "该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     * ajax返回会员订单的信息
     *
     * @param openid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/order")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Pagination order(
            @RequestParam("openid") String openid,
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize) {
        Pagination pagination = null;
        User user = userService.getUserByOpenId(openid);
        if (null != user) {
            pagination = orderFormService.getUserOrderForm(user.getUserId(), currentPage, pageSize);
        }
        return pagination;
    }

    /**
     * 跳转到会员修改界面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(HttpServletRequest request,ModelMap map){
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if(user != null){
            map.addAttribute("user",user);
            map.addAttribute("openid",openid);
            return "/wechat/update";
        }else{
            map.addAttribute("msg","该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     *修改之前根据用户openid寻找用户
     * @param openid
     * @param map
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "openId",required = false)String openid, Map<String,Object> map){
        if(openid != null && openid != ""){
            User user = userService.getUserByOpenId(openid);
            if(user != null){
                map.put("user",user);
            }
        }
    }

    /**
     *完成用户注册的逻辑
     * @param user
     * @return msg (0:表示注册失败 1：表示注册成功)
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String update(User user){
        String msg = "0";
        if(userService.updateUser(user)){
            msg = "1";
        }
        return msg;
    }

    /**
     * 跳转到找回密码的界面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toPassword")
    public String toPassword(HttpServletRequest request,ModelMap map){
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if(user != null){
            map.addAttribute("user",user);
            map.addAttribute("openid",openid);
            return "/wechat/password";
        }else{
            map.addAttribute("msg","该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     * 跳转到上传头像的界面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toPicture")
    public String toPicture(HttpServletRequest request,ModelMap map){
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if(user != null){
            map.addAttribute("user",user);
            map.addAttribute("openid",openid);
            return "/wechat/picture";
        }else{
            map.addAttribute("msg","该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     * 上传头像
     * @param pictureUrl
     * @return
     */
    @RequestMapping(value = "/picture")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String picture(
            @RequestParam(value = "openid")String openid,
            @RequestParam(value = "pictureUrl")String pictureUrl
    )
    {
        String msg = "0";
        boolean flag = false;
        User user = userService.getUserByOpenId(openid);
        if(user.getUserImageUrl() != null && user.getUserImageUrl() != "" ){
            user.setUserImageUrl(pictureUrl);
            flag = userService.updateUser(user);
        }else {
            user.setUserImageUrl(pictureUrl);
            flag = userService.createUserPersonId(user);
        }

        if (flag == true){
            msg = "1";
        }
        return msg;
    }

    /**
     * 跳转到会员界面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toInformation")
    public String toInformation(HttpServletRequest request, ModelMap map){
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if(user != null){
            map.addAttribute("user",user);
            map.addAttribute("openid",openid);
            return "/wechat/information";
        }else{
            map.addAttribute("msg","该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     * 跳转到商品推荐的页面
     * @param map
     * @return
     */
    @RequestMapping(value = "/toRecommand")
    public String toRecommand(HttpServletRequest request,ModelMap map){
        String openid = (String) request.getAttribute("openid");
        if(openid == null) openid = (String) request.getParameter("openid");
        User user = userService.getUserByOpenId(openid);
        if(user != null){
            map.addAttribute("user",user);
            map.addAttribute("openid",openid);
            return "/wechat/recommand";
        }else{
            map.addAttribute("msg","该微信还未绑定，请先绑定！");
            return "/wechat/warn";
        }
    }

    /**
     * ajax返回商品的信息
     * @param openid
     * @return
     */
    @RequestMapping(value = "/recommand")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProductItem> recommand(@RequestParam("openid")String openid)
    {
        User user = userService.getUserByOpenId(openid);
        List<ProductItem> recommendProducts = recommendService.recommend(user.getUserName());
        return recommendProducts;
    }
}
