package com.oxygen.studentinfo.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 分页请求封装类（放在dto包中更合适？）
 * @author oxygen
 * @since 2020/01/28
 */
@Data
public class PageParam {
    private Map<String, Object> data;

    public PageParam() {
        data = new HashMap<>();
    }

    public PageParam(int currPage, int pageSize) {
        data = new HashMap<>();
        // 当前是第几页
        data.put("currIndex", (currPage-1)*pageSize);
        // 一页有几条数据
        data.put("pageSize", pageSize);
    }

    public Object put(String key, Object value) {
        return data.put(key, value);
    }
}
