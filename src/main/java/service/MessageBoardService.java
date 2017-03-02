package service;

import entity.MessageBoard;
import util.Pagination;

import java.util.List;

/**
 * Created by magenta9 on 2017/3/2.
 */
public interface MessageBoardService {
    //分页获取所有留言板信息
    public Pagination getMessages(int pageIndex, int pageSize);

    //分页获取待处理和处理中的信息
    public Pagination getMessagesNotSolved(int pageIndex, int pageSize);

    //分页获取待处理的信息
    public Pagination getMessagesNeedTreat(int pageIndex, int pageSize);

    //添加一条处理消息
    boolean addMessage(MessageBoard messageBoard);

    //批量插入处理消息
    int addMessages(List<MessageBoard> messageBoards);

    //更新消息的处理状态
    boolean updateMessage(MessageBoard messageBoard);
}
