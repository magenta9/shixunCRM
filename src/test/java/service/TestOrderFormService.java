package service;

import entity.OrderForm;
import entity.OrderFormItem;
import entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by magenta9 on 2017/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-dao.xml" ,"/spring/spring-service.xml"})
public class TestOrderFormService {

    @Resource(name = "orderFormService")
    private OrderFormService orderFormService;

    @Test
    public void testFindAll() {
        List<OrderForm> list = orderFormService.findAllOrderForm();
        for (OrderForm orderForm : list) {
            System.out.println(orderForm.getUserName());
            for (OrderFormItem formitem : orderForm.getOrderItemList()) {
                System.out.println(formitem.getProductName() + "--");
            }
        }
    }

    @Test
    public void testFindOther() {
        Pagination up = orderFormService.getAll(1, 10);
        System.out.println("分页组件信息:");
        System.out.println("总条数:"+up.getTotalCount());
        System.out.println("总页数:"+up.getTotalPages());
        System.out.println("当前页:"+up.getCurrentPage());
        System.out.println("当前页预计显示条数:"+up.getPageSize());
        System.out.println("当前页实际显示条数:"+up.getItems().size());
    }

    @Test
    public void testFindOtherbyUId() {
        Pagination up = orderFormService.getUserOrderForm(5, 1, 10);
        if(up == null) return;
        System.out.println("分页组件信息:");
        System.out.println("总条数:"+up.getTotalCount());
        System.out.println("总页数:"+up.getTotalPages());
        System.out.println("当前页:"+up.getCurrentPage());
        System.out.println("当前页预计显示条数:"+up.getPageSize());
        System.out.println("当前页实际显示条数:"+up.getItems().size());
    }

    @Test
    public void testfindbyId() {
        List<OrderForm> list = orderFormService.findbyUserId(5);
        if(list == null) return;
        for (OrderForm orderForm : list) {
            System.out.println(orderForm.getUserName());
            for (OrderFormItem formitem : orderForm.getOrderItemList()) {
                System.out.println(formitem.getProductName() + "--");
            }
        }
    }
}
