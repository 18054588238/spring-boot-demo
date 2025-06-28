package org.example.springbootdemo.service.impl;

import org.example.springbootdemo.mapper.UserMapper;
import org.example.springbootdemo.pojo.UserInfo;
import org.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> getAllUserInfo() {
        return userMapper.getAllUser();
    }
}
