package org.example.springbootdemo;

import jakarta.annotation.Resource;
import org.example.springbootdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }

}
