package com.oxygen.studentinfo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

/**
 * @author Oxygen
 * @data 2019/11/8
 */
public class WechatUtil {

    /**
     * 发送GET请求到指定url
     * @param url
     * @return String
     */
    public  String sendGet(String url) {
        String result = null;
        BufferedReader in = null;
        try {
            String full_url = url;

            //请求微信服务器，获取openid
            java.net.URL connURL = new java.net.URL(full_url);
            URLConnection urlConnection = connURL.openConnection();
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) urlConnection;
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            httpConn.connect();

            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     *  获取微信小程序openid
     * @param code
     * @return String JSON格式字符串
     */
    public String getOpenid(String code) {
        final String APP_ID = "xxxxxxxxx";
        final String SECRET = "xxxxxxxx";

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID + "&secret=" +
                SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        return sendGet(url);
    }

    // 简单测试
    public static void main(String[] args) {
        System.out.printf(new WechatUtil().getOpenid("123456"));
    }
}
