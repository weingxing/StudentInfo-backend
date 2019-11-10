package com.oxygen.studentinfo.service.impl;

import cn.miludeer.jsoncode.JsonCode;
import com.oxygen.studentinfo.dao.UserMapper;
import com.oxygen.studentinfo.entity.User;
import com.oxygen.studentinfo.service.UserService;
import com.oxygen.studentinfo.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        int res = userMapper.insert(user);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updateUserOpenid(User user) {
        int res = userMapper.updateByPrimaryKey(user);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public User findUserByTid(String tid) {
        return userMapper.selectByPrimaryKey(tid);
    }

    @Override
    public User findUserByOpenid(String openid) {
        return userMapper.selectByOpenid(openid);
    }

    @Override
    public boolean deleteUserByTid(String tid) {
        int res = userMapper.deleteByPrimaryKey(tid);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteUserByName(String name) {
        return false;
    }

    @Override
    public boolean resetUserByTid(User user) {
        int res = userMapper.updateByPrimaryKey(user);

        if (res >= 1)
            return true;
        return false;
    }

    public String getOpenid(String code) {
        String requestRes = new WechatUtil().getOpenid(code);
        if (requestRes.contains("openid")) {
            return JsonCode.getValue(requestRes, "$.openid");
        } else {
            return "ERROR";
        }
    }
}
