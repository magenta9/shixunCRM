package service;

/**
 * 测试管理员界面需要的一些方法
 * Created by magenta9 on 2017/3/13.
 */

import com.google.gson.Gson;
import entity.Product;
import entity.ProductItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.DateUtil;
import util.RegressionLine;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-dao.xml" ,"/spring/spring-service.xml"})
public class TestAdminService {

    @Resource(name = "adminService")
    private AdminService adminService;

    @Test
    public void testgetpast6MonthAddUserCount() {
        System.out.println(adminService.getPast6MonthAddUserCount());
    }

    @Test
    public void testgetSales() {
        System.out.println(adminService.getPast6MonthSale());
    }

    @Test
    public void testgetTopN() {
        List<ProductItem> list = adminService.getBestSaleProduct(5);
        System.out.println(new Gson().toJson(list).toString());
    }

    @Test
    public void testNextMonthSales() {
        System.out.println(RegressionLine.getPoint(adminService.getMonthSaleMap()));
    }

    @Test
    public void testCatagoryCount() {
        adminService.getCatagoryCount();
    }


    @Test
    public void testgetCalender() {
        Calendar calendarStart = DateUtil.String2Date("2017-01-13");
        Calendar calendarEnd = DateUtil.String2Date("2017-3-11");
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendarEnd.getTime()));
        calendarEnd.set(Calendar.DAY_OF_MONTH, 1);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(calendarEnd.getTime()));
        String str = new SimpleDateFormat("yyyy-MM-dd").format(calendarEnd.getTime());
//        System.out.println(str.substring(0, 7));
        System.out.println(adminService.getAddUserCount("2016-12-02", "2017-02-12"));
//        System.out.println(calendarStart.compareTo(calendarEnd));
//        if(calendarStart != null && calendarStart.compareTo(calendarEnd) < 0) {
//            System.out.println("helo");
//        }
    }
}
