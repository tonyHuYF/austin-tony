package com.tony.austin.service.provider.config;

import com.tony.austin.service.api.enums.BusinessCode;
import com.tony.austin.service.provider.action.AfterParamCheckAction;
import com.tony.austin.service.provider.action.PreParamCheckAction;
import com.tony.austin.support.pipeline.ProcessController;
import com.tony.austin.support.pipeline.ProcessTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * pipeline配置类
 */
@Configuration
public class PipelineConfig {
    @Resource
    private PreParamCheckAction preParamCheckAction;
    @Resource
    private AfterParamCheckAction afterParamCheckAction;

    /**
     * 普通发送执行流程
     * 1.前置参数校验
     * 2.组装参数
     * 3.后置参数校验
     * 4.发送消息到MQ
     */
    @Bean
    public ProcessTemplate commonSendTemplate() {
        ProcessTemplate processTemplate = new ProcessTemplate();
        processTemplate.setProcessList(Arrays.asList(preParamCheckAction, afterParamCheckAction));
        return processTemplate;
    }


    /**
     * pipeline流程控制器
     * 后续扩展加BusinessCode和ProcessTemplate
     */
    @Bean
    public ProcessController processController() {
        ProcessController processController = new ProcessController();
        Map<String, ProcessTemplate> templateConfig = new HashMap<>();
        templateConfig.put(BusinessCode.COMMON_SEND.getCode(), commonSendTemplate());
        processController.setTemplateConfig(templateConfig);
        return processController;
    }


}
