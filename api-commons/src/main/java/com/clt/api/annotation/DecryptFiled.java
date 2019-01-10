package com.clt.api.annotation;

import com.clt.api.security.DESEncryptType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName : DecryptFiled
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:07
 * @Description :自定义注解（定义自解密）
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DecryptFiled {
    DESEncryptType value();
}