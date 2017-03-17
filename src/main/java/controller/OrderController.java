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

import javax.annotation.Resource;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource
    private UserService userService;

    @Resource
    private OrderFormService orderFormService;

    /**
     * 根据用户ID查询用户订单
     * @param userId
     * @param currentPage
     * @param pageSize
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
          ModelMap map)
        {
            //定义查询参数
            StringBuilder queryParames = new StringBuilder();
            queryParames.append("list");
            if(null != changePageSize && changePageSize > 0){
                currentPage = 1;
                pageSize = changePageSize;
            }
            queryParames.append("?pageSize=" + pageSize);
            queryParames.append("&userId=" + userId);

            User user = userService.getUserByUid(userId);
            if(null != user){
                map.addAttribute("user",user);
            }

            Pagination pagination = orderFormService.getUserOrderForm(userId,currentPage,pageSize);
            if(null != pagination){
                map.addAttribute("pagination",pagination);
            }

            map.addAttribute("tab",tab);
            map.addAttribute("queryParames",queryParames);
           return "/order/list";
   }


}
