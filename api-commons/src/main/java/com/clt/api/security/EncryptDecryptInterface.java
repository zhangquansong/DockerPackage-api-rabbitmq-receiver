package com.clt.api.security;

/**
 * @ClassName : EncryptDecryptInterface
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:15
 * @Description :自加密，自解密接口
 **/
public interface EncryptDecryptInterface {
    <T> T encryptSelf();
}
