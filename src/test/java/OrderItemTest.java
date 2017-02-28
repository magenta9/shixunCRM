import dao.OrderItemDao;
import entity.OrderItem;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class OrderItemTest {

    private static OrderItemDao orderItemDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        orderItemDao = (OrderItemDao) ctx.getBean("orderItemDao");
    }

    @Test
    public void testAdd() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(2);
        orderItem.setOrderItemNum(2);
        orderItem.setProductId(10);
        System.out.println(orderItemDao.add(orderItem));
    }

    @Test
    public void testFind() {
        List<OrderItem> list = orderItemDao.findAll();
        for (OrderItem orderItem : list) {
            System.out.println(orderItem.getProductId());
        }
        list = orderItemDao.findbyOrderId(1);
        for (OrderItem orderItem : list) {
            System.out.println(orderItem.getProductId());
        }
    }

    @Test
    public void testDelbtOrderId() {
        System.out.println(orderItemDao.delbyOrderId(2));
    }

    @Test
    public void testDel() {
        OrderItem oi = orderItemDao.findbyOrderId(2).get(0);
        System.out.println(orderItemDao.del(oi));
    }

    @Test
    public void testAddList() {
        List<OrderItem> list = orderItemDao.findAll();
        System.out.println(orderItemDao.addList(list));
    }
}
