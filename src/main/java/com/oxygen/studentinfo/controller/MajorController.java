package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.Major;
import com.oxygen.studentinfo.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Oxygen
 * @data 2019/11/14
 *
 * 专业控制类
 */

@RestController
public class MajorController {
    @Autowired
    private MajorService majorService;

    @Autowired
    private UserController userController;


    @GetMapping("/addMajor")
    public Object addMajor(@RequestParam(value = "majorName")String majorName,
                              @RequestParam(value = "openid")String openid) {
        if(new UserController().access(openid)) {
            Major major = new Major();
            major.setMajorName(majorName);

            if(majorService.addMajor(major))
                return "FINISHED";
            else return "ERROR";

        }
        return "Access Denied";
    }

    @GetMapping("/getAllMajor")
    public Object getAllMajor() {
        return majorService.findAll();
    }

    @GetMapping("/getMajorById")
    public Object getMajorById(@RequestParam(value = "majorId")int majorId) {
        return majorService.findById(majorId);
    }

    @GetMapping("/deleteMajor")
    public Object deleteMajorById(@RequestParam(value = "majorId")int majorId,
                                  @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(majorService.deleteMajorByID(majorId))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/updateMajorName")
    public Object updateMajorName(@RequestParam(value = "majorId")int majorId,
                                  @RequestParam(value = "newName")String newName,
                                  @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            Major major = new Major();
            major.setMajorId(majorId);
            major.setMajorName(newName);

            if(majorService.updateMajorNameByID(major))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }
}
