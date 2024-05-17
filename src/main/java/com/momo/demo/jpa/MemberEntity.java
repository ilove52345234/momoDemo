package com.momo.demo.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Entity
@Data
@Table(name = "member" ,indexes = {
        @Index(columnList = "account"),
        @Index(columnList = "name"),
        @Index(columnList = "createdDate")
})
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
public class MemberEntity extends AbstractEntity implements Serializable {

    /**
     * 帳號
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手機
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * email
     */
    private String email;

}
