package com.oxygen.studentinfo.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PageParam {
    private Map<String, Object> data;

    public PageParam() {
        data = new HashMap<>();
    }

    public PageParam(int currPage, int pageSize) {
        data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
    }

    public Object put(String key, Object value) {
        return data.put(key, value);
    }
}
