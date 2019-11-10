package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String tid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String tid);

    User selectByOpenid(String openid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}