package com.tgyf.rabbit.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:01 PM
 * @remark
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestBean {
    /**
     * 交换器
     */
    private String exchange;

    /**
     * 路由键
     */
    private String routingKey;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 消息 headers
     */
    private Map<String, String> headers;

    /**
     * 内容
     */
    private String content;
}
