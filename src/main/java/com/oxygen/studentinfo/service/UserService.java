package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.dto.PasswordChanger;
import com.oxygen.studentinfo.dto.Response;

public interface UserService {
    public Response changePassword(PasswordChanger passwordChanger);
}
