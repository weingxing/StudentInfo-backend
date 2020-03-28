package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.UserMapper;
import com.oxygen.studentinfo.dto.PasswordChanger;
import com.oxygen.studentinfo.dto.Response;
import com.oxygen.studentinfo.entity.User;
import com.oxygen.studentinfo.service.UserService;
import com.oxygen.studentinfo.config.RSAKey;
import com.oxygen.studentinfo.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Response changePassword(PasswordChanger passwordChanger) {
        User user = new User();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // 解密前端传来来的RSA密文，取得密码的明文
        String oldPassword = RSAUtil.decrypt(RSAKey.privateKey, passwordChanger.getOldPassword());
        String password = RSAUtil.decrypt(RSAKey.privateKey, passwordChanger.getPassword());
        user.setUid(passwordChanger.getUid());
        // 密码明文经过BCrypt加密封装到user
        user.setPassword(encoder.encode(password));
        // 验证旧密码
        if (encoder.matches(oldPassword,
                userMapper.selectByPrimaryKey(passwordChanger.getUid()).getPassword())) {
            // 更新数据库
            if (userMapper.updateByPrimaryKeySelective(user) > 0)
                return new Response(new Date().toString(), 1, "修改成功", null);
        }

        return new Response(new Date().toString(), 0, "修改失败", null);
    }
}
