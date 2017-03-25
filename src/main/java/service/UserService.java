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

    //按id删除会员信息
    boolean deleteUser(int userId);


    //按一个id集合进行删除用户
    boolean deleteUser(List<Integer> uIds);

    //更新一个用户的信息
    boolean updateUser(User user);

    //根据用户的id获得唯一的一个会员对象
    User getUserByUid(int userId);

    //根据openid获取唯一会员对象
    User getUserByOpenId(String openId);

    //根据用户名和密码返回会员对象(唯一)
    User getUserByUnameAndPwd(String name, String password);

    //判断用户名是否使用
    boolean UserNameUsed(String name);

    //判断用户名字，email和手机号是否使用
    boolean judgeUser(User user);

    //上传照片创建用户personId
    boolean createUserPersonId(User user);

    //上传用户照片
    boolean addPersonface(User user);

    //进行人脸识别，获取userId
    User identifyUser(String url);
}
