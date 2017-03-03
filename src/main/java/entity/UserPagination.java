package entity;

import util.Pagination;

/**
 * Created by alienware on 2017/3/1.
 * 会员分压查询显示页
 */
public class UserPagination extends Pagination<User> {
    public UserPagination(int currentPage,int pageSize,int totalCount){
        super(currentPage,pageSize,totalCount);
    }
}
