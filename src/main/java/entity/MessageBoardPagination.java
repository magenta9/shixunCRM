package entity;

import util.Pagination;

/**
 * Created by magenta9 on 2017/3/2.
 */
public class MessageBoardPagination extends Pagination<MessageBoard> {
    public MessageBoardPagination(int currentPage,int pageSize,int totalCount){
        super(currentPage,pageSize,totalCount);
    }
}
