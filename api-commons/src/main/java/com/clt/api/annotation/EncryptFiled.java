package com.clt.api.annotation;

import com.clt.api.security.DESEncryptType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName : EncryptFiled
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:07
 * @Description :自定义注解（定义自加密）：该注解请在xxParam.java文件中使用
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptFiled {

    DESEncryptType value();
}