package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.College;

import java.util.List;

public interface CollegeService {
    public boolean addCollege(College college);
    public boolean deleteCollegeByID(int id);
    public boolean deleteCollegeByName(String name);
    public boolean updateCollegeNameByID(College college);
    public List<College> findAll();
    public College findById(int id);
}
