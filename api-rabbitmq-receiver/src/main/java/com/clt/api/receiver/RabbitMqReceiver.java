package com.clt.api.receiver;

import com.alibaba.fastjson.JSON;
import com.clt.api.utils.RabbitMqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @ClassName : RabbitMqReceiver
 * @Author : zhangquansong
 * @Date : 2019/1/10 0010 上午 11:13
 * @Description :消息接收
 **/
@Component
@Slf4j
@RabbitListener(queues = RabbitMqConstants.NORMAL_QUEUE)
public class RabbitMqReceiver {

    /**
     * 接收消息
     *
     * @param obj
     */
    @RabbitHandler
    public void receiveMessage(@Payload String obj) {
        System.out.println(obj);
        log.info("收到的消息为：{}", JSON.toJSONString(obj));
    }
}
