package entity;

import java.io.Serializable;

/**
 create table orders (
 o_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,	# 订单id
 o_code char(16) NOT NULL, 						# 订单号
 u_id int NOT NULL, 								# 客户
 o_sum double(10, 2), 							# 支付价
 o_discount double(2,2) 							# 折扣
 `o_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP # 购买时间
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * Created by magenta9 on 2017/2/27.
 */
public class Orders implements Serializable {
    private int ordersId;
    private String ordersCode;
    private int userId;
    private Double ordersSum;
    private Double ordersDiscount = 1.0;
 private String ordersDate;		
 	
    public String getOrdersDate() {		
        return ordersDate;		
    }		
 	
    public void setOrdersDate(String ordersDate) {		
        this.ordersDate = ordersDate;		
    }		
  

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrdersCode() {
        return ordersCode;
    }

    public void setOrdersCode(String ordersCode) {
        this.ordersCode = ordersCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getOrdersSum() {
        return ordersSum;
    }

    public void setOrdersSum(Double ordersSum) {
        this.ordersSum = ordersSum;
    }

    public Double getOrdersDiscount() {
        return ordersDiscount;
    }

    public void setOrdersDiscount(Double ordersDiscount) {
        this.ordersDiscount = ordersDiscount;
    }
}
