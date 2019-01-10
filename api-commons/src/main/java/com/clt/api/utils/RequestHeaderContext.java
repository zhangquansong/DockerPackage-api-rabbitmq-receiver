package com.clt.api.utils;

/**
 * @ClassName : RequestHeaderContext
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:17
 * @Description :声明 上下文获取app头部Header参数
 **/
public class RequestHeaderContext {

    private static final ThreadLocal<RequestHeaderContext> REQUEST_HEADER_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    public String appPackageName;// app包名：appPackageName

    public String version;// app版本号：version

    public String methodVersion;// 请求方法版本号：method_version 接口无多个版本方法，可以为空

    public String channel; // 渠道名称：channel

    public String channelSigna;// 渠道签名：channelSigna 与旧版app保持一致

    public String imeiSigna;// 签名：imeiSigna 与旧版app保持一致

    public String token;// 登录标识：token 未登录情况可以为空

    public String sign;// 请求签名：sign

    public String timestamp;// 时间戳：timestamp

    public String deviceId;// 设备编号imei：deviceId

    public String deviceIdSigna;// 设备ID签名：deviceIdSigna与旧版app保持一致

    public String deviceToken;// 设备标识：deviceToken

    public String deviceTokenSigna; // 设备标识签名：deviceTokenSigna与旧版app保持一致

    public String deviceType;// 移动设备类型：deviceType 1.安卓 2.IOS 3,PC 4,wap

    public String formToken;// 表单唯一标识

    public static RequestHeaderContext getInstance() {
        return REQUEST_HEADER_CONTEXT_THREAD_LOCAL.get();
    }

    public void setContext(RequestHeaderContext context) {
        REQUEST_HEADER_CONTEXT_THREAD_LOCAL.set(context);
    }

    public static void clean() {
        REQUEST_HEADER_CONTEXT_THREAD_LOCAL.remove();
    }

    private RequestHeaderContext(RequestHeaderContextBuild requestHeaderContextBuild) {
        this.token = requestHeaderContextBuild.token;
        this.appPackageName = requestHeaderContextBuild.appPackageName;
        this.version = requestHeaderContextBuild.version;
        this.methodVersion = requestHeaderContextBuild.methodVersion;
        this.channel = requestHeaderContextBuild.channel;
        this.channelSigna = requestHeaderContextBuild.channelSigna;
        this.imeiSigna = requestHeaderContextBuild.imeiSigna;
        this.token = requestHeaderContextBuild.token;
        this.sign = requestHeaderContextBuild.sign;
        this.timestamp = requestHeaderContextBuild.timestamp;
        this.deviceId = requestHeaderContextBuild.deviceId;
        this.deviceIdSigna = requestHeaderContextBuild.deviceIdSigna;
        this.deviceToken = requestHeaderContextBuild.deviceToken;
        this.deviceTokenSigna = requestHeaderContextBuild.deviceTokenSigna;
        this.deviceType = requestHeaderContextBuild.deviceType;
        this.formToken = requestHeaderContextBuild.formToken;
        setContext(this);
    }

    public static class RequestHeaderContextBuild {
        private String appPackageName;// app包名：appPackageName
        private String version;// app版本号：version
        private String methodVersion;// 请求方法版本号：method_version 接口无多个版本方法，可以为空
        private String channel; // 渠道名称：channel
        private String channelSigna;// 渠道签名：channelSigna 与旧版app保持一致
        private String imeiSigna;// 签名：imeiSigna 与旧版app保持一致
        private String token;// 登录标识：token 未登录情况可以为空
        private String sign;// 请求签名：sign
        private String timestamp;// 时间戳：timestamp
        private String deviceId;// 设备编号imei：deviceId
        private String deviceIdSigna;// 设备ID签名：deviceIdSigna与旧版app保持一致
        private String deviceToken;// 设备标识：deviceToken
        private String deviceTokenSigna; // 设备标识签名：deviceTokenSigna与旧版app保持一致
        private String deviceType;// 移动设备类型：deviceType 1.安卓 2.IOS
        public String formToken;// 表单唯一标识

        public RequestHeaderContextBuild appPackageName(String appPackageName) {
            this.appPackageName = appPackageName;
            return this;
        }

        public RequestHeaderContextBuild version(String version) {
            this.version = version;
            return this;
        }

        public RequestHeaderContextBuild methodVersion(String methodVersion) {
            this.methodVersion = methodVersion;
            return this;
        }

        public RequestHeaderContextBuild channel(String channel) {
            this.channel = channel;
            return this;
        }

        public RequestHeaderContextBuild channelSigna(String channelSigna) {
            this.channelSigna = channelSigna;
            return this;
        }

        public RequestHeaderContextBuild imeiSigna(String imeiSigna) {
            this.imeiSigna = imeiSigna;
            return this;
        }

        public RequestHeaderContextBuild sign(String sign) {
            this.sign = sign;
            return this;
        }

        public RequestHeaderContextBuild timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public RequestHeaderContextBuild deviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public RequestHeaderContextBuild deviceIdSigna(String deviceIdSigna) {
            this.deviceIdSigna = deviceIdSigna;
            return this;
        }

        public String getFormToken() {
            return formToken;
        }

        public void setFormToken(String formToken) {
            this.formToken = formToken;
        }

        public RequestHeaderContextBuild deviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
            return this;
        }

        public RequestHeaderContextBuild deviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }

        public RequestHeaderContextBuild deviceTokenSigna(String deviceTokenSigna) {
            this.deviceTokenSigna = deviceTokenSigna;
            return this;
        }

        public RequestHeaderContextBuild token(String token) {
            this.token = token;
            return this;
        }

        public RequestHeaderContext bulid() {
            return new RequestHeaderContext(this);
        }
    }
}