package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 教师信息，同StudentInfo
 * @author oxygen
 * @since 2020/1/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherInfo {
    private String tno;
    private String name;
    private String clazz;
    private String openid;
}
