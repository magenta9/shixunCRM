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

    //查找账户密码是否匹配
    int findbyNameAndPwd(String name, String password);

    //根据账户密码获取用户信息
    User getUserByNameAndPwd(String name, String password);

    //查找openid是否被使用
    User findUserByOpenId(String openId);

    //根据personid查询用户
    User findUserByPersonId(String personId);

    //查找emial是否被使用
    int getCountbyEmail(@Param("email") String email);

    //查找手机号是否被使用
    int getCountbyPhone(@Param("phone") String phone);

    //批量添加用户
    int addList(List<User> users);

    //添加图片信息
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

    //查找该名字是否已使用
    int getCountByUname(@Param("uname") String uname);

    //查找当月新增会员数
    int listaddUser(@Param("date") String yearandmonth);

    //查找当前日期开始的新增人数
    int listaddBetween(@Param("start") String start, @Param("end") String end);

    //查询会员性别为sex的人的人数
    int getSexCount(@Param("sexy") String sex);
}
