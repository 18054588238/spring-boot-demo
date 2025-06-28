package org.example.springbootdemo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.springbootdemo.pojo.UserInfo;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
@Mapper
public interface UserMapper {

    List<UserInfo> getAllUser();
}
