package com.oxygen.studentinfo.controller;

import com.oxygen.studentinfo.entity.ClassRoom;
import com.oxygen.studentinfo.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Oxygen
 * @data 2019/11/14
 *
 * 班级控制类
 */
@RestController
public class ClassController {
    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private UserController userController;

    @GetMapping("/addClass")
    public Object addClass(@RequestParam(value = "calssName")String className,
                           @RequestParam(value = "grade")String grade,
                           @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            ClassRoom classRoom = new ClassRoom();
            classRoom.setClassName(className);
            classRoom.setGrade(grade);

            if(classRoomService.addClassRoom(classRoom))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/getAllClass")
    public Object getAllClass() {
        return classRoomService.findAll();
    }

    @GetMapping("/updateClassName")
    public Object updateClassName(@RequestParam(value = "classId")int classId,
                                  @RequestParam(value = "newName")String newName,
                                  @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            ClassRoom classRoom = new ClassRoom();
            classRoom.setClassId(classId);
            classRoom.setClassName(newName);
            if(classRoomService.updateClassRoomNameByID(classRoom))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/deleteClass")
    public Object deleteClass(@RequestParam(value = "classId")int classId,
                              @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(classRoomService.deleteClassRoomByID(classId))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }

    @GetMapping("/getClassById")
    public Object getClassById(@RequestParam(value = "classId")int classId) {
        return classRoomService.findById(classId);
    }

    @GetMapping("/deleteGrade")
    public Object deleteGrade(@RequestParam(value = "grade")String grade,
                              @RequestParam(value = "openid")String openid) {
        if(userController.access(openid)) {
            if(classRoomService.deleteClassRoomByGrade(grade))
                return "FINISHED";
            else return "ERROR";
        }
        return "Access Denied";
    }
}
