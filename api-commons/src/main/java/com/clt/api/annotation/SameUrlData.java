package com.clt.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName : SameUrlData
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:08
 * @Description :一个用户 相同url 同时提交 相同数据 验证
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SameUrlData {

}
  
      