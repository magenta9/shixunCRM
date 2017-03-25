package dao;

import entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface OrdersDao {
    List<Orders> findbyUserId(int id);

    //模糊查找订单
    List<Orders> SearhbyUserId(@Param("id") int id, @Param("text") String text);

    int add(Orders orders);

    int addList(List<Orders> list);

    List<Orders> findAll();

    Orders findbyOrderId(int id);
    //距今num个月的销售额
    double listSale(@Param("month") int num);

    //区间内的销售额
    double listSaleBetween(@Param("start") String start, @Param("end") String end);
}
