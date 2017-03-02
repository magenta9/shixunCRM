package dao;

import entity.MessageBoard;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface MessageBoardDao {

    int add(MessageBoard messageBoard);

    int update(MessageBoard messageBoard);

    List<MessageBoard> findAll();

    List<MessageBoard> findMessagebydState(int state);
}
