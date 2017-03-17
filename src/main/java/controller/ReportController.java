package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.AdminService;

import javax.annotation.Resource;

/**
 * Created by magenta9 on 2017/3/2.
 */
@Controller
@RequestMapping(value="/report")
public class ReportController {

    @Resource
    private AdminService adminService;

    /**
     * 商品报表展示
     * @param tab 选项卡序号
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public String list(@RequestParam(value = "tab",defaultValue = "3")Integer tab, ModelMap map){
        map.addAttribute("addUserCount", adminService.getPast6MonthAddUserCount()); //过去6个月新增会员信息
        map.addAttribute("MonthSale", adminService.getMonthSaleAndForecast());      //过去6个月销售额以及下个月预测
//        map.addAttribute("MonthSale", adminService.getPast6MonthSale());          //过去6个月销售额
        map.addAttribute("catagory", adminService.getCatagoryCount());              //销售分类统计数据
        map.addAttribute("tab",tab);
        return "/report/list";
    }

}
