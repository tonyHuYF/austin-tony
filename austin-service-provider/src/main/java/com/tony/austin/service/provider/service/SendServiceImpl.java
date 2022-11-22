package com.tony.austin.service.provider.service;

import com.tony.austin.service.api.domain.SendRequest;
import com.tony.austin.service.api.domain.SendResponse;
import com.tony.austin.service.api.service.SendService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = SendService.class)
public class SendServiceImpl implements SendService {
    @Override
    public SendResponse send(SendRequest sendRequest) {
        return null;
    }
}
