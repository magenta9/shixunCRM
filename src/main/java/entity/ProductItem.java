package entity;

/**
 * Created by magenta9 on 2017/3/13.
 */
public class ProductItem {
    private String productName;     //产品名称
    private String productCatagory; //产品类别
    private double productPrice;    //产品价格
    private String productImage;    //产品图片地址
    private String produceContext;  //产品简介
    private String productBrand;    //产品品牌

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProduceContext() {
        return produceContext;
    }

    public void setProduceContext(String produceContext) {
        this.produceContext = produceContext;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}
