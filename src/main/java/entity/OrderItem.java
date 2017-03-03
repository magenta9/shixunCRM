package entity;

import java.io.Serializable;

/**
 * Created by magenta9 on 2017/2/28.
 CREATE TABLE `orderitem` (
 `o_id` int(11) NOT NULL AUTO_INCREMENT,
 `order_id` int(11) NOT NULL,
 `p_id` int(11) NOT NULL,
 `oi_number` int(11) NOT NULL,
 PRIMARY KEY (`o_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class OrderItem implements Serializable {
    private int orderItemId;
    private int orderId;
    private int productId;
    private int orderItemNum;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderItemNum() {
        return orderItemNum;
    }

    public void setOrderItemNum(int orderItemNum) {
        this.orderItemNum = orderItemNum;
    }
}
