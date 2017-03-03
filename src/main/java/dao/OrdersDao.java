package dao;

import entity.Orders;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface OrdersDao {
    List<Orders> findbyUserId(int id);

    int add(Orders orders);

    int addList(List<Orders> list);
}
