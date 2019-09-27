package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.DirectExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:20 PM
 * @remark
 */
@Component
@Slf4j
public class DirectQueueListener {
    @RabbitListener(queues = DirectExchangeConf.QUEUE_1)
    public void listenDirectQueue1(String message) {
        log.info("[{}] {}", DirectExchangeConf.QUEUE_1, message);
    }

    @RabbitListener(queues = DirectExchangeConf.QUEUE_2)
    public void listenDirectQueue2(String message) {
        log.info("[{}] {}", DirectExchangeConf.QUEUE_2, message);
    }
}
