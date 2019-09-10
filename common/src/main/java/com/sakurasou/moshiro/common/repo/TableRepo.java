package com.sakurasou.moshiro.common.repo;

import com.sakurasou.moshiro.common.model.TableDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource
@Transactional
public interface TableRepo extends CrudRepository<TableDetail, String> {

    @Query("select tableIdSequence from TableDetail where tableName = :tableName")
    String findSequenceId(String tableName);

    @Modifying
    @Query("update TableDetail set tableIdSequence=:sequenceId where tableName=:tableName")
    int updateSequenceId(String tableName, String sequenceId);
}
