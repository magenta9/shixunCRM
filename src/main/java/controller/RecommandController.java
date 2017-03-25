package controller;

import entity.Admin;
import entity.ProductItem;
import entity.Recommand;
import entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.AdminService;
import service.RecommendService;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by alienware on 2017/3/1.
 */
@Controller
public class RecommandController {

    @Resource
    private UserService userService;

    @Resource
    private RecommendService recommendService;
    /**
     * 商品推荐
     * @param tab 4选项卡代表商品推荐
     * @param map
     * @return
     */
    @RequestMapping("/user/toRecommand")
   public String recommand(@RequestParam(value = "tab",defaultValue = "4") int tab,ModelMap map){
        map.addAttribute("tab",tab);
        return "/user/recommand";
   }

    /**
     * 商品推荐
     * @return
     */
    @RequestMapping(value = "/user/recommand")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Recommand verifyUserName(@RequestParam(value = "pictureUrl")String pictureUrl){
        Recommand recommand = new Recommand();
        User user = userService.identifyUser(pictureUrl);
        if(user != null){
            recommand.setUser(user);
            List<ProductItem> products = recommendService.recommend(user.getUserName());
            if(products != null && products.size() > 0){
                recommand.setProducts(products);
            }
        }
        return recommand;
    }


}
