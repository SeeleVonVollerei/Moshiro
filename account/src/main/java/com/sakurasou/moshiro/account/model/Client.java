package com.sakurasou.moshiro.account.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName(value = "client",resultMap = "clientMap")
public class Client {
    @TableId(value = "client_id")
    private String id;
    private String name;
    private String email;
    private String password;
    private String salt;
}
