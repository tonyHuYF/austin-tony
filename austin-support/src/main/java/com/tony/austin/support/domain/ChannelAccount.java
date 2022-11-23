package com.tony.austin.support.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 渠道账户信息
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("channel_account")
public class ChannelAccount implements Serializable {

    private static final long serialVersionUID = -5183243575269033152L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 账号名称
     */
    private String name;

    /**
     * 发送渠道
     * 枚举值：com.tony.austin.common.enums.ChannelType
     */
    private Integer sendChannel;

    /**
     * 账号配置
     */
    private String accountConfig;

    /**
     * 是否删除
     * 0：未删除
     * 1：已删除
     */
    private Integer isDeleted;

    /**
     * 创建时间 单位 s
     */
    private LocalDateTime created;

    /**
     * 更新时间 单位s
     */
    private LocalDateTime updated;

}
