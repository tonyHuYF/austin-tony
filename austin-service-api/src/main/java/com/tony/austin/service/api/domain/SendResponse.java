package com.tony.austin.service.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 发送接口返回值
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SendResponse implements Serializable {

    private static final long serialVersionUID = -5183243575269033152L;

    /**
     * 响应状态
     */
    private String code;

    /**
     * 响应编码
     */
    private String msg;


}
