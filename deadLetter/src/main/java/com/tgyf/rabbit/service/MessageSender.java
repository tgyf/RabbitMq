package com.tgyf.rabbit.service;

import com.tgyf.rabbit.bean.MessageRequestBean;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class MessageSender {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(MessageRequestBean messageRequestBean) {
        for (int i = 0; i < messageRequestBean.getCount(); i++) {
            String content = String.format("[%4d] %s", i, messageRequestBean.getContent());
            rabbitTemplate.convertAndSend(messageRequestBean.getExchange(), messageRequestBean.getRoutingKey(), content, message -> {
                Map<String, String> headers = messageRequestBean.getHeaders();
                if (headers != null && !headers.isEmpty()){
                    headers.forEach((key, value) -> message.getMessageProperties().setHeader(key, value));
                }
                // 为优先级消息添加优先级
                Integer priority = messageRequestBean.getPriority();
                if (priority != null){
                    message.getMessageProperties().setPriority(priority);
                }
                // 为延时消息添加延时时间
                String delayTime = messageRequestBean.getDelayTime();
                if (delayTime != null){
                    message.getMessageProperties().setExpiration(delayTime);
                }
                return message;
            });
        }
    }
}
