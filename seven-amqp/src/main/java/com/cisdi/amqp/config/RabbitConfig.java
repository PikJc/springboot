package com.cisdi.amqp.config;

import com.cisdi.amqp.utils.RabbitConstParam;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月06日 08:51:00
 */
@Configuration
public class RabbitConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    @Bean("myMessageConverter")
    public MessageConverter messageConverter(){
        return (MessageConverter) new DefaultJackson2JavaTypeMapper();
    }

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }





    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念   类似广播
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(RabbitConstParam.DIRECT_EXCHANGE);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(RabbitConstParam.HEADER_ECHANGE);
    }
    /**
     * 获取队列A
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue(RabbitConstParam.QUERY_A, true); //队列持久
    }

    @Bean Queue queueB(){
        return new Queue(RabbitConstParam.QUERY_B, true); //队列持久
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConstParam.ROUT_KEY_A);
    }

    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(headersExchange()).where(RabbitConstParam.ROUT_KEY_A).exists();
    }

}
