package com.tgyf.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * headers exchange -- headers交换器
 * 发送到该交换器的消息会根据消息的 header 信息路由到对应的队列
 * 说明：
 * where 匹配单个 header
 * whereAll 同时匹配多个 header
 * whereAny 匹配一个或多个 header
 *
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:12 PM
 * @remark
 */
public class HeadersExchangeConf {
    public static final String QUEUE_1 = "headers-queue-1";

    public static final String QUEUE_2 = "headers-queue-2";

    public static final String QUEUE_3 = "headers-queue-3";

    private static final String EXCHANGE = "exchange-headers";

    @Bean
    Queue headersQueue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    Queue headersQueue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    Queue headersQueue3() {
        return new Queue(QUEUE_3, false);
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(EXCHANGE);
    }

    @Bean
    Binding bindingHeadersQueue1(Queue headersQueue1, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue1).to(headersExchange).where("one").exists();
    }

    @Bean
    Binding bindingHeadersQueue2(Queue headersQueue1, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue1).to(headersExchange).whereAll("all1", "all2").exist();
    }

    @Bean
    Binding bindingHeadersQueue3(Queue headersQueue3, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue3).to(headersExchange).whereAny("any1", "any2").exist();
    }
}
