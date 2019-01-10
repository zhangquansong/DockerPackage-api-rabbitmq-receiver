package com.clt.api.annotation;

import java.lang.annotation.*;

/**
 * @ClassName : Sign
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:09
 * @Description :签名效验
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Sign {
}
