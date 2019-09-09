package com.sakurasou.moshiro.common.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*** 该类用来记录各表的结构信息.
 * @author clytie
 * @version 0.0.1-SNAPSHOT
 * */

@Data
@Entity
@Table(name = "table_detail")
public class TableDetail {
    @Id
    @Column(name = "table_name", length = 100)
    String tableName;
    @Column(name = "table_id_sequence",length = 100)
    String tableIdSequence;
}

