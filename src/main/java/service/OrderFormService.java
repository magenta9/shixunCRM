package service;


import entity.OrderForm;
import util.Pagination;

import java.util.List;

/**
 * 订单列表
 * Created by magenta9 on 2017/3/1.
 */
public interface OrderFormService {
    /**
     * 获取订单列表,用户使用
     * @param id
     * @return 个人订单所有信息
     */
    List<OrderForm> findbyUserId(int id);

    /**
     * 获取所有订单
     * @return 所有订单信息
     */
    List<OrderForm> findAllOrderForm();

    /**
     * 管理员分页查询订单
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Pagination getAll(int pageIndex, int pageSize);

    /**
     * 通过微信ID获取UserId
     * @param openid
     * @return
     */
    int getUserIdByWeixinId(String openid);

    //分页获取所有购物信息
    Pagination getUserOrderForm(int userId, int pageIndex, int pageSize);

    //分页模糊查询用户购物信息
    Pagination getUserOrderForm(int userId, String text, int pageIndex, int pageSize);
}
