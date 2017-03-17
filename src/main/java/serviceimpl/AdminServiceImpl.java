package serviceimpl;

import com.google.gson.Gson;
import dao.*;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AdminService;
import util.DateUtil;
import util.RegressionLine;

import java.util.*;


/**
 * Created by magenta9 on 2017/2/28.
 */
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CatagoryDao catagoryDao;

    @Override
    public boolean isValid(String name, String password) {
        return adminDao.findbyNameAndPwd(name, password)!=0;
    }

    @Override
    public Map<String, Integer> getAddUserCountMap() {
        Map<String, Integer> map = new TreeMap<>();
        Calendar calendar = DateUtil.String2Date();
        for (int i = 0; i < 6; i++) {
            int month = calendar.get(Calendar.MONTH)+1;
            int year = calendar.get(Calendar.YEAR);
            if(month <= i) {
                month = month + 12 - i;
                year -= 1;
            } else {
                month -= i;
            }
            String str = year + "-" + (month<10? "0"+month:month);
            map.put(str, userDao.listaddUser(str));
        }
        return map;
    }

    @Override
    public Map<String, Double> getMonthSaleMap() {
        Map<String, Double> map = new TreeMap<>();
        Calendar calendar = DateUtil.String2Date();
        for (int i = 0; i < 6; i++) {
            int month = calendar.get(Calendar.MONTH) + 1;
            int year = calendar.get(Calendar.YEAR);
            if(month <= i) {
                month = month + 12 - i;
                year -= 1;
            } else {
                month -= i;
            }
            String string = year + "-" + (month < 10 ? "0"+month:month);
            map.put(string, ordersDao.listSale(i));
        }
        return map;
    }

    @Override
    public String getCatagoryCount() {
        List<CatagoryCount> list = orderItemDao.getCatagoryCount();
//        for (CatagoryCount catagoryCount : list) {
//            System.out.println(catagoryCount.getName() + "->>>>" + catagoryCount.getNumber());
//        }
        return new Gson().toJson(list).toString();
    }

    @Override
    public String getPast6MonthAddUserCount() {
        Map<String, Integer> map = getAddUserCountMap();
        List<UserCount> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
//            System.out.println(stringIntegerEntry.getKey() + "---->" + stringIntegerEntry.getValue());
            UserCount userCount = new UserCount();
            userCount.setDate(stringIntegerEntry.getKey());
            userCount.setCount(stringIntegerEntry.getValue());
            list.add(userCount);
        }
        return new Gson().toJson(list).toString();
    }

    @Override
    public String getPast6MonthSale() {
        Map<String, Double> map = getMonthSaleMap();
        List<SaleCount> list = new ArrayList<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            SaleCount saleCount = new SaleCount();
            saleCount.setDate(entry.getKey());
            saleCount.setSalesNum(entry.getValue());
            list.add(saleCount);
        }
        return new Gson().toJson(list).toString();
    }

    @Override
    public String getMonthSaleAndForecast() {
        Map<String, Double> map = getMonthSaleMap();
        List<SaleCount> list = new ArrayList<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            SaleCount saleCount = new SaleCount();
            saleCount.setDate(entry.getKey());
            saleCount.setSalesNum(entry.getValue());
            list.add(saleCount);
        }
        SaleCount saleCount = new SaleCount();
        saleCount.setDate("预测该月销量");
        saleCount.setSalesNum(Math.ceil(RegressionLine.getPoint(map)));
        list.add(saleCount);
        return new Gson().toJson(list).toString();
    }


    @Override
    public List<ProductItem> getBestSaleProduct(int n) {
        List<Product> list = new ArrayList<>();
        List<Integer> integerList = orderItemDao.getTopNProduce(n);
        for (Integer integer : integerList) {
            list.add(productDao.findbyId(integer));
        }
        return product2ProductItem(list);
    }

    public List<ProductItem> product2ProductItem(List<Product> list) {
        List<ProductItem> productItemList = new ArrayList<>();
        for (Product product : list) {
            ProductItem productItem = new ProductItem();
            productItem.setProductName(product.getProduceName());
            productItem.setProductBrand(product.getProduceBrand());
            productItem.setProduceContext(product.getProduceContext());
            productItem.setProductCatagory(catagoryDao.findNamebyId(product.getCatagoryId()));
            productItem.setProductImage(product.getProduceImage());
            productItem.setProductPrice(product.getProducePrice());
            productItemList.add(productItem);
        }
        return productItemList;
    }

}
