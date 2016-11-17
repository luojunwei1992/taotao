package com.taotao.pojo;

import java.util.List;

/**
 * Created by comma on 16/11/17.
 */
public class EasyUIResult {

    private  Long total;

    private List<?> rows;

    public Long getTotal() {
        return total;
    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
