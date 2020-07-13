package top.byk.activemq.controller.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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





/**
 *@Resource优先按照name属性进行注入，因此推荐用@Resource，可以同时注入多个Topic信息
 */
//    @Autowired
    @Resource(name="topic1")
    private Topic topic1;
    @Resource(name="queue1")
    private Queue queue1;


    @Resource(name="topic2")
    private Topic topic2;
    @Resource(name="queue2")
    private Queue queue2;




    @GetMapping("/queue1")
    public String sendQueue1(String str) {
        this.sendMessage(this.queue1, str);
        return "QUEUE1>>>>>success";
    }

    @GetMapping("/topic1")
    public String sendTopic(String str) {
        this.sendMessage(this.topic1, str);
        return "TOPIC1>>>>>success";
    }

    @GetMapping("/queue2")
    public String sendQueue2(String str) {
        this.sendMessage(this.queue2, str);
        return "QUEUE2>>>>>success";
    }

    @GetMapping("/topic2")
    public String sendTopic2(String str) {
        this.sendMessage(this.topic2, str);
        return "TOPIC2>>>>>success";
    }





  /**
   * @Description: 发送消息，destination是发送到的队列，message是待发送的消息
   * @Author: ykbian
   * @Date: 2020/7/13 16:10
   * @Param:
   * @return:
   */
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
