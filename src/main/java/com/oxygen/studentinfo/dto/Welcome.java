package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
