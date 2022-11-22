package com.tony.austin.client.controller;

import com.tony.austin.service.api.domain.SendRequest;
import com.tony.austin.service.api.domain.SendResponse;
import com.tony.austin.service.api.service.SendService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对外开放的发送接口
 */
@RestController
@RequestMapping("/send")
public class SendController {
    @DubboReference
    private SendService sendService;

    @PostMapping
    public SendResponse send(@RequestBody SendRequest sendRequest) {
        return sendService.send(sendRequest);
    }
}
