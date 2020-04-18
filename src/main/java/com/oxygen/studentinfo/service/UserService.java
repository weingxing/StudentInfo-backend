package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.PasswordChanger;
import com.oxygen.studentinfo.dto.Response;

/**
 * 用户（后台）服务接口
 * @author oxygen
 * @since 2020/01/28
 */
public interface UserService {
    /**
     * 修改登录密码
     * @param passwordChanger
     * @return
     */
    public Response changePassword(PasswordChanger passwordChanger);
}
