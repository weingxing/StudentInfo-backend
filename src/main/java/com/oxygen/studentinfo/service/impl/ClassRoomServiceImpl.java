package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.ClassRoomMapper;
import com.oxygen.studentinfo.entity.ClassRoom;
import com.oxygen.studentinfo.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassRoomMapper classRoomMapper;

    @Override
    public boolean addClassRoom(ClassRoom classroom) {
        int res = classRoomMapper.insert(classroom);

        if(res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteClassRoomByID(int id) {
        int res = classRoomMapper.deleteByPrimaryKey(id);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteClassRoomByName(String name) {
        int res = classRoomMapper.deleteByName(name);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteClassRoomByGrade(String grade) {
        int res = classRoomMapper.deleteByGrade(grade);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updateClassRoomNameByID(ClassRoom classRoom) {
        int res = classRoomMapper.updateByPrimaryKey(classRoom);

        if (res >= 1)
            return true;
        return false;
    }
}
