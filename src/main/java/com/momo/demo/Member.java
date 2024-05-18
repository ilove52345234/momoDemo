package com.momo.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;


/**
 * 會員
 */
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
