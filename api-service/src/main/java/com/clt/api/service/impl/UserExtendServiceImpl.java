package com.clt.api.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.clt.api.entity.User;
import com.clt.api.mapper.UserMapper;
import com.clt.api.result.UserLoginVO;
import com.clt.api.service.UserExtendService;
import com.clt.api.service.UserService;
import com.clt.api.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName : UserExtendServiceImpl
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:21
 * @Description :用户复杂业务操作Service实现类
 **/
@Service
@Transactional
public class UserExtendServiceImpl extends ServiceImpl<UserMapper, User> implements UserExtendService {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisExtendUtils redisExtendUtils;

    /**
     * @param loginName 登录名
     * @param password  密码
     * @return com.clt.api.utils.RestResult<com.clt.api.result.UserLoginVO>
     * @Author zhangquansong
     * @Date 2019/1/5 0005 下午 3:23
     * @Description : 根据登录名和密码查询可用用户，生成redis->token实现登录功能
     **/
    @Override
    public RestResult<UserLoginVO> userLogin(String loginName, String password) {
        User user = userService.findUserByLoginNameAndPassword(loginName, password);//查询用户信息
        if (!CheckUtils.isNotEmpty(user)) {
            return RestResult.errorResponse(RestConstants.BIZ_USER_LOGIN_10001.getCode(), RestConstants.BIZ_USER_LOGIN_10001.getMessage());
        }
        String token = UuidUtil.get32UUID();
        UserLoginVO userLoginVO = new UserLoginVO();
        BeanUtils.copyProperties(user, userLoginVO);
        userLoginVO.setToken(token);
        redisExtendUtils.setLoginToken(userLoginVO, token);//token操作异步
        return RestResult.successResponse(userLoginVO);
    }

}