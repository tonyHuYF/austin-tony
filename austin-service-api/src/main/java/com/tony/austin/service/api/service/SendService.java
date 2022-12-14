package com.tony.austin.service.api.service;

import com.tony.austin.service.api.domain.SendRequest;
import com.tony.austin.service.api.domain.SendResponse;

/**
 * 发送接口
 */
public interface SendService {
    /**
     * 单文案发送接口
     */
    SendResponse send(SendRequest sendRequest);
}
