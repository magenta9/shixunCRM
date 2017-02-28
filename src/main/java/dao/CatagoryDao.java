package dao;

import entity.Catagory;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface CatagoryDao {
    int add(Catagory catagory);

    String findNamebyId(int id);
}
