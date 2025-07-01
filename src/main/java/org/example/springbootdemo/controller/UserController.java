package org.example.springbootdemo.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.springbootdemo.pojo.UserInfo;
import org.example.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @ClassName UserController
 * @Author liupanpan
 * @Date 2025/6/17
 * @Description
 */
@Controller
@RequiredArgsConstructor
@Tag(name = "用户管理模块",description = "提供对用户信息的一些操作接口")
public class UserController {

    private final UserService userService;


    @RequestMapping("/getAllUser")
    @ResponseBody
    @Parameters({
            @Parameter(name = "pageNum",description = "页数",required = true),
            @Parameter(name = "pageSize",description = "页码",required = true)
    })
    @Operation(summary = "查询用户信息")
    public PageInfo<UserInfo> getAllUser(int pageNum, int pageSize) {
        System.out.println("热部署测试！");
        return userService.getAllUserInfo(pageNum,pageSize);
    }
    @RequestMapping("/test01")
    public String test01(HttpServletRequest request) {
        request.setAttribute("msg1","msg1");
        request.setAttribute("msg3",100);
        request.setAttribute("msg4",new UserInfo("jack",18));
        request.setAttribute("date",new Date());
        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("yyqx",24));
        userInfos.add(new UserInfo("yyqx1",24));
        userInfos.add(new UserInfo("yyqx2",24));
        request.setAttribute("userInfos",userInfos);

        request.getSession().setAttribute("session","session");
        request.getSession().getServletContext().setAttribute("application","application");

        return "test01";
    }

    // 接收前端传过来的id，thymeleaf
    @RequestMapping("/test02")
    public String test02(int id) {
        System.out.println("id="+id);
        return "xxxx";
    }

    @RequestMapping("/freemarkerTest")
    public String freemarkerTest(HttpServletRequest request){
        request.setAttribute("msg1","freemarkerTest");
        return "freemarker";
    }

    @RequestMapping("/errorTest")
    public String errorTest() {
        int a = 1/0;
        return "test01";
    }
/*    // 处理异常--出现算数异常时进行以下处理（局部，只对当前控制单元生效）
    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public String myExceptionHandler() {
        System.out.println("异常处理逻辑代码--局部");
        return "error";
    }*/

}
