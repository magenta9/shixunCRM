package dao;

import dao.OrdersDao;
import entity.Orders;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class OrdersTest {

    private static OrdersDao ordersDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        ordersDao = (OrdersDao) ctx.getBean("ordersDao");
    }

    @Test
    public void testAdd() {
        Orders orders = new Orders();
        orders.setOrdersCode("2D13FAC23AA");
        orders.setUserId(5);
        orders.setOrdersSum(300.0);
        System.out.println(ordersDao.add(orders));
    }

    @Test
    public void testFindbyUserId() {
        System.out.println(ordersDao.findbyUserId(5).get(0).getOrdersCode());
    }

    @Test
    public void testAddList() {
        List<Orders> list =  ordersDao.findbyUserId(5);
        ordersDao.addList(list);
    }

}
