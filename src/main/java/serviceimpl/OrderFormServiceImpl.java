package serviceimpl;

import dao.OrderItemDao;
import dao.OrdersDao;
import dao.ProductDao;
import dao.UserDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import service.OrderFormService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magenta9 on 2017/3/1.
 */
public class OrderFormServiceImpl implements OrderFormService{

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public  List<OrderForm> findbyUserId(int id) {
        List<Orders> listOrders = ordersDao.findbyUserId(id);
        List<OrderForm> list = new ArrayList<>();
        for (Orders order : listOrders) {
            OrderForm orderForm = new OrderForm();
            orderForm.setOrdersCode(order.getOrdersCode());
            orderForm.setUserName(userDao.findById(order.getUserId()).getUserName());
            orderForm.setDate(order.getOrdersDate());
            orderForm.setOrderSum(order.getOrdersSum());
            orderForm.setOrderDiscount(order.getOrdersDiscount());

            List<OrderItem> listItem = orderItemDao.findbyOrderId(order.getOrdersId());
            List<OrderFormItem> list1 = new ArrayList<>();
            for (OrderItem orderItem : listItem) {
                OrderFormItem orderFormItem = new OrderFormItem();
                orderFormItem.setItemNum(orderItem.getOrderItemNum());
                Product product = productDao.findbyId(orderItem.getProductId());
                orderFormItem.setProductName(product.getProduceName());
                orderFormItem.setProductPrice(product.getProducePrice());
                orderFormItem.setProductBrand(product.getProduceBrand());
                orderFormItem.setProductContext(product.getProduceContext());
                orderFormItem.setProductImage(product.getProduceImage());
                list1.add(orderFormItem);
            }
            orderForm.setOrderItemList(list1);
            list.add(orderForm);
        }

        return list;
    }
}
