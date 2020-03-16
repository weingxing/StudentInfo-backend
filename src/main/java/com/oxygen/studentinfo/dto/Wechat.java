package com.oxygen.studentinfo.dto;

import lombok.Data;

/**
 * 微信openid封装类
 * @author oxygen
 * @since 2019/11/8
 */
@Data
public class Wechat {
    private String session_key = null;
    private String openid = null;
}
