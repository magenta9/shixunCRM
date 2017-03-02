package dao;

import entity.MessageBoard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by magenta9 on 2017/2/28.
 */
public interface MessageBoardDao {

    int getTotalCount();

    int getTotalCountbyState(@Param("state")int state);

    int add(MessageBoard messageBoard);

    int update(MessageBoard messageBoard);

    int addList(List<MessageBoard> messageBoards);

    List<MessageBoard> findAll();

    List<MessageBoard> listAll(@Param("offSet")int offSet, @Param("pageSize")int pageSize);

    List<MessageBoard> findMessagebydState(int state);

    List<MessageBoard> findMessageLNotSolved();

    List<MessageBoard> list(@Param("offSet")int offSet, @Param("pageSize")int pageSize, @Param("state")int state);
}
