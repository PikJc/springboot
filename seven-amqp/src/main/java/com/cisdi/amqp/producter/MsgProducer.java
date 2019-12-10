package com.cisdi.amqp.producter;

import com.cisdi.amqp.config.RabbitConfig;
import com.cisdi.amqp.receiver.Receiver;
import com.cisdi.amqp.utils.Message;
import com.cisdi.amqp.utils.RabbitConstParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月06日 09:08:00
 */
@Slf4j
@Component
@Order(1)
public class MsgProducer implements CommandLineRunner {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    Receiver receiver;
    @Autowired
    ConfigurableApplicationContext context;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message ...");
        rabbitTemplate.convertAndSend(RabbitConstParam.DIRECT_EXCHANGE,RabbitConstParam.ROUT_KEY_A,new Message().setName("小明").setContent("去世啦"));
        receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
        context.close();
    }
}
