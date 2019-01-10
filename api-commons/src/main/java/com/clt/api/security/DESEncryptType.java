package com.clt.api.security;


/**
 * @ClassName : DESEncryptType
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:15
 * @Description :加密解密类型枚举
 **/
public enum DESEncryptType {
    /**
     * 用户名
     */
    USER_NAME,
    /**
     * 密码
     */
    PASSWORD,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 手机号
     */
    MOBILE_PHONE,
    /**
     * 银行卡
     */
    BANK_CARD;
}  