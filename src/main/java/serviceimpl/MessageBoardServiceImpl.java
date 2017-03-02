package serviceimpl;

import dao.MessageBoardDao;
import entity.MessageBoard;
import entity.MessageBoardPagination;
import service.MessageBoardService;
import util.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by magenta9 on 2017/3/2.
 */
public class MessageBoardServiceImpl implements MessageBoardService{

    @Resource
    private MessageBoardDao messageBoardDao;

    @Override
    public Pagination getMessages(int pageIndex, int pageSize) {
        int totalCount = messageBoardDao.getTotalCount();
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.listAll((pageIndex-1)*pageSize, pageSize);
        pagination.setItems(list);
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getMessagesNotSolved(int pageIndex, int pageSize) {
        int totalCount = messageBoardDao.getTotalCountbyState(0) + messageBoardDao.getTotalCountbyState(1);
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.findMessageLNotSolved();
        pagination.setItems(list);
        pagination.countTotalPageNum();
        return pagination;
    }

    @Override
    public Pagination getMessagesNeedTreat(int pageIndex, int pageSize) {
        int totalCount = messageBoardDao.getTotalCountbyState(0);
        Pagination pagination = new MessageBoardPagination(pageIndex, pageSize, totalCount);
        List<MessageBoard> list = messageBoardDao.findMessagebydState(0);
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
        return false;
    }
}
