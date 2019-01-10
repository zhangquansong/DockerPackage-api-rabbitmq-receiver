package com.clt.api.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName : HelloMqReceiver
 * @Author : zhangquansong
 * @Date : 2019/1/10 0010 下午 1:56
 * @Description :
 **/
@Component
@RabbitListener(queues = "zqstestqueue")
public class HelloMqReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println(msg + "<<<<<<<<<<<<<<<<<<<<<");
    }
}
