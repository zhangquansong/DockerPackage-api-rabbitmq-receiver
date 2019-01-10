package com.clt.api.helper;

import com.clt.api.utils.Constants;
import com.clt.api.utils.RequestHeaderContext;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName : InitHeaderContext
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 4:09
 * @Description :初始化header参数
 **/
public class InitHeaderContext {
    public static void init(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        new RequestHeaderContext.RequestHeaderContextBuild().token(req.getHeader(Constants.APP_TOKEN)).appPackageName(req.getHeader(Constants.APP_PACKAGE_NAME)).version(req.getHeader(Constants.APP_VERSION))
                .deviceType(req.getHeader(Constants.APP_DEVICE_TYPE)).deviceToken(req.getHeader(Constants.APP_DEVICE_TOKEN)).deviceIdSigna(req.getHeader(Constants.APP_DEVICEID_SIGNA))
                .deviceId(req.getHeader(Constants.APP_DEVICE_ID)).timestamp(req.getHeader(Constants.APP_TIMESTAMP)).sign(req.getHeader(Constants.APP_SIGN)).imeiSigna(req.getHeader(Constants.APP_IMEI_SIGNA))
                .channelSigna(req.getHeader(Constants.APP_CHANNEL_SIGNA)).channel(req.getHeader(Constants.APP_CHANNEL)).methodVersion(req.getHeader(Constants.APP_METHOD_VERSION)).deviceTokenSigna(Constants.APP_DEVICE_TOKEN_SIGNA).bulid();
    }
}
