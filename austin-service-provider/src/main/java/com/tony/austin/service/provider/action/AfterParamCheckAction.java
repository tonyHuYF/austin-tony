package com.tony.austin.service.provider.action;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReUtil;
import com.alibaba.fastjson.JSON;
import com.tony.austin.common.domain.TaskInfo;
import com.tony.austin.common.enums.IdType;
import com.tony.austin.common.enums.RespStatusEnum;
import com.tony.austin.common.vo.BasicResultVo;
import com.tony.austin.service.provider.domain.SendTaskModel;
import com.tony.austin.support.pipeline.BusinessProcess;
import com.tony.austin.support.pipeline.ProcessContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 后置参数检查
 */
@Service
@Slf4j
public class AfterParamCheckAction implements BusinessProcess<SendTaskModel> {

    public static final String PHONE_REGEX_EXP = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[0-9])|(18[0-9])|(19[1,8,9]))\\d{8}$";
    public static final String EMAIL_REGEX_EXP = "^[A-Za-z0-9-_\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    public static final HashMap<Integer, String> CHANNEL_REGEX_EXP = new HashMap<>();

    static {
        CHANNEL_REGEX_EXP.put(IdType.PHONE.getCode(), PHONE_REGEX_EXP);
        CHANNEL_REGEX_EXP.put(IdType.EMAIL.getCode(), EMAIL_REGEX_EXP);
    }


    @Override
    public void process(ProcessContext<SendTaskModel> context) {
        SendTaskModel sendTaskModel = context.getProcessModel();
        List<TaskInfo> taskInfo = sendTaskModel.getTaskInfo();

        //1.过滤掉不合法的手机号、邮件
        filterIllegalReceiver(taskInfo);

        if (CollUtil.isEmpty(taskInfo)) {
            context.setNeedBreak(true).setResponse(BasicResultVo.fail(RespStatusEnum.CLIENT_BAD_PARAMETERS));
        }
    }

    /**
     * 如果指定类型是手机号，检查输入手机号是否合法
     * 如果指定类型是邮件，检查输入邮件是否合法
     */
    private void filterIllegalReceiver(List<TaskInfo> taskInfo) {
        Integer idType = CollUtil.getFirst(taskInfo.iterator()).getIdType();
        filter(taskInfo, CHANNEL_REGEX_EXP.get(idType));
    }

    /**
     * 利用正则过滤掉不合法的接收者
     */
    private void filter(List<TaskInfo> taskInfo, String regexExp) {
        Iterator<TaskInfo> iterator = taskInfo.iterator();
        while (iterator.hasNext()) {
            TaskInfo task = iterator.next();
            Set<String> illegalPhone = task.getReceiver().stream()
                    .filter(phone -> !ReUtil.isMatch(regexExp, phone))
                    .collect(Collectors.toSet());

            if (CollUtil.isNotEmpty(illegalPhone)) {
                task.getReceiver().removeAll(illegalPhone);
                log.error("messageTemplate:{} find illegal receiver!{}", task.getMessageTemplateId(),
                        JSON.toJSONString(illegalPhone));
            }

            if (CollUtil.isEmpty(task.getReceiver())) {
                iterator.remove();
            }

        }
    }


}
