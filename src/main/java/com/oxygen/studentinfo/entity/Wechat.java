package com.oxygen.studentinfo.entity;

public class Wechat {
    private String session_key = null;
    private String openid = null;

    public String getOpenid() {
        return this.openid;
    }

    public String getSession_key() {
        return this.session_key;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
