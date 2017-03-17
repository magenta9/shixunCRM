package dao;

import entity.Product;
import entity.ProductItem;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface ProductDao {
    int addList(List<Product> list);

    int add(Product product);

    List<Product> findAll();

    List<Product> findbyCatagoryId(int cid);

    Product findbyId(int id);

    ProductItem findBySerId(String productId);
}
