package service;


import entity.OrderForm;

import java.util.List;

/**
 * Created by magenta9 on 2017/3/1.
 */
public interface OrderFormService {
    List<OrderForm> findbyUserId(int id);
}
