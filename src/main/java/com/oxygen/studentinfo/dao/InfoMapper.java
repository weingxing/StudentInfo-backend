package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Info;

import java.util.List;

public interface InfoMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

    List<Info> selectAll();

    List<Info> selectByCategoryId(int categoryId);

    List<Info> selectByKeyword(String keyword);

    List<Info> selectSpecial();
}