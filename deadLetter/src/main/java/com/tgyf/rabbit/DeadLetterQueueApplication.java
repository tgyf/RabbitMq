package com.tgyf.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadLetterQueueApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeadLetterQueueApplication.class,args);
    }
}
