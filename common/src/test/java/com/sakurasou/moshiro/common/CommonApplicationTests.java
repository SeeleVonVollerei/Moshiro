package com.sakurasou.moshiro.common;

import com.sakurasou.moshiro.common.model.SequenceId;
import com.sakurasou.moshiro.common.repo.SequenceRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {
    @Autowired
    SequenceRepo sequenceRepo;

    @Test
    public void contextLoads() {
        SequenceId sequenceId = new SequenceId();
        sequenceId.setTableName("hello");
        sequenceId.setTableSequence("nihao");
        sequenceRepo.save(sequenceId);
        System.out.println(sequenceRepo.findSequenceId("hello"));
        sequenceRepo.delete(sequenceId);
    }

}
