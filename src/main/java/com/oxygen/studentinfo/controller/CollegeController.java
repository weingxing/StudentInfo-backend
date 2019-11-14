package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.College;
import com.oxygen.studentinfo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Oxygen
 * @data 2019/11/14
 *
 * 学院控制类
 */

@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @Autowired
    private UserController userController;


    @GetMapping("/addCollege")
    public Object addCollege(@RequestParam(value = "collegeName")String collegeName,
                              @RequestParam(value = "openid")String openid) {
        if(new UserController().access(openid)) {
            College college = new College();
            college.setCollegeName(collegeName);

            if(collegeService.addCollege(college))
                return "FINISHED";
            else return "ERROR";

        }
        return "Access Denied";
    }

    @GetMapping("/getAllCollege")
    public Object getAllCollege() {
        return collegeService.findAll();
    }

    @GetMapping("/getCollegeById")
    public Object getCollegeById(@RequestParam(value = "collegeId")int collegeId) {
        return collegeService.findById(collegeId);
    }

    @GetMapping("/deleteCollege")
    public Object deleteCollege(@RequestParam(value = "collegeId")int categoryId,
                                @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(collegeService.deleteCollegeByID(categoryId))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/updateCollegeName")
    public Object updateCollegeName(@RequestParam(value = "collegeId")int collegeId,
                                    @RequestParam(value = "newName")String newName,
                                    @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            College college = new College();
            college.setCollegeId(collegeId);
            college.setCollegeName(newName);

            if(collegeService.updateCollegeNameByID(college))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }
}
