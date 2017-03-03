package dao;

import entity.OrderItem;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface OrderItemDao {
    List<OrderItem> findbyOrderId(int id);

    int add(OrderItem oi);

    int del(OrderItem oi);

    int delbyOrderId(int id);

    List<OrderItem> findAll();

    int addList(List<OrderItem> list);

}
