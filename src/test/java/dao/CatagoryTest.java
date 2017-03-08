package dao;

import dao.CatagoryDao;
import entity.Catagory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class CatagoryTest {

    private static CatagoryDao catagoryDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        catagoryDao = (CatagoryDao) ctx.getBean("catagoryDao");
    }

    @Test
    public void testAdd() {
        Catagory catagory = new Catagory("生鲜");
        System.out.println(catagoryDao.add(catagory));
    }

    @Test
    public void testFindNamebyId() {
        System.out.println(catagoryDao.findNamebyId(2));
    }
}
