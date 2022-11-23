package com.tony.austin.common.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 邮件内容模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailContentModel extends ContentModel {

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件发送内容（可写入HTML）
     */
    private String content;


}
