package com.clt.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clt.api.entity.BlackUser;
import com.clt.api.entity.User;
import com.clt.api.mapper.BlackUserMapper;
import com.clt.api.service.BlackUserExtendService;
import com.clt.api.service.BlackUserService;
import com.clt.api.service.UserService;
import com.clt.api.utils.Constants;
import com.clt.api.utils.RedisExtendUtils;
import com.clt.api.utils.RestResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName : BlackUserExtendServiceImpl
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 5:38
 * @Description : 黑名单用户复杂业务操作业务层
 **/
@Service
@Transactional
public class BlackUserExtendServiceImpl extends ServiceImpl<BlackUserMapper, BlackUser> implements BlackUserExtendService {


    @Autowired
    private BlackUserService blackUserService;
    @Autowired
    private UserService userService;
    @Autowired
    private RedisExtendUtils redisExtendUtils;

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
    @Override
    public RestResult<BlackUser> addBlackUserWithRedis(User user, String description, String ip, String imei) {
        BlackUser blackUser = new BlackUser();
        BeanUtils.copyProperties(user, blackUser);
        blackUser.setBlackUserDescription(description);
        blackUser.setCreateTime(new Date());
        blackUser.setId(null);
        blackUser.setUpdateTime(new Date());
        blackUser.setBlackUserIp(ip);
        blackUser.setBlackUserImei(imei);
        blackUser.setUserId(user.getId());

        blackUserService.create(blackUser);//插入黑名单信息

        user.setUpdateTime(new Date());
        user.setUserStatus(Constants.USER_STATUS_1);
        userService.edit(user);//修改用户为黑名单状态

        redisExtendUtils.loginOutToken(user.getId());//清除token

        return RestResult.successResponse(blackUser);

    }
}