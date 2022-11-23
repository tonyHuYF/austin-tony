package com.tony.austin.support.exception;

import com.tony.austin.common.enums.RespStatusEnum;
import com.tony.austin.support.pipeline.ProcessContext;

public class ProcessException extends RuntimeException {

    /**
     * 流程处理上下文
     */
    private ProcessContext processContext;

    public ProcessException(ProcessContext processContext) {
        this.processContext = processContext;
    }

    @Override
    public String getMessage() {
        if (this.processContext != null) {
            return this.processContext.getResponse().getMsg();
        } else {
            return RespStatusEnum.CONTEXT_IS_NULL.getMsg();
        }
    }

    public ProcessContext getProcessContext() {
        return this.processContext;
    }
}
