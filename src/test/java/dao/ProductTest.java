import dao.ProductDao;
import entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class ProductTest {

    private static ProductDao productDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        productDao = (ProductDao) ctx.getBean("productDao");
    }

    @Test
    public void testAdd() {
        Product product = new Product();
        product.setCatagoryId(2);
        product.setProduceBrand("蒙牛");
        product.setProduceContext("精典有机奶");
        product.setProduceImage("sdsdaijiwjji");
        product.setProduceName("蒙牛牛奶");
        product.setProducePrice(35.5);
        System.out.println(productDao.add(product));
    }

    @Test
    public void testFindAll() {
        List<Product> list = productDao.findAll();
        for (Product product : list) {
            System.out.println(product.getProduceContext());
        }
    }

    @Test
    public void testAddList() {
        productDao.addList(productDao.findAll());
    }

    @Test
    public void testFindbyCatagoryId() {
        List<Product> list = productDao.findbyCatagoryId(2);
        for (Product product : list) {
            System.out.println(product.getProduceName());
        }
    }
}
