package com.tony.austin.service.provider.service;

import com.tony.austin.service.api.service.SendService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(interfaceClass = SendService.class)
public class SendServiceImpl implements SendService {
    @Override
    public String send() {
        return "消息提供方收到消息啦，并返回";
    }
}
