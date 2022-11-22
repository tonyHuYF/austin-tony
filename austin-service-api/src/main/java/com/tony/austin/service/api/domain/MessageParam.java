package com.tony.austin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * 消息参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class MessageParam {
    /**
     * 接收者
     * 多个用，逗号分隔
     * 必传
     */
    private String receiver;
    /**
     * 消息内容的可变部分
     * 可选
     */
    private Map<String, String> variables;
    /**
     * 扩展参数
     * 可选
     */
    private Map<String, String> extra;
}
