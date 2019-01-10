package com.clt.api.mq;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ClassName : RewardMq
 * @Author : zhangquansong
 * @Date : 2019/1/9 0009 下午 2:50
 * @Description :奖励mq对象
 **/
@Getter
@Setter
public class RewardMq {

    private Long usersId; // 用户编号

    private String productId; //产品ID

    private String mobile; // 手机号

    private String type; // 奖励类型

    private String des; // 奖励描述

    private Long money; // 投资金额

    private Date insertTime; // 投资时间

    public RewardMq(Long usersId, String type, String des) {
        super();
        this.usersId = usersId;
        this.type = type;
        this.des = des;
    }

    public RewardMq(Long usersId, String mobile, String type, String des, Long money, Date insertTime) {
        super();
        this.usersId = usersId;
        this.mobile = mobile;
        this.type = type;
        this.des = des;
        this.money = money;
        this.insertTime = insertTime;
    }

    public RewardMq(Long usersId, String productId, String mobile, String type, String des, Long money) {
        super();
        this.usersId = usersId;
        this.productId = productId;
        this.mobile = mobile;
        this.type = type;
        this.des = des;
        this.money = money;
    }

}
