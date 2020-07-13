package top.byk.activemq.controller.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: ykbian
 * @date 2020/7/3 4:3
 */
@Component
public class TopicConsumerListener2 {


   /**
    * @Description: Topic模式的监听，要监听哪个，destination就写哪个topic的名字
    * @Author: ykbian
    * @Date: 2020/7/13 16:13
    * @Param:
    * @return:
    */
    @JmsListener(destination="${spring.activemq.topic-name2}", containerFactory="topicListener")
    public void readActiveTopic1(String message) {
        System.out.println("topic2-1接受到：" + message);
    }


    @JmsListener(destination="${spring.activemq.topic-name2}", containerFactory="topicListener")
    public void readActiveTopic2(String message) {
        System.out.println("topic2-2接受到：" + message);
    }
}
