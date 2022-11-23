package com.tony.austin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 发送ID类型枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum IdType {
    USER_ID(10, "userId"),
    PHONE(30, "phone"),
    EMAIL(50, "email"),


    ;

    private Integer code;
    private String description;


}
