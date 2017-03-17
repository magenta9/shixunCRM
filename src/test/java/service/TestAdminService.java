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
import util.RegressionLine;

import javax.annotation.Resource;
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
}
