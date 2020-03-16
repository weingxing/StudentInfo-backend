package com.oxygen.studentinfo.service.impl;

import com.oxygen.studentinfo.dao.UserMapper;
import com.oxygen.studentinfo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // User重名，必须写全包名加以区分
        com.oxygen.studentinfo.entity.User user = userMapper.selectByUsername(s);
        UserDetails userDetails = null;

        // 如果用户不存在，抛出去异常，存在则构建userDetails
        if (user == null)
            throw new UsernameNotFoundException("用户不存在");
        else {
            userDetails = User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .authorities("admin").build();
        }

        return userDetails;
    }

    @Override
    public com.oxygen.studentinfo.entity.User getUserInfo() throws ClassCastException {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        UserDetails details = null;
        if (principal instanceof UserDetails)
            details = (UserDetails) principal;
        com.oxygen.studentinfo.entity.User user = userMapper.selectByUsername(details.getUsername());
        // 将用户信息返回前清空密码，防止密码泄露
        user.setPassword(null);
        return user;
    }
}
