package com.sakurasou.moshiro.account;

import com.sakurasou.moshiro.account.mapper.ClientMapper;
import com.sakurasou.moshiro.account.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AccountApplicationTests {
    @Autowired
    ClientMapper clientMapper;
    @Test
    public void contextLoads() {
        clientMapper.create(new Client("2","sakura","sakura@ss.com","nishishui","nishishui"));
        clientMapper.getAll().forEach(System.out::println);
        log.info("get all clients success");
        clientMapper.delById("2");
        log.info("del client success");
        clientMapper.getAll().forEach(System.out::println);
        log.info("get all clients success");
    }
}
