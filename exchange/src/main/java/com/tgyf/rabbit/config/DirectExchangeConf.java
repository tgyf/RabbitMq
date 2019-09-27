package com.tgyf.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * direct exchange -- 直接交换器
 * 发送到该交换器的消息都会被路由到与 routing key 匹配的队列中
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:07 PM
 * @remark
 */
@Configuration
public class DirectExchangeConf {
    public static final String QUEUE_1 = "direct-queue-1";

    public static final String QUEUE_2 = "direct-queue-2";

    private static final String EXCHANGE = "exchange-direct";

    private static final String ROUTING_KEY_TO_QUEUE1 = "queue.direct.key1";

    private static final String ROUTING_KEY_TO_QUEUE2 = "queue.direct.key2";

    @Bean
    Queue directQueue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    Queue directQueue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Binding bindingDirectQueue1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with(ROUTING_KEY_TO_QUEUE1);
    }

    @Bean
    Binding bindingDirectQueue2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(ROUTING_KEY_TO_QUEUE2);
    }
}
