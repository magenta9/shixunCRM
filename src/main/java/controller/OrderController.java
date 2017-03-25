package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.OrderFormService;
import service.UserService;
import util.Pagination;
import util.StringUtils;

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderFormService orderFormService;

    /**
     * 根据用户ID按条件查询用户订单
     * 两种情况：如果text为空，则查询该用户所有的订单，text不为空查询符合要求的订单
     * @param userId
     * @param currentPage
     * @param pageSize 查询条件，具体就是订单号
     * @param text
     * @param map
     * @return
     */
    @RequestMapping(value = "list")
   public String list
        (@RequestParam(value = "tab",defaultValue = "2") int tab,
         @RequestParam(value = "userId") Integer userId,
         @RequestParam(value = "currentPage",defaultValue = "1") int currentPage ,
         @RequestParam(value = "changePageSize",required = false) Integer changePageSize,
         @RequestParam(value = "pageSize",required = false,defaultValue = "15") Integer pageSize,
         @RequestParam(value = "text",required = false) String text,
          ModelMap map)
        {
            Pagination pagination = null;
            //定义查询参数
            StringBuilder queryParames = new StringBuilder();
            queryParames.append("list");
            if(null != changePageSize && changePageSize > 0){
                currentPage = 1;
                pageSize = changePageSize;
            }

            map.addAttribute("pageSize",pageSize);
            map.addAttribute("userId",userId);
            queryParames.append("&userId=" + userId);


            //通过userId获取user
            User user = userService.getUserByUid(userId);
            if(null != user){
                map.addAttribute("user",user);

                //判断查询添加是否为空
                if(StringUtils.isEmpty(text)){
                    pagination = orderFormService.getUserOrderForm(userId,currentPage,pageSize);
                }else {
                    //但条件查找
                    map.addAttribute("text",text);
                    queryParames.append("&text=" + text);
                    pagination = orderFormService.getUserOrderForm(userId,text,currentPage,pageSize);
                }

            }
            if(null != pagination){
                map.addAttribute("pagination",pagination);
            }
            map.addAttribute("tab",tab);
            map.addAttribute("queryParames",queryParames);
           return "/order/list";
   }

}
