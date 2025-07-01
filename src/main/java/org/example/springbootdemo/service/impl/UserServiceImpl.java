package org.example.springbootdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class UserServiceImpl extends ServiceImpl<UserMapper,UserInfo> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<UserInfo> getAllUserInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserInfo> allUser = userMapper.getAllUser();
//        使用pageinfo包装查询后的结果，交给前端页面
        PageInfo<UserInfo> pageInfo = new PageInfo<>(allUser);
        return pageInfo;
    }
}
