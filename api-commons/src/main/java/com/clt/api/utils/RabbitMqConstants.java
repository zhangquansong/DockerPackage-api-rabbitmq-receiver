package com.clt.api.utils;

/**
 * @ClassName : RabbitMqConstants
 * @Author : zhangquansong
 * @Date : 2019/1/9 0009 下午 1:42
 * @Description :消息常量类
 **/
public class RabbitMqConstants {

    /**
     * exchange名称
     */
    public static final String DEFAULT_EXCHANGE = "clt-default";

    /**
     * 死信队列
     */
    public static final String DEFAULT_DEAD_LETTER_QUEUE_NAME = "clt.dead.letter.queue";

    /**
     * 死信转发队列
     */
    public static final String DEFAULT_REPEAT_TRADE_QUEUE_NAME = "clt.repeat.trade.queue";

    /**
     * 普通消息队列
     */
    public static final String NORMAL_QUEUE = "clt.normal.queue";

    /**
     * 短信队列名称
     */
    public static final String CLT_QUEUE_SMS = "clt-queue-sms";

    /**
     * 发放奖励队列名称
     */
    public static final String CLT_QUEUE_REWARD = "clt-queue-reward";

    /**
     * 发放认证奖励队列名称
     */
    public static final String CLT_QUEUE_AUTHENTICATION = "clt-queue-authentication";

    /**
     * topic_exchange名称
     */
    public static final String TOPIC_EXCHANGE = "amq-fanout";

    /**
     * 广播模式routingkey
     */
    public static final String CLT_QUEUE_ROUTINGKEY = "clt.amq.fanout.message";

}
