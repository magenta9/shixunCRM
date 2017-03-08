package entity;

import util.Pagination;

/**
 * Created by magenta9 on 2017/3/7.
 */
public class OrderFormItemPagination extends Pagination<OrderFormItem> {
    public OrderFormItemPagination(int currentPage, int pageSize, int totalCount){
        super(currentPage,pageSize,totalCount);
    }
}
