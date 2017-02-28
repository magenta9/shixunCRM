package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * User的查询模型
 * Created by magenta9 on 2017/2/27.
 */
public interface UserDao extends Dao<User>{
    int add(User user);

    int del(User user);

    int update(User user);

    User findById(int id);

    List<User> findAll();

    int findbyNameAndPwd(String name, String password);

    int addList(List<User> users);
}
