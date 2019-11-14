package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.InfoMapper;
import com.oxygen.studentinfo.entity.Info;
import com.oxygen.studentinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Info> queryAllInfo(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return infoMapper.queryAllInfo(data);
    }

    @Override
    public List<Info> queryInfoByCategory(int currPage, int pageSize, int categoryId) {
        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        data.put("categoryId", categoryId);
        return infoMapper.queryInfoByCategoryId(data);
    }

    @Override
    public List<Info> querySpecialInfo(int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return infoMapper.querySpecialInfo(data);
    }

    @Override
    public List<Info> queryInfoByKeyword(int currPage, int pageSize, String keyword) {
        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        data.put("keyword", keyword);
        return infoMapper.queryInfoByKeyword(data);
    }

}
