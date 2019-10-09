package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class U {
    /**
     * 用户名
     */
    @TableId
    @NotBlank(message = "Cant be empty!")
    private String username;
    /**
     * 密码
     */
    @NotNull(message = "Cant be empty!")
    private String password;
    /**
     * 邮箱
     */
    @NotBlank
//    @Pattern(regexp = "")
    private String email;

}
