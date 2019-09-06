package com.sakurasou.moshiro.account.mapper;

import com.sakurasou.moshiro.account.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMapper {
    boolean create(Client client);

    boolean delById(String id);

    boolean updateByEmail(String email);

    List<Client> getAll();

    Client getByEmail(String email);

}
