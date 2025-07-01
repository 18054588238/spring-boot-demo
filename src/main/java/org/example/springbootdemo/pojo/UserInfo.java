package org.example.springbootdemo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户实体类")
@TableName("user")
public class UserInfo {

    @TableField(exist = false) // 如果数据库表中没有这个字段，这个字段与数据库表字段对不上，加了这个属性，就不会报错
    private Integer a;

    @Schema(description = "id主键")
    private Integer id;
    private String name;
    private Integer age;
    // 接收日期的格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //响应日期的格式
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    private String filename;
    @Schema(description = "文件类型")
    private String filetype;

    public UserInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
