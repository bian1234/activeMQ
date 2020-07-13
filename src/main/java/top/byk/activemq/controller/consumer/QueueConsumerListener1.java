package top.byk.activemq.controller.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description: Queue模式下的消费
 * @author: ykbian
 * @date 2020/7/3 4:29
 */
@Component
public class QueueConsumerListener1 {


    /**
     * Queue模式下的生产和消费是1:1的关系，因此下面的两个消费方法只有一个能发生消费。
     */

    /**
     * @Description: 要监听哪个queue，destination就是哪个；
     * @Author: ykbian
     * @Date: 2020/7/13 16:11
     * @Param:
     * @return:
     */
    @JmsListener(destination = "${spring.activemq.queue-name1}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue1-1接受到：" + message);
    }


    @JmsListener(destination = "${spring.activemq.queue-name1}", containerFactory = "queueListener")
    public void readActiveQueue2(String message) {
        System.out.println("queue1-2接受到：" + message);
    }
}
