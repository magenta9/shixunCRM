package dao;

import entity.CatagoryCount;
import entity.OrderItem;
import entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface OrderItemDao {
    List<OrderItem> findbyOrderId(int id);

    int add(OrderItem oi);

    int del(OrderItem oi);

    int delbyOrderId(int id);

    int getTotalCount();

    List<OrderItem> findAll();

    List<OrderItem> list(@Param("offSet") int offSet, @Param("pageSize") int pageSize);

    int addList(List<OrderItem> list);

    int getCountbyOrders(List<Orders> orders);

    List<OrderItem> findbyOrders(@Param("list") List<Orders> orders, @Param("offSet") int offSet, @Param("pageSize") int pageSize);


    List<Integer> getTopNProduce(@Param("num") int n);

    List<CatagoryCount> getCatagoryCount();

}
