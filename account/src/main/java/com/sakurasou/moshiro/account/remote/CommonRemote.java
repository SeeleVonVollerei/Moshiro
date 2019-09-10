package com.sakurasou.moshiro.account.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "common-service")
public interface CommonRemote {
    @GetMapping("/tableDetails/search/findSequenceId")
    String findSequenceIdByTableName(@RequestParam("tableName") String tableName);

    @GetMapping("/tableDetails/search/updateSequenceId")
    String updateSequenceIdByTableName(@RequestParam("tableName") String tableName, @RequestParam("sequenceId") String sequenceId);
}
