package com.clt.api.annotation;

import java.lang.annotation.*;

/**
 * @ClassName : Login
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:07
 * @Description :登录效验
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
