package com.momo.demo.http;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

/**
 * 會員請求
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class MemberRequest implements Serializable {

    /**
     * id
     */
    Long id;

    /**
     * 帳號
     */
    @NotBlank(message = "帳號不得空白")
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
