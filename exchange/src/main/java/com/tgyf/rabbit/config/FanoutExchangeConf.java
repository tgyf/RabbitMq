package com.tgyf.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanout exchange -- 扇出交换器
 * 所有发送到该交换器的消息都会被路由到所有与该交换器绑定的队列中
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:04 PM
 * @remark
 */
@Configuration
public class FanoutExchangeConf {
    public static final String QUEUE_1 = "fanout-queue-1";

    public static final String QUEUE_2 = "fanout-queue-2";

    private static final String EXCHANGE = "exchange-fanout";

    @Bean
    Queue fanoutQueue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    Queue fanoutQueue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE);
    }

    @Bean
    Binding bindingFanoutQueue1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutQueue2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
