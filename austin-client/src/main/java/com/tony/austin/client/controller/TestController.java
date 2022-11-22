package com.tony.austin.client.controller;

import com.tony.austin.service.api.service.SendService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @DubboReference
    private SendService sendService;

    @GetMapping
    public String test() {
       return sendService.send();
    }
}
