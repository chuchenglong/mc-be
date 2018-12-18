package com.mc.vo;

import java.util.ArrayList;
import java.util.List;

public class PageVo extends BaseVo {
    // 页码
    private int pageNo;
    // 每页大小
    private int pageSize;
    // 从offset开始
    private int offset;
    // 总数量
    private int total;
    // 查询内容
    private List<? extends  Object> rows = new ArrayList<>();

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        if (this.pageNo > 0) {
            return this.pageSize * (this.pageNo - 1);
        }
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<? extends  Object> getRows() {
        return rows;
    }

    public void setRows(List<? extends  Object> rows) {
        this.rows = rows;
    }

    public static PageVo getResult(List<? extends  Object> list, int total) {
        PageVo pageVo = new PageVo();
        pageVo.setTotal(total);
        pageVo.setRows(list);
        return pageVo;
    }
}
