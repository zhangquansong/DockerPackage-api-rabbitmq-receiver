package com.clt.api.annotation;

import com.clt.api.security.SensitiveType;

import java.lang.annotation.*;

/**
 * @ClassName : SensitiveInfo
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:08
 * @Description :属性脱敏注解
 **/
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SensitiveInfo {

    SensitiveType value();
}  