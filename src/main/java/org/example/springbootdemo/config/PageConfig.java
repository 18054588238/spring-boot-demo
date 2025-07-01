package org.example.springbootdemo.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 配置 mybatis-plus的 分页插件， mybatis-plus自带分页插件 */
@Configuration
public class PageConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor plusInterceptor = new MybatisPlusInterceptor();
//        plusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        PaginationInnerInterceptor p = new PaginationInnerInterceptor();
        p.setOverflow(false);// 设置是否轮回，就是查到最后一条的时候是否需要轮回到第一条
        p.setMaxLimit(500L);// 单页最大数量500
        p.setDbType(DbType.MYSQL);// 设置数据库类型
        plusInterceptor.addInnerInterceptor(p);
        return plusInterceptor;
    }
}
