#测试使用springBoot与active的结合

##一、关于消费者consumer
activceMQ有两种消费模式：P2P(QUENE)和Pub/Sub(Publish/Subscribe)(topic)
###1.1 P2P(QUENE)模式
一种称为P2P(Ponit to Point)模型，即采用点对点的方式发送消息。P2P模型是基于队列的，消息生产者发送消息到队列，消息消费者从队列中接收消息，队列的存在使得消息的异步传输称为可能，P2P模型在点对点的情况下进行消息传递时采用。消息生产者和消费者是1:1的关系，相同的queue下，只有一个消费者能发生消费。
![](https://github.com/bian1234/activeMQ/blob/master/src/main/resources/static/image/P2P.png)
###1.2 Pub/Sub(Publish/Subscribe)(tpoic)模式
另一种称为Pub/Sub(Publish/Subscribe，即发布-订阅)模型，发布-订阅模型定义了如何向一个内容节点发布和订阅消息，这个内容节点称为topic(主题)。主题可以认为是消息传递的中介，消息发布这将消息发布到某个主题，而消息订阅者则从主题订阅消息。主题使得消息的订阅者与消息的发布者互相保持独立，不需要进行接触即可保证消息的传递，发布-订阅模型在消息的一对多广播时采用。
![](https://github.com/bian1234/activeMQ/blob/master/src/main/resources/static/image/topic.png)
####1.2.1 topic模式有普通订阅和持久化订阅
    
1. 普通订阅：在消费者启动之前发送过来的消息，消费者启动之后不会去消费；
    
2. 持久化订阅： 在消费者启动之前发送过来的消息，消费者启动之后会去消费；

### 1.3 同时发布和消费多个queue和topic的消息
1. application.properties文件配置不同的topicName;
2. BeanConfig文件创建不同的Topic;
3. 生产者根据业务需求进行调用;
4. 消费者根据不同的topicName进行监听。