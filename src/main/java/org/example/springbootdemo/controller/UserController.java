package org.example.springbootdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdemo.pojo.UserInfo;
import org.example.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @ClassName UserController
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @RequestMapping("/getAllUser")
    public List<UserInfo> getAllUser() {
        return userService.getAllUserInfo();
    }

}
