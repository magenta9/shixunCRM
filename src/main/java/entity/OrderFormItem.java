package entity;

/**
 * Created by magenta9 on 2017/3/1.
 */
public class OrderFormItem {

    private String ordersCode;
    private String date;
    private String productName;
    private int ItemNum;
    private double productPrice;
    private String productImage;
    private String productContext;

    public String getOrdersCode() {
        return ordersCode;
    }

    public void setOrdersCode(String ordersCode) {
        this.ordersCode = ordersCode;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductContext() {
        return productContext;
    }

    public void setProductContext(String productContext) {
        this.productContext = productContext;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    private String productBrand;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getItemNum() {
        return ItemNum;
    }

    public void setItemNum(int itemNum) {
        ItemNum = itemNum;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
