package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.MajorMapper;
import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorMapper majorMapper;
    @Override
    public boolean addMajor(Major major) {
        int res = majorMapper.insert(major);

        if(res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteMajorByID(int id) {
        int res = majorMapper.deleteByPrimaryKey(id);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteMajorByName(String name) {
        int res = majorMapper.deleteByName(name);

        if(res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updateMajorNameByID(Major major) {
        int res = majorMapper.updateByPrimaryKey(major);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public List<Major> findAll() {
        return majorMapper.selectAll();
    }

    @Override
    public Major findById(int id) {
        return majorMapper.selectByPrimaryKey(id);
    }
}
