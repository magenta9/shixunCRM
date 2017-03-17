package service;

import entity.ProductItem;

import java.util.List;

/**
 * Created by alienware on 2017/3/16.
 */
public interface RecommendService {

    //根据用户id推荐用户页面显示的一组商品显示信息列表
    public List<ProductItem> recommend(String userId);

}
