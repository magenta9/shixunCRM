package service;

import entity.User;
import util.Pagination;

import java.util.List;

/**
 * Created by alienware on 2017/3/1.
 */
public interface UserService {
    //分页返回默认查询的所有会员信息
    public Pagination getUsers(int pageIndex, int pageSize);

    //分页按会员名模糊查询返回
    public Pagination getUsers(String uname, int pageIndex, int pageSize);

    //分页按会员等级进行查询返回
    public Pagination getUsers(int level, int pageIndex, int pageSize);

    //插入单个用户
    boolean addUser(User user);

    //批量插入会员
    int addUser(List<User> userList);

}
