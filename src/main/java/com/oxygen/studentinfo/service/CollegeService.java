package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.College;

public interface CollegeService {
    public boolean addCollege(College college);
    public boolean deleteCollegeByID(int id);
    public boolean deleteCollegeByName(String name);
    public boolean updateCollegeNameByID(College college);
}
