package dao;

import entity.MessageBoard;
import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface MessageBoardDao {

    int getTotalCount();

    int getTotalCountbyState(@Param("state") int state);

    int getTotalCountbyName(@Param("name") String name);

    int add(MessageBoard messageBoard);

    int update(MessageBoard messageBoard);

    int addList(List<MessageBoard> messageBoards);

    List<MessageBoard> findAll(@Param("offSet") int offSet, @Param("pageSize") int pageSize);

    List<MessageBoard> findMessagebydState(@Param("state") int state, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    List<MessageBoard> findMessagebyName(@Param("name") String name, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    MessageBoard getMessageBoardById(int messageId);

}
