package serviceimpl;

import dao.OrderItemDao;
import dao.OrdersDao;
import dao.ProductDao;
import dao.UserDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderFormService;
import util.Pagination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magenta9 on 2017/3/1.
 */
@Service("orderFormService")
@Transactional
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
        return getList(listOrders);
    }

    @Override
    public List<OrderForm> findAllOrderForm() {
        List<Orders> listOrders = ordersDao.findAll();
        return getList(listOrders);
    }

    public List<OrderForm> getList(List<Orders> listOrders) {
        List<OrderForm> list = new ArrayList<>();
        for (Orders order : listOrders) {
            OrderForm orderForm = new OrderForm();
            orderForm.setOrdersCode(order.getOrdersCode());
            orderForm.setUserName(userDao.findById(order.getUserId()).getUserName());
            orderForm.setDate(order.getOrdersDate());
            orderForm.setOrderSum(order.getOrdersSum());
            orderForm.setOrderDiscount(order.getOrdersDiscount());

            List<OrderItem> listItem = orderItemDao.findbyOrderId(order.getOrdersId());

            orderForm.setOrderItemList(item2FormItem(listItem));
            list.add(orderForm);
        }

        return list;
    }

    @Override
    public int getUserIdByWeixinId(String openid) {
        return userDao.findUserByOpenId(openid).getUserId();
    }

    public Pagination getAll(int pageIndex, int pageSize) {
        int totalCount = orderItemDao.getTotalCount();
        Pagination pagination = new UserPagination(pageIndex,pageSize,totalCount);
        List<OrderItem> list = orderItemDao.list((pageIndex-1)*pageSize,pageSize);
        pagination.setItems(item2FormItem(list));
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getUserOrderForm(int userId, int pageIndex, int pageSize) {
        Pagination pagination = null;
        List<Orders> listOrders = ordersDao.findbyUserId(userId);
        if(null != listOrders && listOrders.size() > 0){
            int totalCount = orderItemDao.getCountbyOrders(listOrders);
            pagination = new UserPagination(pageIndex,pageSize,totalCount);
            List<OrderItem> list = orderItemDao.findbyOrders(listOrders, (pageIndex-1)*pageSize,pageSize);

            pagination.setItems(item2FormItem(list));
            pagination.countTotalPageNum();
        }

        return pagination;
    }

    public List<OrderFormItem> item2FormItem(List<OrderItem> list) {
        List<OrderFormItem> list1 = new ArrayList<>();
        for (OrderItem orderItem : list) {
            OrderFormItem ofi = new OrderFormItem();
            Product product = productDao.findbyId(orderItem.getProductId());
            Orders orders = ordersDao.findbyOrderId(orderItem.getOrderId());
            ofi.setDate(orders.getOrdersDate());
            ofi.setOrdersCode(orders.getOrdersCode());
            ofi.setProductName(product.getProduceName());
            ofi.setProductImage(product.getProduceImage());
            ofi.setProductPrice(product.getProducePrice() * orderItem.getOrderItemNum());
            ofi.setItemNum(orderItem.getOrderItemNum());
            ofi.setProductContext(product.getProduceContext());
            ofi.setProductBrand(product.getProduceBrand());
            list1.add(ofi);
        }
        return list1;
    }


}
