package com.oxygen.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 请求结果类
 * @author oxygen
 * @since 2020/1/25
 */
@Data
@AllArgsConstructor
public class Response {
    private String time;
    private int status;
    private String message;
    private Object Content;
}
