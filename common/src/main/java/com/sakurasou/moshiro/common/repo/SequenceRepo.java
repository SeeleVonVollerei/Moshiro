package com.sakurasou.moshiro.common.repo;

import com.sakurasou.moshiro.common.model.SequenceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "sequence")
public interface SequenceRepo extends JpaRepository<SequenceId, String> {
    @Override
    List<SequenceId> findAll();

    @Query("select tableSequence from SequenceId where tableName = :tableName")
    String findSequenceId(String tableName);

}
