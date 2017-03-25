package service;

import entity.CatagoryCount;
import entity.ProductItem;

import java.util.List;
import java.util.Map;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface AdminService {
    public boolean isValid(String name, String password);

    //获取过去6个月用户增长数量
    public String getPast6MonthAddUserCount();

    //获取某一区间用户增长数量
    public String getAddUserCount(String startTime, String endTime);

    //获取过去6个月销售总额
    public String getPast6MonthSale();

    //获取某一区间销售统计
    public String getMonthSale(String startTime, String endTime);

    //在过往销售额的基础上加上预测
    public String getMonthSaleAndForecast();

    //获取销售情况最好的n件商品
    List<ProductItem> getBestSaleProduct(int n);

    public Map<String, Integer> getAddUserCountMap();

    public Map<String, Double> getMonthSaleMap();

    //获取会员性别分布
    public String getUserSexCount();

    //获取当前分类销售统计
    public List<CatagoryCount> getCatagoryCount();
}
