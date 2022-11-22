package com.tony.austin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 发送/撤回接口的参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class SendRequest {
    /**
     * 执行业务类型
     * send:发送消息
     * recall:撤回消息
     */
    private String code;

    /**
     * 消息模板id
     * 必填
     */
    private Long messageTemplateId;

    /**
     * 消息相关参数
     * 当业务类型为“send”，必填
     */
    private MessageParam messageParam;


}
