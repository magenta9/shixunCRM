package entity;

import java.io.Serializable;

/**
 create table product (
 p_id int NOT NULL AUTO_INCREMENT primary key,	# 产品id
 c_id int NOT NULL,								# 产品种类id
 p_name varchar(50) NOT NULL,					# 产品名
 p_price double(10, 2) NOT NULL,				# 产品价格
 p_image varchar(100) NOT NULL,					# 产品图片地址
 p_context varchar(255) NOT NULL,				# 产品简介
 p_brand varchar(100) NOT NULL 					# 品牌
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * Created by magenta9 on 2017/2/27.
 */
public class Product implements Serializable {
    private int productId;
    private int catagoryId;
    private String produceName;
    private double producePrice;
    private String produceImage;
    private String produceContext;
    private String produceBrand;
    private String produceSerialNumber;

    public String getProduceSerialNumber() {
        return produceSerialNumber;
    }

    public void setProduceSerialNumber(String produceSerialNumber) {
        this.produceSerialNumber = produceSerialNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(int catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public double getProducePrice() {
        return producePrice;
    }

    public void setProducePrice(double producePrice) {
        this.producePrice = producePrice;
    }

    public String getProduceImage() {
        return produceImage;
    }

    public void setProduceImage(String produceImage) {
        this.produceImage = produceImage;
    }

    public String getProduceContext() {
        return produceContext;
    }

    public void setProduceContext(String produceContext) {
        this.produceContext = produceContext;
    }

    public String getProduceBrand() {
        return produceBrand;
    }

    public void setProduceBrand(String produceBrand) {
        this.produceBrand = produceBrand;
    }
}
