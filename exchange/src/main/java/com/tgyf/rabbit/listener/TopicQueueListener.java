package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.TopicExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:22 PM
 * @remark
 */
@Component
@Slf4j
public class TopicQueueListener {
    @RabbitListener(queues = TopicExchangeConf.QUEUE_1)
    public void listenTopicQueue1(String message) {
        log.info("[{}] {}", TopicExchangeConf.QUEUE_1, message);
    }

    @RabbitListener(queues = TopicExchangeConf.QUEUE_2)
    public void listenTopicQueue2(String message) {
        log.info("[{}] {}", TopicExchangeConf.QUEUE_2, message);
    }

}
