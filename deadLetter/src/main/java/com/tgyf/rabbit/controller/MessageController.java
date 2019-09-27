package com.tgyf.rabbit.controller;

import com.tgyf.rabbit.bean.MessageRequestBean;
import com.tgyf.rabbit.service.MessageSender;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 韬光养月巴
 * @modify
 * @createDate 2019/8/24 12:29 PM
 * @remark
 */
@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageSender messageSender;


    @PostMapping("/send")
    public String send(@RequestBody MessageRequestBean messageRequestBean){
        messageSender.sendMessage(messageRequestBean);
        return "success";
    }
}
