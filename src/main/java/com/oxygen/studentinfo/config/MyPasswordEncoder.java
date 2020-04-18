package com.oxygen.studentinfo.config;

import com.oxygen.studentinfo.util.RSAUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * SpringSecurity 密码编码配置类
 * @author oxygen
 * @since 2020/03/12
 */
public class MyPasswordEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    // 对密码进行编码
    public String encode(CharSequence charSequence) {
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        // RSA加密私钥
        String privateKey = RSAKey.privateKey;
        // 对前端传来的通过RSA加密的密码解密
        charSequence = RSAUtil.decrypt(privateKey, charSequence.toString());
        // 返回匹配结果
        return encoder.matches(charSequence, s);
    }
}
