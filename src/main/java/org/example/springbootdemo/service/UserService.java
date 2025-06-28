package org.example.springbootdemo.service;


import org.example.springbootdemo.pojo.UserInfo;

import java.util.List;

/**
 * @ClassName UserService
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
public interface UserService {

    List<UserInfo> getAllUserInfo();
}
