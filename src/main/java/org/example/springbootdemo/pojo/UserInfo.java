package org.example.springbootdemo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;
    private String name;
    private Integer age;
    // 接收日期的格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //响应日期的格式
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String filename;
    private String filetype;

    public UserInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
