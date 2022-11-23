package com.tony.austin.service.provider.action;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.tony.austin.common.enums.RespStatusEnum;
import com.tony.austin.common.vo.BasicResultVo;
import com.tony.austin.service.api.domain.MessageParam;
import com.tony.austin.service.provider.domain.SendTaskModel;
import com.tony.austin.support.pipeline.BusinessProcess;
import com.tony.austin.support.pipeline.ProcessContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 前置参数校验
 */

@Slf4j
@Service
public class PreParamCheckAction implements BusinessProcess<SendTaskModel> {
    /**
     * 最大的人数
     */
    private static final Integer BATCH_RECEIVER_SIZE = 100;

    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();

        Long messageTemplateId = sendTaskModel.getMessageTemplateId();
        List<MessageParam> messageParamList = sendTaskModel.getMessageParamList();

        //1.没有传入 消息模板id 或者 messageParam
        if (messageTemplateId == null || CollUtil.isEmpty(messageParamList)) {
            context.setNeedBreak(true).setResponse(BasicResultVo.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }

        //2.过滤 receiver=null 的 messageParam
        List<MessageParam> resultMessageParamList = messageParamList.stream()
                .filter(messageParam -> !StrUtil.isBlank(messageParam.getReceiver()))
                .collect(Collectors.toList());
        if (CollUtil.isEmpty(resultMessageParamList)) {
            context.setNeedBreak(true).setResponse(BasicResultVo.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
            return;
        }

        //3.过滤receiver大于100的请求
        boolean anyMatch = resultMessageParamList.stream().anyMatch(messageParam -> messageParam.getReceiver()
                .split(StrUtil.COMMA).length > BATCH_RECEIVER_SIZE);
        if (anyMatch) {
            context.setNeedBreak(true).setResponse(BasicResultVo.fail(RespStatusEnum.TOO_MANY_RECEIVER));
            return;
        }

        sendTaskModel.setMessageParamList(resultMessageParamList);


    }


}
