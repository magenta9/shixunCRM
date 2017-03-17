package serviceimpl;

import dao.MessageBoardDao;
import entity.MessageBoard;
import entity.MessageBoardPagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.MessageBoardService;
import util.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by magenta9 on 2017/3/2.
 */
@Service("messageBoardService")
@Transactional
public class MessageBoardServiceImpl implements MessageBoardService{

    @Resource
    private MessageBoardDao messageBoardDao;

    @Override
    public Pagination getMessages(int pageIndex, int pageSize) {
        int totalCount = messageBoardDao.getTotalCount();
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.findAll((pageIndex-1)*pageSize, pageSize);
        pagination.setItems(list);
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getMessagebyState(int pageIndex, int pageSize, int state) {
        int totalCount = messageBoardDao.getTotalCountbyState(state);
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.findMessagebydState(state, (pageIndex-1)*pageSize, pageSize);
        pagination.setItems(list);
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getMessagebyName(int pageIndex, int pageSize, String name) {
        int totalCount = messageBoardDao.getTotalCountbyName(name);
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.findMessagebyName(name, (pageIndex-1)*pageSize, pageSize);
        pagination.setItems(list);
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public boolean addMessage(MessageBoard messageBoard) {
        boolean result = false;
        if(messageBoardDao.add(messageBoard) != -1) {
            result = true;
        }
        return result;
    }

    @Override
    public int addMessages(List<MessageBoard> messageBoards) {
        return messageBoardDao.addList(messageBoards);
    }

    @Override
    public boolean updateMessage(MessageBoard messageBoard) {
        return messageBoardDao.update(messageBoard)!=-1;
    }

    @Override
    public MessageBoard getMessageBoardById(int messageId) {
        return messageBoardDao.getMessageBoardById(messageId);
    }

}
