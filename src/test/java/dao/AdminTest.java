package dao;

import dao.AdminDao;
import dao.UserDao;
import entity.Admin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class AdminTest {

    private static AdminDao adminDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        adminDao = (AdminDao) ctx.getBean("adminDao");
    }

    /**
     * 测试添加管理员
     */
    @Test
    public void testaddAdmin() {
        Admin admin = new Admin();
        admin.setAdminName("mike");
        admin.setAdminPassword("123456");
        System.out.println(adminDao.add(admin));
    }

    /**
     * 测试通过id查找管理员信息
     */
    @Test
    public void testFindbyId() {
        Admin admin = adminDao.findById(1);
        System.out.println(admin.getAdminName());
    }

    /**
     * 测试更新管理员
     */
    @Test
    public void testUpdate() {
        Admin admin = adminDao.findById(1);
        admin.setAdminPassword("helloworld");
        System.out.println(adminDao.update(admin));
    }

    /**
     * 测试删除功能
     */
    @Test
    public void testDel() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        System.out.println(adminDao.del(admin));
    }

    /**
     * 测试名字&密码匹配方法
     */
    @Test
    public void testFindbyNameAndPwd() {
        System.out.println(adminDao.findbyNameAndPwd("mike", "123456"));
    }

    /**
     * 测试查看所有管理员
     */
    @Test
    public void testFindAll() {
        List<Admin> admins = adminDao.findAll();
        for (Admin admin : admins) {
            System.out.println(admin.getAdminName());
        }
    }
}
