package org.example.springbootdemo.service;


import com.github.pagehelper.PageInfo;
import org.example.springbootdemo.pojo.UserInfo;

import java.util.List;

/**
 * @ClassName UserService
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
public interface UserService {

    PageInfo<UserInfo> getAllUserInfo(int pageNum, int pageSize);
}
