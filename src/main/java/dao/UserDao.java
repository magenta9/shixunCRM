package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * User的查询模型
 * Created by magenta9 on 2017/2/27.
 */
public interface UserDao {
    int add(User user);

    int del(User user);

    int update(User user);

    User findById(int id);

    List<User> findAll();

    int findbyNameAndPwd(String name, String password);

    int addList(List<User> users);

    int addImage(User user);


    //返回当前的会员注册数量
    int getTotalCount();

    //分页查询user信息表
    List<User> list(@Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //返回当前表中符合会员名搜索的条数（在条数过多的时候分页返回）
    int getCount(@Param("uname") String uname);

    //按用户名模糊查询
    List<User> serachByUname(@Param("uname") String uname, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //获得某个等级下会员的数量
    int getCountByLevel(@Param("level") int level);

    //按会员等级分页返回会员信息
    List<User> searchUsersByLevel(@Param("level") int level, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据id集合批量删除用户
    int delUsers(List<Integer> uIds);
}
