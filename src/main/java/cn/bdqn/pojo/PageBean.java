package cn.bdqn.pojo;

import java.util.List;

public class PageBean<T>{
    // 总页数
    private int totalPageCount;
    // 页面大小，即每页显示记录数
    private int pageSize;
    // 记录总数
    private int totalCount;
    // 当前页码
    private int currPageNo;
    // 每页新闻集合
    private List<T> lists;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
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

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
