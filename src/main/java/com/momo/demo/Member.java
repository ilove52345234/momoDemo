package com.momo.demo;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)

public class Member extends AuditingBase<String> implements Serializable {


    /**
     * id
     */
    Long id;

    /**
     * 帳號
     */
    String account;

    /**
     * 姓名
     */
    String name;

    /**
     * 手機
     */
    String phone;

    /**
     * 地址
     */
    String address;

    /**
     * email
     */
    String email;

}
