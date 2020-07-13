package top.byk.activemq.controller.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;
/**
 * @description:
 * @author: ykbian
 * @date 2020/7/13 14:25
 */
@RestController
public class ProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @GetMapping("/queue/test")
    public String sendQueue(String str) {
        this.sendMessage(this.queue, str);
        return "QUEUE>>>>>success";
    }

    @GetMapping("/topic/test")
    public String sendTopic(String str) {
        this.sendMessage(this.topic, str);
        return "TOPIC>>>>>success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
