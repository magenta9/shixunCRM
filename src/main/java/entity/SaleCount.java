package entity;

/**
 * 销售统计
 * Created by magenta9 on 2017/3/13.
 */
public class SaleCount {
    private String date;
    private double salesNum;

    public double getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(double salesNum) {
        this.salesNum = salesNum;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
