package dao;

import dao.UserDao;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magenta9 on 2017/2/27.
 */
public class UserTest {


    private static UserDao userDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        userDao = (UserDao) ctx.getBean("userDao");
    }

    /**
     * 测试id查询
     */
    @Test
    public void testFindbyId() {
        User user = userDao.findById(1);
        System.out.println(user.getUserName() + user.getUserEmail());
    }

    /**
     * 测试添加数据
     */
    @Test
    public void testaddUser() {
        User user = new User();
        user.setUserEmail("123326178@qq.com");
        user.setUserLevel(6);
        user.setUserScore(2000);
        user.setUserName("girl");
        user.setUserPassword("123456");
        user.setUserSex("女");
        user.setUserPhone("115");
        user.setOpenId("abcdefghijklmn");
        System.out.println(userDao.add(user));
    }

    /**
     * 批量添加数据
     */
    @Test
    public void testaddUserList() {
        for(int i=0; i< 50;i++){
            User user = new User();
            user.setUserEmail("123326178@qq.com");
            user.setUserLevel(5);
            user.setUserScore(100);
            user.setUserName("boy" + i);
            user.setUserPassword("123456");
            user.setUserSex("男");
            user.setUserPhone("115" + i);
            userDao.add(user);
        }
    }

    /**
     * 测试获取所有数据
     */
    @Test
    public void testSelectAllUser() {
        List<User> users = userDao.findAll();
        for (User user: users) {
            System.out.println(user.getUserName() + " " + user.getUserPassword());
        }
    }

    /**
     * 测试验证用户信息
     */
    @Test
    public void testFindbyNameAndPwd() {
        int row = userDao.findbyNameAndPwd("zhang1", "123456");
        System.out.println(row);
    }
    @Test
    public void testGetUserByNameAndPwd(){
        User user = userDao.getUserByNameAndPwd("girl","123456");
        if(user!=null)
            System.out.println(user);
    }

    @Test
    public void testGetUserByOpenId(){
        User user =userDao.findUserByOpenId("abcdefghijklmn");
        if(user!=null)
            System.out.println(user);
    }

    /**
     * 测试更新用户数据
     */
    @Test
    public void testUpdateUser() {
        User user = userDao.findById(1);
        user.setUserPassword("321654");
        System.out.println(userDao.update(user));
    }

    /**
     * 测试删除用户数据
     */
    @Test
    public void testDelUser() {
        User user = userDao.findById(1);
        System.out.println(userDao.del(user));
    }

    @Test
    public void testAddImage() {
        User user = userDao.findById(2);
        user.setUserImageUrl("../images/absdsdsd.jpg");
        System.out.println(userDao.addImage(user));
    }

    /**
     * 测试批量导入功能
     */
     @Test
    public void testAddList() {
        User user = new User();
        user.setUserEmail("123326178@qq.com");
        user.setUserLevel(6);
        user.setUserScore(2000);
        user.setUserName("girl");
        user.setUserPassword("123456");
        user.setUserSex("女");
        user.setUserPhone("115");
        List<User> list = new ArrayList<>();
        list.add(user);

        User user1 = new User();
        user1.setUserEmail("12332316178@qq.com");
        user1.setUserLevel(3);
        user1.setUserScore(200);
        user1.setUserName("bbb");
        user1.setUserPassword("123456");
        user1.setUserSex("男");
        user1.setUserPhone("11565178178");
        list.add(user1);
        System.out.println(userDao.addList(list));
    }

    /**
     * 测试返回所有注册会员数量
     */
    @Test
    public void testGetTotalCount(){
        System.out.println("当前注册会员的数量为:"+userDao.getTotalCount());
    }

    /**
     * 测试分页返回会员信息
     */
    @Test
    public void testList(){
        List<User> users = userDao.list(0,2);
        for (User user:users
             ) {
            System.out.println("user:"+user);
        }
    }

    @Test
    public void testGetCount(){
        System.out.println("当前符合的会员有:"+userDao.getCount("gi")+"个");

    }

    @Test
    public void testSerachByUname(){
        List<User> users =userDao.serachByUname("gi",0,2);
        for (User user:users
                ) {
            System.out.println("user:"+user);
        }
    }

    @Test
    public void testGetCountByLevel(){
        System.out.println("等级为3的会员数量为:"+userDao.getCountByLevel(3));
    }

    @Test
    public void testSearchUsersByLevel(){
        List<User> users =userDao.searchUsersByLevel(6,0,2);
        for (User user:users
                ) {
            System.out.println("user:"+user);
        }
    }

}
