package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import util.Pagination;

import javax.annotation.Resource;

/**
 * Created by alienware on 2017/3/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-dao.xml" ,"/spring/spring-service.xml"})
public class TestUserService {

    @Resource(name="userService")
    private UserService userService;

    @Test
    public void testGetUsers(){
        Pagination up = userService.getUsers(1,1);
        System.out.println("分页组件信息:");
        System.out.println("总条数:"+up.getTotalCount());
        System.out.println("总页数:"+up.getTotalPages());
        System.out.println("当前页:"+up.getCurrentPage());
        System.out.println("当前页预计显示条数:"+up.getPageSize());
        System.out.println("当前页实际显示条数:"+up.getItems().size());

    }

    @Test
    public void testGetUsersWithUname(){
        Pagination up = userService.getUsers("gi",1,1);
        System.out.println("分页组件信息:");
        System.out.println("总条数:"+up.getTotalCount());
        System.out.println("总页数:"+up.getTotalPages());
        System.out.println("当前页:"+up.getCurrentPage());
        System.out.println("当前页预计显示条数:"+up.getPageSize());
        System.out.println("当前页实际显示条数:"+up.getItems().size());

    }
}
