package com.momo.demo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基礎抽象類
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class AuditingBase<U extends Serializable> implements Serializable {

    /**
     * id
     */
    @Min(1)
    protected Long id;

    /**
     * 建立時間
     */
    protected LocalDateTime createdDate;

    /**
     * 建立人員
     */
    protected String createdBy;

    /**
     * 最後修改時間
     */
    protected LocalDateTime lastModifiedDate;

    /**
     * 最後修改人員
     */
    protected String lastModifiedBy;
}