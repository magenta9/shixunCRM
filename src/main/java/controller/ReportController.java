package controller;


import entity.CatagoryCount;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import service.AdminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
   //     map.addAttribute("addUserCount", adminService.getAddUserCount("2016-08-01", "2017-03-20")); //过去6个月新增会员信息
//        map.addAttribute("MonthSale", adminService.getMonthSaleAndForecast());      //过去6个月销售额以及下个月预测
   //     map.addAttribute("MonthSale", adminService.getMonthSale("2016-08-01", "2017-02-02"));          //过去6个月销售额
   //     map.addAttribute("catagory", adminService.getCatagoryCount());              //销售分类统计数据
   //     map.addAttribute("sex", adminService.getUserSexCount());
        map.addAttribute("tab",tab);
        return "/report/list";
    }

    /**
     *查询一段日期范围内的销售数据
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return json数据
     */
    @RequestMapping("/monthSaleByDate")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String monthSaleByDate(@RequestParam("startDate")String startDate,@RequestParam("endDate")String endDate){
        String monthSale = adminService.getMonthSale(startDate, endDate);
        return monthSale;
    }

    /**
     *查询一段日期范围内的会员增长数
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return json数据
     */
    @RequestMapping("/userAddByDate")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String userAddByDate(@RequestParam("startDate")String startDate,@RequestParam("endDate")String endDate){
        String addUserCount = adminService.getAddUserCount(startDate,endDate);
        return addUserCount;
    }

    /**
     *查询用户比例
     * @return json数据
     */
    @RequestMapping("/userSexRadio")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String userSexRadio(){
        String userSexRadio = adminService.getUserSexCount();
        return userSexRadio;
    }

    /**
     * 查找类别比例的报表
     * @return json数据
     */
    @RequestMapping("/catagoryRadio")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CatagoryCount> catagoryRadio(HttpServletResponse response) throws IOException {
        List<CatagoryCount> catagoryCountList = adminService.getCatagoryCount();
        return catagoryCountList;
    }
}
