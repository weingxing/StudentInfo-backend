package com.oxygen.studentinfo.dto;

import lombok.Data;

/**
 * 修改密码时对用户信息进行封装
 * @author oxygen
 * @since 2020/1/25
 */
@Data
public class PasswordChanger {
    private Integer uid;
    private String oldPassword;
    private String password;
}
