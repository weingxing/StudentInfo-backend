package com.oxygen.studentinfo.entity;

import java.util.List;

public class PageInfo {
    private int pageCount;
    private List<Info> data;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<Info> getData() {
        return data;
    }

    public void setData(List<Info> data) {
        this.data = data;
    }
}
