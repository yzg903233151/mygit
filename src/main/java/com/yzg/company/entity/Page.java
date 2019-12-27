package com.yzg.company.entity;

import java.util.List;

/**
 * 泛型(公用的分页类)
 * @author 15274
 *
 * @param <T>
 */
public class Page<T> {
    private int totalCount;//总条数

    private int pageSize=2;//总条数

    private int currentPage;//当前页数计算页

    private int totalPage;//总页数

    private List<T> list;

    private long categoryId;

    private int currentpages;


    public int getCurrentpages() {
        return currentpages;
    }

    public void setCurrentpages(int currentpages) {
        this.currentpages = currentpages;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        if(totalCount%this.pageSize==0) {
            this.totalPage=totalCount/this.pageSize;
        }else {
            this.totalPage=totalCount/this.pageSize+1;
        }
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage=totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
