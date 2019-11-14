package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.Info;
import com.oxygen.studentinfo.entity.PageInfo;
import com.oxygen.studentinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Oxygen
 * @data 2019/11/10
 *
 * 学生信息控制类
 */

@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserController userController;


    @GetMapping("/search")
    public Object search(@RequestParam(value = "keyword")String keyword,
                         @RequestParam(value = "openid")String openid,
                         @RequestParam(value = "pageSize")int pageSize) {
        if (userController.access(openid)) {
            List<Info> data = infoService.findInfoByKeyword('%' + keyword + '%');
            PageInfo pageInfo = new PageInfo();
            pageInfo.setData(data);
            pageInfo.setPageCount(infoService.findInfoByKeyword(keyword).size() / pageSize + 1);
            return pageInfo;
        } else {
            return "Access Denied";
        }
    }

    @PostMapping("/addInfo")
    public Object addInfo(
            @RequestParam(value = "sid")String sid,
            @RequestParam(value = "sname")String sname,
            @RequestParam(value = "sex")String sex,
            @RequestParam(value = "classId")String classId,
            @RequestParam(value = "collegeId")String collegeId,
            @RequestParam(value = "majorId")String majorId,
            @RequestParam(value = "categoryId")String categoryId,
            @RequestParam(value = "address")String address,
            @RequestParam(value = "idcard")String idcard,
            @RequestParam(value = "grade")String grade,
            @RequestParam(value = "phone")String phone,
            @RequestParam(value = "remark")String remark,
            @RequestParam(value = "photoAddress")String photoAddress,
            @RequestParam(value = "openid")String openid) {

        Info info = new Info();
        info.setSid(sid);
        info.setSname(sname);
        info.setSex(sex);
        try {
            info.setClassId(Integer.parseInt(classId));
            info.setCollegeId(Integer.parseInt(collegeId));
            info.setMajorId(Integer.parseInt(majorId));
            info.setCategoryId(Integer.parseInt(categoryId));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        info.setAddress(address);
        info.setIdcard(idcard);
        info.setGrade(grade);
        info.setPhone(phone);
        info.setRemark(remark);
        // 多添加一个“/”，防止插入数据时主地址后忘记加“/”导致图片地址 404
        // 例如：https://baidu.com/1.jpg   https://baidu.com1.jpg
        // https://baidu.com//1.jpg 等价 https://baidu.com/1.jpg
        info.setPhoto(photoAddress + "/" + sid + ".jpg");

        if (userController.access(openid)) {
            if (infoService.addInfo(info))
                return "FINISHED";
            else
                return "ERROR";
        } else {
            return "Access Denied";
        }
    }


    @GetMapping("/getAllInfo")
    public Object getAllInfo(@RequestParam(value = "currPage")int currPage,
                                    @RequestParam(value = "pageSize")int pageSize,
                                    @RequestParam(value = "openid")String openid) {
        if (userController.access(openid)) {
            List<Info> data = infoService.queryAllInfo(currPage, pageSize);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setData(data);
            pageInfo.setPageCount(infoService.findAllInfo().size() / pageSize + 1);
            return pageInfo;
        }
        else
            return "Access Denied";
    }

    @GetMapping("/getInfoByCategory")
    public Object queryInfoByCategory(@RequestParam(value = "currPage")int currPage,
                                    @RequestParam(value = "pageSize")int pageSize,
                                    @RequestParam(value = "categoryId")int categoryId,
                                    @RequestParam(value = "openid")String openid) {

        if (userController.access(openid)) {
            List<Info> data = infoService.queryInfoByCategory(currPage, pageSize, categoryId);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setData(data);
            pageInfo.setPageCount(infoService.findInfoByCategory(categoryId).size() / pageSize + 1);
            return pageInfo;
        }
        else
            return "Access Denied";
    }


    @GetMapping("/getSpecialInfo")
    public Object querySpecialInfo(@RequestParam(value = "currPage")int currPage,
                                      @RequestParam(value = "pageSize")int pageSize,
                                      @RequestParam(value = "openid")String openid) {

        if (userController.access(openid)) {
            List<Info> data = infoService.querySpecialInfo(currPage, pageSize);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setData(data);
            pageInfo.setPageCount(infoService.findSpecialInfo().size() / pageSize + 1);
            return pageInfo;
        }
        else
            return "Access Denied";
    }

    @PostMapping("/updateRemark")
    public Object updateRemark(@RequestParam(value = "sid")String sid,
                               @RequestParam(value = "remark")String remark,
                               @RequestParam(value = "openid")String openid) {
        if (userController.access(openid)) {
            Info info = infoService.findInfoBySid(sid);
            info.setRemark(remark);
            if(infoService.updateRemark(info))
                return "FINISHED";
            else
                return "ERROR";
        } else {
            return "Access Denied";
        }
    }

    @GetMapping("/deleteInfo")
    public Object deleteInfo(@RequestParam(value = "sid")String sid,
                             @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(infoService.deleteInfoBySid(sid))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/updatePhone")
    public Object updatePhone(@RequestParam(value = "sid")String sid,
                              @RequestParam(value = "phone")String phone,
                              @RequestParam(value = "openid")String openid){
        if(userController.access(openid)) {
            Info info = infoService.findInfoBySid(sid);
            info.setPhone(phone);
            if(infoService.updateInfo(info))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/updateCategory")
    public Object updateCategory(@RequestParam(value = "sid")String sid,
                                 @RequestParam(value = "categoryId")int categoryId,
                                 @RequestParam(value = "openid")String openid){
        if(userController.access(openid)) {
            Info info = infoService.findInfoBySid(sid);
            info.setCategoryId(categoryId);
            if(infoService.updateInfo(info))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";

    }

    @GetMapping("/updateAddress")
    public Object updateAddress(@RequestParam(value = "sid")String sid,
                                @RequestParam(value = "address")String address,
                                @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            Info info = infoService.findInfoBySid(sid);
            info.setAddress(address);
            if(infoService.updateInfo(info))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

}
