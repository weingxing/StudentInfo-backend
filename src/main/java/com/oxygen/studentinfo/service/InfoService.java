package com.oxygen.studentinfo.service;

import com.oxygen.studentinfo.entity.Info;

import java.util.List;

public interface InfoService {
    public List<Info> findAllInfo();

    public List<Info> findSpecialInfo();

    public List<Info> findInfoByCategory(int categoryId);

    public List<Info> findInfoByKeyword(String keyword);

    public Info findInfoBySid(String sid);

    public boolean updateRemark(Info info);

    public boolean deleteInfoBySid(String sid);

    public boolean addInfo(Info info);

    public boolean deleteInfoByGrade(String grade);

    public boolean updateInfo(Info info);

    public boolean updatePhoneBySid(Info info);

    public List<Info> queryAllInfo(int currPage, int pageSize);

    public List<Info> queryInfoByCategory(int currPage, int pageSize, int categoryId);

    public  List<Info> querySpecialInfo(int currPage, int pageSize);

    public List<Info> queryInfoByKeyword(int currPage, int pageSize, String keyword);

}
