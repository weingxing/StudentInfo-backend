package com.oxygen.studentinfo.dto;

import lombok.Data;

@Data
public class PasswordChanger {
    private Integer uid;
    private String oldPassword;
    private String password;
}
