package com.clt.api.receiver;

import com.clt.api.utils.RabbitMqConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName : NormalProcessor
 * @Author : zhangquansong
 * @Date : 2019/1/10 0010 上午 11:13
 * @Description :普通消息队列处理器
 **/
@Slf4j
@Component
@RabbitListener(queues = RabbitMqConstants.NORMAL_QUEUE)
public class NormalProcessor {

    /**
     * 接收消息
     *
     * @param obj
     */
    @RabbitHandler
    public void receiveMessage(String obj) {
        System.out.println(obj);
        log.info("普通队列收到的消息为：{}", obj);
    }
}
