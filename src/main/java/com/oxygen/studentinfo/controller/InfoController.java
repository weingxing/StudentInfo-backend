package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.Info;
import com.oxygen.studentinfo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import com.oxygen.studentinfo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InfoController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private UserService userService;


    private boolean isAccess(String openid) {
        return userService.findUserByOpenid(openid) != null;
    }
    @GetMapping("/search")
    public Object search(@RequestParam(value = "keyword")String keyword, @RequestParam(value = "openid")String openid) {
        if (isAccess(openid)) {
            return infoService.findInfoByKeyword('%' + keyword + '%');
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
        info.setPhoto("https://mapletown.xyz/stuphoto/" + sid + ".jpg");

        if (isAccess(openid)) {
            if (infoService.addInfo(info))
                return "FINISHED";
            else
                return "ERROR";
        } else {
            return "Access Denied";
        }
    }


    @GetMapping("/getAllInfo")
    public Object getAllInfo(@RequestParam(value = "openid")String openid) {
        if (isAccess(openid))
            return infoService.findAllInfo();
        else
            return "Access Denied";
    }

    @GetMapping("/getInfoByCategory")
    public Object getInfoByCategory(@RequestParam(value = "categoryId")int categoryId,
                                    @RequestParam(value = "openid")String openid) {
        if (isAccess(openid)) {
           return infoService.findInfoByCategory(categoryId);
        } else {
            return "Access Denied";
        }
    }

    @GetMapping("/getSpecialInfo")
    public Object getSpecialInfo(@RequestParam(value = "openid")String openid) {
        if (isAccess(openid)) {
            return infoService.findSpecialInfo();
        } else {
            return "Access Denied";
        }
    }

    @PostMapping("/updateRemark")
    public Object updateRemark(@RequestParam(value = "sid")String sid,
                               @RequestParam(value = "remark")String remark,
                               @RequestParam(value = "openid")String openid) {
        if (isAccess(openid)) {
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

    @GetMapping("/access")
    public Object access(@RequestParam(value = "openid")String openid) {
        return isAccess(openid);
    }



}
