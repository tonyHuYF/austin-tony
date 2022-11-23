package com.tony.austin.service.provider.domain;

import com.tony.austin.common.domain.TaskInfo;
import com.tony.austin.service.api.domain.MessageParam;
import com.tony.austin.support.domain.MessageTemplate;
import com.tony.austin.support.pipeline.ProcessModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 发送消息任务模型
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendTaskModel implements ProcessModel , Serializable {

    private static final long serialVersionUID = -5183243575269033152L;

    /**
     * 消息模板id
     */
    private Long messageTemplateId;

    /**
     * 请求参数
     */
    private List<MessageParam> messageParamList;

    /**
     * 发送任务的消息
     */
    private List<TaskInfo> taskInfo;

    /**
     * 撤回任务的消息
     */
    private MessageTemplate messageTemplate;






















}
