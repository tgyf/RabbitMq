package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.DirectExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DirectQueueListener {
    /**
     * 监听常规队列的消息
     */
    @RabbitListener(queues = DirectExchangeConf.QUEUE_REJECT)
    public void listen(Message message) throws Exception{
        // 模拟业务处理
        log.error("[{}] {}", DirectExchangeConf.QUEUE_REJECT, message);
        throw new AmqpRejectAndDontRequeueException("to dead-letter");
    }
}
