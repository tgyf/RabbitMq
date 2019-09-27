package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.FanoutExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:17 PM
 * @remark
 */
@Component
@Slf4j
public class FanoutQueueListener {
    @RabbitListener(queues = FanoutExchangeConf.QUEUE_1)
    public void listenFanoutQueue1(String message) {
        log.info("[{}] {}", FanoutExchangeConf.QUEUE_1, message);
    }

    @RabbitListener(queues = FanoutExchangeConf.QUEUE_2)
    public void listenFanoutQueue2(String message) {
        log.info("[{}] {}", FanoutExchangeConf.QUEUE_2, message);
    }
}
