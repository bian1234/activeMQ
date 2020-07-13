package top.byk.activemq.controller.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ykbian
 * @date 2020/7/3 4:3
 */
@Component
public class TopicConsumerListener1 {


    /**
     *Topic模式下的生产者和消费者关系是1:N，因此这里可以写多个消费方法
     */



   /**
    * @Description: Topic模式的监听，要监听哪个，destination就写哪个topic的名字
    * @Author: ykbian
    * @Date: 2020/7/13 16:13
    * @Param:
    * @return:
    */
    @JmsListener(destination="${spring.activemq.topic-name1}", containerFactory="topicListener")
    public void readActiveTopic(String message) {
        System.out.println("topic1-1接收到：" + message);
    }


    @JmsListener(destination="${spring.activemq.topic-name1}", containerFactory="topicListener")
    public void readActiveTopic1(String message) {
        System.out.println("topic1-2接收到：" + message);
    }

    @JmsListener(destination="${spring.activemq.topic-name1}", containerFactory="topicListener")
    public void readActiveTopic2(String message) {
        System.out.println("topic1-3接收到：" + message);
    }
}
