package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    Department selectByName(String name);

    List<Department> selectAll();

    List<Department> selectAllByPage(Map<String, Object> param);

    List<Department> search(String key);

    List<Department> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}