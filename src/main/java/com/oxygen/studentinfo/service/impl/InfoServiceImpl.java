package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.InfoMapper;
import com.oxygen.studentinfo.entity.Info;
import com.oxygen.studentinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoMapper infoMapper;


    @Override
    public List<Info> findAllInfo() {
        return infoMapper.selectAll();
    }

    @Override
    public List<Info> findInfoByCategory(int categoryID) {
        return infoMapper.selectByCategoryId(categoryID);
    }

    @Override
    public List<Info> findInfoByKeyword(String keyword) {
        return infoMapper.selectByKeyword(keyword);
    }

    @Override
    public boolean updateRemark(Info info) {
        int res = infoMapper.updateByPrimaryKey(info);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean addInfo(Info info) {
        int res = infoMapper.insert(info);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteInfoBySid(String sid) {
        int res = infoMapper.deleteByPrimaryKey(sid);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean deleteInfoByGrade(String grade) {
//        boolean res = classRoomService.deleteClassRoomByGrade(grade);
//
//        if (res)
//            return true;
        return false;
    }

    @Override
    public boolean updateInfo(Info info) {
        int res = infoMapper.updateByPrimaryKey(info);

        if(res >= 1)
            return true;
        return false;
    }

    @Override
    public boolean updatePhoneBySid(Info info) {
        int res = infoMapper.updateByPrimaryKey(info);

        if (res >= 1)
            return true;
        return false;
    }

    @Override
    public Info findInfoBySid(String sid) {
        return infoMapper.selectByPrimaryKey(sid);
    }

    @Override
    public List<Info> findSpecialInfo() {
        return infoMapper.selectSpecial();
    }
}
