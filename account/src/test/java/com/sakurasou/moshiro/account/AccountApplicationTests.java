package com.sakurasou.moshiro.account;

import com.sakurasou.moshiro.account.mapper.ClientMapper;
import com.sakurasou.moshiro.account.model.Client;
import com.sakurasou.moshiro.account.remote.CommonRemote;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class AccountApplicationTests {
    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private CommonRemote commonService;

    @Test
    public void contextLoads() {
        clientMapper.insert(new Client("2", "sakura", "sakura@ss.com", "nishishui", "nishishui"));
        clientMapper.getAll().forEach(System.out::println);
        log.info("get all clients success");
        Assert.assertEquals("sakura", clientMapper.selectById("20190002").getName());
        clientMapper.deleteById("20190002");
        log.info("del client success");
        clientMapper.getAll().forEach(System.out::println);
        log.info("get all clients success");
    }

    @Test
    public void remoteServiceTest() {
        String tableId = commonService.findSequenceIdByTableName("client").replaceAll("\"", "");
        log.info("get table max id = [{}]", tableId);
    }
}

