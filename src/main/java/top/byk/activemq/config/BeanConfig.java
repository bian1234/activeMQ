package top.byk.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @description:
 * @author: ykbian
 * @date 2020/7/3 4:8
 */
@Configuration
public class BeanConfig {


    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.queue-name1}")
    private String queueName1;

    @Value("${spring.activemq.topic-name1}")
    private String topicName1;

    @Value("${spring.activemq.queue-name2}")
    private String queueName2;

    @Value("${spring.activemq.topic-name2}")
    private String topicName2;

    @Bean(name = "queue1")
    public Queue queue1() {
        return new ActiveMQQueue(queueName1);
    }
    @Bean(name = "queue2")
    public Queue queue2() {
        return new ActiveMQQueue(queueName2);
    }

    /**
     * @Description: 创建一个topic
     * @Author: ykbian
     * @Date: 2020/7/3 5:36
     * @Param: 配置文件获取的topicName,
     * @return:
     */
    @Bean(name = "topic1")
    public Topic topic1() {
        return new ActiveMQTopic(topicName1);
    }

    @Bean(name = "topic2")
    public Topic topic2() {
        return new ActiveMQTopic(topicName2);
    }


    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(username, password, brokerUrl);
    }

    @Bean
    public JmsMessagingTemplate jmsMessageTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }

    @Bean("queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }


    @Bean("topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

}
