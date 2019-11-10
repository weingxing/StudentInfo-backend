package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.User;

import java.util.List;

public interface UserService {
    public boolean addUser(User user);
    public boolean updateUserOpenid(User user);
    public User findUserByOpenid(String openid);
    public User findUserByTid(String tid);
    public boolean deleteUserByTid(String tid);
    public boolean deleteUserByName(String name);
    public boolean resetUserByTid(User user);
    public String getOpenid(String code);
}
