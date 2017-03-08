package dao;

import dao.CatagoryDao;
import dao.MessageBoardDao;
import entity.MessageBoard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public class MessageBoardTest {

    private static MessageBoardDao messageBoardDao;

    @Before
    public void before() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
        messageBoardDao = (MessageBoardDao) ctx.getBean("messageBoardDao");
    }

    @Test
    public void testAdd() {
        MessageBoard messageBoard = new MessageBoard();
        messageBoard.setUserId(5);
        messageBoard.setMessage("食品保质期不过关，需要加强检验！");
        messageBoard.setState(0);
        System.out.println(messageBoardDao.add(messageBoard));
    }

    @Test
    public void testGetCount() {
        System.out.println(messageBoardDao.getTotalCount());
        System.out.println(messageBoardDao.getTotalCountbyName("gir"));
        System.out.println(messageBoardDao.getTotalCountbyState(0));
    }

    @Test
    public void testfind() {
        List<MessageBoard> list = messageBoardDao.findAll(0, 20);
        for (MessageBoard messageBoard : list) {
            System.out.println(messageBoard.getUserName() + "2222222222" + messageBoard.getMessage());
        }

        list = messageBoardDao.findMessagebydState(0, 0, 20);
        for (MessageBoard messageBoard : list) {
            System.out.println(messageBoard.getUserName() + "2222222222" + messageBoard.getMessage());
        }

        list = messageBoardDao.findMessagebyName("gir", 0, 20);
        for (MessageBoard messageBoard : list) {
            System.out.println(messageBoard.getUserName() + "2222222222" + messageBoard.getMessage());
        }
    }

}
