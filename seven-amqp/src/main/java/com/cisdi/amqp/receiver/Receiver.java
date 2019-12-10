package com.cisdi.amqp.receiver;

import com.cisdi.amqp.utils.RabbitConstParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author pengyangyan
 * @version 1.0.0
 * @date 2019年12月06日 08:43:00
 */
@Slf4j
@Component
@Order(2)
@RabbitListener(queues = RabbitConstParam.QUERY_A)
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitHandler
    public void receiveMessage(String message){
        log.info("接收到队列A中的消息"+message);
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }
}
