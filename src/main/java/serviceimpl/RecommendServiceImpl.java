package serviceimpl;

import dao.ProductDao;
import dao.RecommendDao;
import entity.ProductItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RecommendService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alienware on 2017/3/16.
 */
@Service
@Transactional
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private RecommendDao recommendDao;

    @Resource
    private ProductDao productDao;

    @Override
    public List<ProductItem> recommend(String userId) {
        List<ProductItem> products = new ArrayList<>();
        //查出推荐产生的商品序列表
        String rec = recommendDao.getRecommend(userId);
        if(rec!=null){//有离线计算的推荐结果
            //提取出单个的商品标示
            String []pIds = rec.split(";");
            for(String id:pIds){
                //查找完整的商品显示信息
                ProductItem item = productDao.findBySerId(id);
                if(item!=null)
                    products.add(item);

            }
        }

        return products;
    }
}
