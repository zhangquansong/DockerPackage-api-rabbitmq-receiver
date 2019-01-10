package com.clt.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.clt.api.entity.BlackUser;
import com.clt.api.entity.User;
import com.clt.api.utils.RestResult;

/**
 * @ClassName : BlackUserExtendService
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 5:33
 * @Description :黑名单复杂业务操作接口
 **/
public interface BlackUserExtendService extends IService<BlackUser> {

    /**
     * @param user        用户信息
     * @param description 描述
     * @param ip          ip地址
     * @param imei        imei
     * @return com.clt.api.utils.RestResult<com.clt.api.entity.BlackUser>
     * @Description :  redis监控用户防刷接口机制添加黑名单用户
     * @Author zhangquansong
     * @Date 2019/1/5 0005 下午 6:08
     **/
    RestResult<BlackUser> addBlackUserWithRedis(User user, String description, String ip, String imei);
}