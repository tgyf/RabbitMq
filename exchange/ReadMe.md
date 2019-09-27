# RabbitMQ - 交换器

|交换器名称|作用|
|:-|:-|
|fanout exchange|发送到该交换器的所有消息，会被路由到其绑定的所有队列|
|direct exchange|发送到该交换器的消息，会通过路由键完全匹配，匹配成功就会路由到指定队列|
|topic exchange|发送到该交换器的消息，会通过路由键模糊匹配，匹配成功就会路由到指定队列|
|header exchange|发送到该交换器的消息，会通过消息的 header 信息匹配，匹配成功就会路由到指定队列|


## 测试

### 1.测试fanout exchange

    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-fanout",
        "routingKey": "default",
        "content":" hello fanout!",
        "count": 1
    }'
    
### 2.测试 direct exchange

    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-direct",
        "routingKey": "queue.direct.key1",
        "content":" hello direct! ",
        "count": 1
    }'
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-direct",
        "routingKey": "queue.direct.key2",
        "content":" hello direct! ",
        "count": 1
    }'

### 3.测试 topic exchange
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-topic",
        "routingKey": "queue.topic.key1",
        "content":" hello topic! ",
        "count": 1
    }'
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-topic",
        "routingKey": "test.topic.key2",
        "content":" hello topic! ",
        "count": 1
    }'
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-topic",
        "routingKey": "queue.hello",
        "content":" hello topic! ",
        "count": 1
    }'
    
### 4.测试 headers exchange
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-headers",
        "content":" hello headers! ",
        "count": 1,
        "headers":{
            "one":"value"
        }
    }'
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-headers",
        "content":" hello headers! ",
        "count": 1,
        "headers":{
            "all1":"value",
            "all2":"value"
        }
    }'
    
    curl -X POST \
      http://127.0.0.1/send \
      -H 'Content-Type: application/json' \
      -d '{
        "exchange":"exchange-headers",
        "content":" hello headers! ",
        "count": 1,
        "headers":{
            "any2":"value",
        }
    }'