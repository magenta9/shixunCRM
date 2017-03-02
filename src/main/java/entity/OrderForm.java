package entity;

import java.util.List;

/**
 * Created by magenta9 on 2017/3/1.
 */
public class OrderForm {

    private String ordersCode;
    private String userName;
    private String date;
    private double orderSum;
    private double orderDiscount;

    private List<OrderFormItem> orderItemList;

    public String getOrdersCode() {
        return ordersCode;
    }

    public void setOrdersCode(String ordersCode) {
        this.ordersCode = ordersCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public double getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(double orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public List<OrderFormItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderFormItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
