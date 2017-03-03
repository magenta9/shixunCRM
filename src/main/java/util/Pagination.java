package util;

import java.util.List;
/*
*
* 分页查询组件
* 不同的实体通过继承设置具体的泛型类
* */
public abstract class Pagination<T> {

	protected int currentPage; //当前页或请求的页 从1开始
	protected int pageSize; //pageSize为请求分页的每页显示数量
	protected int totalPages; //所要查询行数按当前pageSize应该的页数
	protected int totalCount; //全部行数
	protected List<T> items;

	public Pagination() {
		super();
	}

	public Pagination(int currentPage, int pageSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalPages() {
		return totalPages;
	}


	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public void countTotalPageNum(){
		if(items.size() == 0){
			setTotalPages(0);
		}else{
			if(totalCount % pageSize == 0)
				setTotalPages(totalCount / pageSize);
			else
				setTotalPages(totalCount / pageSize +1);
		}
	}

}
