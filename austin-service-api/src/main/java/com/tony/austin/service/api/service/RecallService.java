package com.tony.austin.service.api.service;

import com.tony.austin.service.api.domain.SendRequest;
import com.tony.austin.service.api.domain.SendResponse;

/**
 * 撤回接口
 */
public interface RecallService {
    /**
     * 根据模板Id撤回消息
     */
    SendResponse recall(SendRequest sendRequest);

}
