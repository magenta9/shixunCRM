package dao;

import entity.wechat.RecommendItem;

import java.util.List;

/**
 * Created by alienware on 2017/3/16.
 */
public interface RecommendDao {
    public String getRecommend(String userId);

    public void insertRecommend(RecommendItem recommendItem);
}
