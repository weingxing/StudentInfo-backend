package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用来进行分页
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private int code;
    private String msg;
    private int count;
    List data;
}
