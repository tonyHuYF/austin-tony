package com.tony.austin.common.domain;

import com.tony.austin.common.dto.model.ContentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * 发送任务消息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskInfo implements Serializable {

    private static final long serialVersionUID = -5183243575269033152L;

    /**
     * 消息模板 Id
     */
    private Long messageTemplateId;

    /**
     * 业务id（数据追踪使用）
     * 生成逻辑参考 TaskInfoUtils
     */
    private Long businessId;

    /**
     * 接受者
     */
    private Set<String> receiver;

    /**
     * 发送的ID类型
     */
    private Integer idType;

    /**
     * 发送渠道
     */
    private Integer sendChannel;

    /**
     * 模板类型
     */
    private Integer templateType;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 屏蔽类型
     */
    private Integer shieldType;

    /**
     * 发送文案模型
     * 不同的渠道要发送的内容不一样
     * 所以会有ContentModel
     */
    private ContentModel contentModel;

    /**
     * 发送账户（邮件下可有多个发送账号、短信可有多个发送账户）
     */
    private Integer sendAccount;


}
