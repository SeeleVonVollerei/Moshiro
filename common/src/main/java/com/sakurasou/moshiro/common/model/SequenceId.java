package com.sakurasou.moshiro.common.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*** 该类用来记录各表的主键,以进行主键的生成.
 * @author clytie
 * @version 0.0.1-SNAPSHOT
 * */

@Entity
@Data
public class SequenceId {
    @Id
    @Column(name = "table_name", length = 100)
    String tableName;
    @Column(name = "table_sequence",length = 100)
    String tableSequence;
}
