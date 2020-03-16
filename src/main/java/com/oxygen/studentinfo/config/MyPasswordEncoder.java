package com.oxygen.studentinfo.config;

import com.oxygen.studentinfo.util.RSAUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String encode(CharSequence charSequence) {
//        System.out.println("encode   "+charSequence);
        return encoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String privateKey = RSAKey.privateKey;

//        System.out.println(charSequence);
        charSequence = RSAUtil.decrypt(privateKey, charSequence.toString());
//        System.out.println(charSequence);
        return encoder.matches(charSequence, s);
    }
}
