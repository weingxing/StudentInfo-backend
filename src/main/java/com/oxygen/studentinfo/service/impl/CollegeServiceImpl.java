package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.CollegeMapper;
import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public boolean addCollege(College college) {
        int res = collegeMapper.insert(college);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteCollegeByID(int id) {
        int res = collegeMapper.deleteByPrimaryKey(id);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteCollegeByName(String name) {
        int res = collegeMapper.deleteByName(name);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updateCollegeNameByID(College college) {
        int res = collegeMapper.updateByPrimaryKey(college);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public List<College> findAll() {
        return collegeMapper.selectAll();
    }

    @Override
    public College findById(int id) {
        return collegeMapper.selectByPrimaryKey(id);
    }
}
