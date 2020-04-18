package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 实际学生信息类
 * entity包中的Student对应数据库的字段，数据库中班级等信息为外键，存储的是 id 编号
 * 将数据连接查询后封装为这个类，班级等信息为字符串（实际信息，非 id 编号）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {
    private String sno;
    private String name;
    private String sex;
    private String category;
    private String descCategory;
    private String clazz;
    private String department;
    private String major;
    private String college;
    private String phone;
    private String idcard;
    private String address;
    private String remark;
    private String grade;
    private String photo;
}