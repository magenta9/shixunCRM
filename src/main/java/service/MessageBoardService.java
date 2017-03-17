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

    //分页根据状态获取留言板信息
    public Pagination getMessagebyState(int pageIndex, int pageSize, int state);

    //分页模糊搜索姓名获取留言板信息
    public Pagination getMessagebyName(int pageIndex, int pageSize, String name);

    //添加一条处理消息
    boolean addMessage(MessageBoard messageBoard);

    //批量插入处理消息
    int addMessages(List<MessageBoard> messageBoards);

    //更新消息的处理状态
    boolean updateMessage(MessageBoard messageBoard);

    //根据ID查找MessageBoard
    MessageBoard getMessageBoardById(int messageId);
}
