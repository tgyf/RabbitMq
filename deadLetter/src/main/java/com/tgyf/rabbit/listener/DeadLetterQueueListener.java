package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.DeadLetterExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeadLetterQueueListener {
    /**
     * 监听死信队列由于超出队列长度产生的消息
     */
    @RabbitListener(queues = DeadLetterExchangeConf.QUEUE_BY_MAX_LENGTH)
    public void listenMaxLength(String message) {
        log.info("[{}] {}", DeadLetterExchangeConf.QUEUE_BY_MAX_LENGTH, message);
    }

    /**
     * 监听死信队列由于超时产生的消息
     */
    @RabbitListener(queues = DeadLetterExchangeConf.QUEUE_BY_TTL)
    public void listenTTL(String message) {
        log.info("[{}] {}", DeadLetterExchangeConf.QUEUE_BY_TTL, message);
    }

    /**
     * 监听死信队列由于被消费者否认的消息
     */
    @RabbitListener(queues = DeadLetterExchangeConf.QUEUE_BY_REJECT)
    public void listenReject(String message) {
        log.info("[{}] {}", DeadLetterExchangeConf.QUEUE_BY_REJECT, message);
    }
}
