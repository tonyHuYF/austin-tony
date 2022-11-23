package com.tony.austin.common.vo;

import com.tony.austin.common.enums.RespStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class BasicResultVo<T> {

    /**
     * 响应状态
     */
    private String code;

    /**
     * 响应编码
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BasicResultVo(RespStatusEnum status) {
        this(status, null);
    }

    public BasicResultVo(RespStatusEnum status, T data) {
        this(status, status.getMsg(), data);
    }

    public BasicResultVo(RespStatusEnum status, String msg, T data) {
        this.code = status.getCode();
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认成功响应
     */
    public static BasicResultVo<Void> success() {
        return new BasicResultVo<>(RespStatusEnum.SUCCESS);
    }

    /**
     * 自定义信息的成功响应
     */
    public static <T> BasicResultVo<T> success(String msg) {
        return new BasicResultVo<>(RespStatusEnum.SUCCESS, msg, null);
    }

    /**
     * 带数据的成功响应
     */
    public static <T> BasicResultVo<T> success(T data) {
        return new BasicResultVo<>(RespStatusEnum.SUCCESS, data);
    }

    /**
     * 默认失败响应
     */
    public static <T> BasicResultVo<T> fail() {
        return new BasicResultVo<>(RespStatusEnum.FAIL);
    }

    /**
     * 自定义错误信息的失败响应
     */
    public static <T> BasicResultVo<T> fail(String msg) {
        return new BasicResultVo<>(RespStatusEnum.FAIL, msg, null);
    }

    /**
     * 自定义状态的失败响应
     */
    public static <T> BasicResultVo<T> fail(RespStatusEnum status) {
        return new BasicResultVo<>(status, status.getMsg(), null);
    }

    /**
     * 自定义状态和信息的失败响应
     */
    public static <T> BasicResultVo<T> fail(RespStatusEnum status, String msg) {
        return new BasicResultVo<>(status, msg, null);
    }


}
