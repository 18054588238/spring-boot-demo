package org.example.springbootdemo;

import jakarta.annotation.Resource;
import org.example.springbootdemo.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*测试controller层接口方法*/
@SpringBootTest
@AutoConfigureMockMvc//测试controller层需要mockmvc环境
class SpringBootDemoApplicationTests {

    @Resource
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MockMvcBuilderSupport mockMvcBuilderSupport;

    @Test
    void contextLoads() throws Exception {
//        构建请求
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getAllUser?pageNum=2&pageSize=2")
                .accept(MediaType.APPLICATION_JSON);//指定请求的accept头信息
        // 发送请求，获取请求结果
        ResultActions perform = mockMvc.perform(requestBuilder);
        perform.andExpect(MockMvcResultMatchers.status().isOk());// 校验请求结果
        MvcResult mvcResult = perform.andReturn();// 返回执行结果
        MockHttpServletResponse response = mvcResult.getResponse();//得到执行后的响应
        System.out.println(response.getStatus());
        System.out.println(response.getContentAsString());
    }
    @BeforeEach
    public void before(WebApplicationContext  context) {
        System.out.println("单元测试开始");
        // 全局拦截
        //创建mockMvc，增加filter----防止响应内容中文乱码
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .addFilter((request,response,chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request,response);
                },"/*")
                .build();
    }

    @AfterEach
    public void after() {
        System.out.println("单元测试结束");
    }

}
