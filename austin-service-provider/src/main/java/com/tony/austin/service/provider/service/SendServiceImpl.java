package com.tony.austin.service.provider.service;

import com.tony.austin.common.vo.BasicResultVo;
import com.tony.austin.service.api.domain.SendRequest;
import com.tony.austin.service.api.domain.SendResponse;
import com.tony.austin.service.api.service.SendService;
import com.tony.austin.service.provider.domain.SendTaskModel;
import com.tony.austin.support.pipeline.ProcessContext;
import com.tony.austin.support.pipeline.ProcessController;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Collections;

@DubboService(interfaceClass = SendService.class)
public class SendServiceImpl implements SendService {

    @Resource
    private ProcessController processController;

    @Override
    public SendResponse send(SendRequest sendRequest) {
        SendTaskModel sendTaskModel = SendTaskModel.builder()
                .messageTemplateId(sendRequest.getMessageTemplateId())
                .messageParamList(Collections.singletonList(sendRequest.getMessageParam()))
                .build();

        ProcessContext context = ProcessContext.builder()
                .code(sendRequest.getCode())
                .processModel(sendTaskModel)
                .needBreak(false)
                .response(BasicResultVo.success())
                .build();

        ProcessContext process = processController.process(context);

        return new SendResponse(process.getResponse().getCode(), process.getResponse().getMsg());

    }
}
