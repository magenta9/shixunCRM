import dao.CatagoryDao;
import dao.MessageBoardDao;
import entity.MessageBoard;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testUpdateAndFind() {
        MessageBoard messageBoard = messageBoardDao.findAll().get(0);
        messageBoard.setState(1);
        System.out.println(messageBoardDao.update(messageBoard));
    }

}
