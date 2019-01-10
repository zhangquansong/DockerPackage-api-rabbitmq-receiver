package com.clt.api.receiver;

import com.alibaba.fastjson.JSON;
import com.clt.api.entity.Coupon;
import com.clt.api.mq.RewardMq;
import com.clt.api.service.CouponService;
import com.clt.api.utils.RabbitMqConstants;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName : FanoutQueueRewardMqReceiver
 * @Author : zhangquansong
 * @Date : 2019/1/9 0009 下午 2:45
 * @Description :接收发放奖励消息
 **/
@Slf4j
@Component
@RabbitListener(queues = RabbitMqConstants.CLT_QUEUE_REWARD)
public class FanoutQueueRewardMqReceiver {

    @Autowired
    private CouponService couponService;

    @RabbitHandler
    public void receive(@Payload String msg, Channel channel, @Header(AmqpHeaders.APP_ID) String appId,
                        @Header(AmqpHeaders.DELIVERY_TAG) long tag, @Header(AmqpHeaders.REDELIVERED) boolean redelivered)
            throws IOException {
        RewardMq rewardMq = JSON.parseObject(msg, RewardMq.class);
        try {
            log.info("FanoutQueueRewardMqReceiver接收消息：{}", msg);
            Coupon coupon = new Coupon();
            coupon.setUserId(rewardMq.getUsersId());
            couponService.create(coupon);
            System.out.println(msg + "<<<<<<<<<<<<<<<<<<<<<");
            channel.basicAck(tag, false); // false只确认当前一个消息收到，true确认所有consumer获得的消息
        } catch (Exception e) {
            if (redelivered) {
                log.info("消息已重复处理失败,拒绝再次接收..." + tag);
                channel.basicNack(tag, false, false); // 放弃消息
            } else {
                log.info("消息即将再次返回队列处理..." + tag);
                channel.basicNack(tag, false, true); // 重新回到队列
            }
        }
    }
}
