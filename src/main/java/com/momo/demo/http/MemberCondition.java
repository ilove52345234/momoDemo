package com.momo.demo.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberCondition {

    /**
     * 帳號
     */
    String account;

    /**
     * 姓名
     */
    String name;


    /**
     * 起日
     */
    LocalDate startDate;

    /**
     * 迄日
     */
    LocalDate endDate;


}
