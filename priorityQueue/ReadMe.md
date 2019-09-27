# RabbitMQ - 优先级队列(PriorityQueue)
在RabbitMQ中使用优先级特性需要的版本为3.5+。

    使用优先级特性只需做两件事情：
        1. 将队列声明为优先级队列，即在创建队列的时候添加参数 x-max-priority 以指定最大的优先级，值为0-255（整数）。
        2. 为优先级消息添加优先级。
* 注意:没有指定优先级的消息会将优先级以0对待。 对于超过优先级队列所定最大优先级的消息，优先级以最大优先级对待。对于相同优先级的消息，后进的排在前面。

## 测试
### 1.测试优先级队列
      
发送优先级低的消息 100 条到 RabbitMQ

    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-direct",
        "routingKey": "direct.queue.priority",
        "priority": 1,
        "content":" hello priority queue! ",
        "count": 100
    }'
    
发送优先级高的消息 5 条到 RabbitMQ

    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-direct",
        "routingKey": "direct.queue.priority",
        "priority": 10,
        "content":" >>>>>>>> hello priority queue! ",
        "count": 5
    }'