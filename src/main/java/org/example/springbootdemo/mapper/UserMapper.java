package org.example.springbootdemo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<UserInfo> {

    List<UserInfo> getAllUser();
}
