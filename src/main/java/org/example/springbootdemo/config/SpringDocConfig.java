package org.example.springbootdemo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*配置接口的标题、描述、版本信息等。*/
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI restfulOpenAPI() {
        Info info = new Info()
                .title("Spring Boot Demo")
                .description("测试api")
                .version("1.0");
        return new OpenAPI().info(info);
    }
}
