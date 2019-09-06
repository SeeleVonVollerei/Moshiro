package com.sakurasou.moshiro.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Client {
    private String id;
    @NotBlank(message = "客户名不能为空")
    private String name;
    @Email(message = "请输入正确的邮箱地址")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    private String password;
    private String salt;
}
