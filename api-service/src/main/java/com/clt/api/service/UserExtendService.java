package com.clt.api.service;

import com.baomidou.mybatisplus.service.IService;
import com.clt.api.entity.User;
import com.clt.api.result.UserLoginVO;
import com.clt.api.utils.RestResult;

/**
 * @ClassName : UserExtendService
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:25
 * @Description :用户复杂业务操作接口
 **/
public interface UserExtendService extends IService<User> {

    /**
     * 用户登录操作
     *
     * @param loginName 登录名
     * @param password  密码
     * @return
     */
    RestResult<UserLoginVO> userLogin(String loginName, String password);

}