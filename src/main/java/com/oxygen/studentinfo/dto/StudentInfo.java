package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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