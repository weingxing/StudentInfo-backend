package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.Major;

public interface MajorService {
    public boolean addMajor(Major major);
    public boolean deleteMajorByID(int id);
    public boolean deleteMajorByName(String name);
    public boolean  updateMajorNameByID(Major major);
}
