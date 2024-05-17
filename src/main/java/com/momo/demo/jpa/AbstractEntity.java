package com.momo.demo.jpa;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

/**
 * Base class for entity implementations.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public abstract class AbstractEntity<U extends Serializable> implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "pooled")
    @GenericGenerator(name = "pooled", strategy = "org.hibernate.id.enhanced.TableGenerator", parameters = {
            @Parameter(name = "table_name", value = "sequence_pooled"),
            @Parameter(name = "value_column_name", value = "sequence_next_hi_value"),
            @Parameter(name = "prefer_entity_table_as_segment_value", value = "true"),
            @Parameter(name = "optimizer", value = "pooled-lo"),
            @Parameter(name = "initial_value", value = "100001"),
            @Parameter(name = "increment_size", value = "100")})
    @Column(name = "id")
    protected Long id;

    /**
     * 建立時間
     */
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    protected LocalDateTime createdDate;

    /**
     * 建立人員
     */
    @CreatedBy
    @Column(name = "created_by", updatable = false)
    protected String createdBy;

    /**
     * 最後修改時間
     */
    @LastModifiedDate
    @Column(name = "last_modified_date")
    protected LocalDateTime lastModifiedDate;

    /**
     * 最後修改人員
     */
    @LastModifiedBy
    @Column(name = "last_modified_by")
    protected String lastModifiedBy;

    /**
     * 是否刪除
     */
    @Column(name = "deleted")
    protected LocalDateTime deleted;

    /**
     * 資料儲存的版本
     */
    @Version
    @Column(name = "version")
    Long version;
}

