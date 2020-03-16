package com.oxygen.studentinfo.dao;

import com.oxygen.studentinfo.dto.StudentInfo;
import com.oxygen.studentinfo.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    int deleteByPrimaryKey(String sno);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sno);

    List<Student> selectAll();

    List<StudentInfo> selectAllByPage(Map<String, Object> param);

    List<StudentInfo> selectByGrade(Map<String, Object> param);

    List<StudentInfo> selectByClazz(Map<String, Object> param);

    List<StudentInfo> search(String keyword);

    List<StudentInfo> selectAllByClazz(Integer clazz);

    List<StudentInfo> selectAllByGrade(String grade);

    List<StudentInfo> searchByPage(Map<String, Object> param);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}