package com.tgyf.rabbit.listener;

import com.tgyf.rabbit.config.HeadersExchangeConf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:23 PM
 * @remark
 */
@Component
@Slf4j
public class HeadersQueueListener {
    @RabbitListener(queues = HeadersExchangeConf.QUEUE_1)
    public void listenHeadersQueue1(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConf.QUEUE_1, stringBuilder.toString(), new String(message.getBody()));
    }

    @RabbitListener(queues = HeadersExchangeConf.QUEUE_2)
    public void listenHeadersQueue2(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConf.QUEUE_2, stringBuilder.toString(), new String(message.getBody()));
    }

    @RabbitListener(queues = HeadersExchangeConf.QUEUE_3)
    public void listenHeadersQueue3(Message message) {
        Map<String, Object> headers = message.getMessageProperties().getHeaders();
        StringBuilder stringBuilder = new StringBuilder();
        headers.forEach((key, value) -> stringBuilder.append("[").append(key).append(": ").append(value).append("]"));
        log.info("[{}] {} {}", HeadersExchangeConf.QUEUE_3, stringBuilder.toString(), new String(message.getBody()));
    }
}
