package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.Status;

/**
 * 小程序审核状态服务类
 * @author oxygen
 * @since 2020/03/16
 */
// 通过设置状态，小程序根据状态来显示内容（屏蔽一些信息以通过小程序审核，审核后再将信息显示）
// 该操作违反了小程序规范，存在一定风险
public interface StatusService {
    /**
     * 更新状态
     * @param record
     * @return
     */
    public Response update(Status record) throws Exception;

    /**
     * 查询状态
     * @return
     */
    public Response getStatus() throws Exception;

    /**
     * 查询状态码
     * @return
     */
    public int getStatusCode() throws Exception;

}
