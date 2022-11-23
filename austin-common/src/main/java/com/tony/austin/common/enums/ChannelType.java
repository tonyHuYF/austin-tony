package com.tony.austin.common.enums;

import com.tony.austin.common.dto.model.EmailContentModel;
import com.tony.austin.common.dto.model.SmsContentModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 发送渠道枚举
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ChannelType {

    SMS(30, "sms(短信)", SmsContentModel.class, "sms"),
    EMAIL(40, "email(邮件)", EmailContentModel.class, "email"),


    ;

    /**
     * 编码值
     */
    private Integer code;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容模型Class
     */
    private Class contentModelClass;

    /**
     * 英文标识
     */
    private String codeEn;

    /**
     * 通过code获取class
     */
    public static Class getChanelModelClassByCode(Integer code) {
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value.getContentModelClass();
            }
        }
        return null;
    }

    /**
     * 通过code获取enum
     */
    public static ChannelType getEnumByCode(Integer code) {
        ChannelType[] values = values();
        for (ChannelType value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }


}
