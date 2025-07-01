package org.example.springbootdemo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.example.springbootdemo.mapper.UserMapper;
import org.example.springbootdemo.pojo.UserInfo;

import java.util.List;

/**
 * @ClassName UserService
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
public interface UserService extends IService<UserInfo> {

    PageInfo<UserInfo> getAllUserInfo(int pageNum, int pageSize);
}
