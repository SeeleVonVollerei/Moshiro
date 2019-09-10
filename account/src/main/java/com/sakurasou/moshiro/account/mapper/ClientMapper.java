package com.sakurasou.moshiro.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sakurasou.moshiro.account.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMapper extends BaseMapper<Client> {
    List<Client> getAll();
}
