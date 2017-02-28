import dao.UserDao;
import entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        user.setUserEmail("12345678@qq.com");
        user.setUserLevel(3);
        user.setUserScore(1031);
        user.setUserName("abandon");
        user.setUserPassword("123456");
        user.setUserSex("男");
        user.setUserPhone("1515151515");
        System.out.println(userDao.add(user));
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
}
