package com.clt.api.security;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.clt.api.annotation.DecryptFiled;
import com.clt.api.annotation.EncryptFiled;
import com.clt.api.annotation.SensitiveInfo;
import com.clt.api.utils.SensitiveUtil;

import java.lang.reflect.Field;

/**
 * @ClassName : SensitivePropertyFilter
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:15
 * @Description :实现FastJsonValueFilter进行脱敏
 **/
public class SensitivePropertyFilter implements ValueFilter {
    private Field field = null;

    @Override
    public Object process(Object object, String propertyName, Object propertyValue) {
        try {
            field = object.getClass().getDeclaredField(propertyName);
            propertyValue = getFormartValue(field, propertyValue);
        } catch (NoSuchFieldException e) {
            return propertyValue;
        } catch (SecurityException e) {
            return propertyValue;
        }
        return propertyValue;
    }

    /**
     * 对自定义注解进行处理
     *
     * @param field
     * @param value
     * @return
     * @date 2018年4月26日 下午2:33:23
     * @author wangj@boruijinfu.com
     */
    private static Object getFormartValue(Field field, Object value) {
        // 自加密：如果属性字段已经被加密注解修饰过，则不进行脱敏操作
        if (field.isAnnotationPresent(EncryptFiled.class)) {
            return value;
        }
        // 自解密
        if (field.isAnnotationPresent(DecryptFiled.class)) {
            value = decryption(field, value);
        }
        // 脱敏
        if (field.isAnnotationPresent(SensitiveInfo.class)) {
            SensitiveType formatType = field.getAnnotation(SensitiveInfo.class).value();
            // 进行格式化
            value = getFormartValue(formatType, value);
        }
        return value;
    }

    /**
     * 自解密
     *
     * @param field
     * @param value
     * @return
     * @date 2018年4月26日 下午2:31:58
     * @author wangj@boruijinfu.com
     */
    private static Object decryption(Field field, Object value) {
        // 进行格式化
        String formatValue = "";
        if (value == null) {
            return "";
        } else if (value instanceof String) {
            formatValue = (String) value;
        }
        DESEncryptType formatType = field.getAnnotation(DecryptFiled.class).value();
        switch (formatType) {
            case USER_NAME: {
                value = DESEncrypt.jieMiUsername(formatValue);
                break;
            }
            case ID_CARD: {
                value = DESEncrypt.jieMiIdCard(formatValue);
                break;
            }
            case MOBILE_PHONE: {
                value = DESEncrypt.jieMiUsername(formatValue);
                break;
            }
            case BANK_CARD: {
                value = DESEncrypt.jieMiBankCard(formatValue);
            }
            default:
                break;
        }
        return value;
    }

    /**
     * 脱敏
     *
     * @param formatType
     * @param value
     * @return
     * @date 2018年4月26日 下午2:32:54
     * @author wangj@boruijinfu.com
     */
    private static Object getFormartValue(SensitiveType formatType, Object value) {
        // 进行格式化
        String formatValue = "";
        if (value == null) {
            return "";
        } else if (value instanceof String) {
            formatValue = (String) value;
        }
        switch (formatType) {
            case CHINESE_NAME: {
                return SensitiveUtil.chineseName(formatValue);
            }
            case ID_CARD: {
                return SensitiveUtil.identificationNum(formatValue);
            }
            case FIXED_PHONE: {
                return SensitiveUtil.fixedPhone(formatValue);
            }
            case MOBILE_PHONE: {
                return SensitiveUtil.mobilePhone(formatValue);
            }
            case ADDRESS: {
                return SensitiveUtil.address(formatValue, 4);
            }
            case EMAIL: {
                return SensitiveUtil.email(formatValue);
            }
            case BANK_CARD: {
                return SensitiveUtil.bankCard(formatValue);
            }
            case CNAPS_CODE: {
                return SensitiveUtil.cnapsCode(formatValue);
            }
        }
        return value;
    }

}