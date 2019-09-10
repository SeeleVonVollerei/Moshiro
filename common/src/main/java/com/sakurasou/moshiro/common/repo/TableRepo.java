package com.sakurasou.moshiro.common.repo;

import com.sakurasou.moshiro.common.model.TableDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TableRepo extends CrudRepository<TableDetail, String> {

    @Query("select tableIdSequence from TableDetail where tableName = :tableName")
    String findSequenceId(String tableName);

}
