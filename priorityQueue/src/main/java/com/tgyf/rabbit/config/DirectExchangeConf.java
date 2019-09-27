package com.tgyf.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * direct exchange -- 直接交换器
 * 发送到该交换器的消息都会被路由到与 routing key 匹配的队列中
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 1:29 PM
 * @remark
 */
@Configuration
@Slf4j
public class DirectExchangeConf {
    public static final String QUEUE = "direct-queue-priority";

    public static final String EXCHANGE = "exchange-direct";

    public static final String ROUTING_KEY = "direct.queue.priority";

    @Bean
    Queue directQueuePriority() {
        //创建队列的时候添加参数 x-max-priority 以指定最大的优先级，值为0-255
        Map<String, Object> args= new HashMap<>();
        args.put("x-max-priority", 100);
        return new Queue(QUEUE, false, false, false, args);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding directQueuePriorityBinding(Queue directQueuePriority, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueuePriority).to(directExchange).with(ROUTING_KEY);
    }

}
