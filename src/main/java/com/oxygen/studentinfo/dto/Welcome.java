package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 后台首页的 学生人数、教师人数、班级数量等信息的封装类
 * 在登录成功后将这些信息查询后封装，返回供前端调用
 * @author oxygen
 * @since 2020/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Welcome {
    private int studentNum;
    private int teacherNum;
    private int clazzNum;
    private int majorNum;
    private int status;
}
