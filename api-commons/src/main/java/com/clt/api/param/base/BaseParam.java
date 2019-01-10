package com.clt.api.param.base;

import com.clt.api.annotation.DecryptFiled;
import com.clt.api.annotation.EncryptFiled;
import com.clt.api.security.DESEncrypt;
import com.clt.api.security.DESEncryptType;
import com.clt.api.security.EncryptDecryptInterface;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * @ClassName : BaseParam
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:13
 * @Description :继承该类的子类具有自加密、自解密功能
 **/
public class BaseParam implements Cloneable, EncryptDecryptInterface {

    /**
     * 拷贝一个对象，并对新对象进行加密 该方法主要用在日志打印上，可防止原对象被加密而影响程序执行
     *
     * @param <T>
     * @return
     */
    public <T extends BaseParam> T cloneAndEncrypt() {
        T cloneT = null;
        try {
            cloneT = (T) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
        if (cloneT != null)
            return cloneT.encryptSelf();
        throw new RuntimeException("拷贝对象异常");
    }

    /**
     * 重写clone方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 实现自加密
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> T encryptSelf() {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        try {
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(EncryptFiled.class)) {
                        field.setAccessible(true);
                        String fieldValue = (String) field.get(this);
                        if (StringUtils.isNotEmpty(fieldValue)) {
                            DESEncryptType formatType = field.getAnnotation(EncryptFiled.class).value();
                            switch (formatType) {
                                case USER_NAME: {
                                    fieldValue = DESEncrypt.jiaMiUsername(fieldValue);
                                    break;
                                }
                                case ID_CARD: {
                                    fieldValue = DESEncrypt.jiaMiIdCard(fieldValue);
                                    break;
                                }
                                case PASSWORD: {
                                    fieldValue = DESEncrypt.jiaMiPassword(fieldValue);
                                    break;
                                }
                                case MOBILE_PHONE: {
                                    fieldValue = DESEncrypt.jiaMiUsername(fieldValue);
                                    break;
                                }
                                case BANK_CARD: {
                                    fieldValue = DESEncrypt.jiaMiBankCard(fieldValue);
                                }
                                default:
                                    break;
                            }
                            field.set(this, fieldValue);
                        }
                        field.setAccessible(false);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (T) this;
    }

    /**
     * 实现自解密(Form中不提供此方法)
     *
     * @param <T>
     * @return
     */
    private <T> T decryptSelf() {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        try {
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    if (field.isAnnotationPresent(DecryptFiled.class)) {
                        field.setAccessible(true);
                        String fieldValue = (String) field.get(this);
                        if (StringUtils.isNotEmpty(fieldValue)) {
                            DESEncryptType formatType = field.getAnnotation(DecryptFiled.class).value();
                            switch (formatType) {
                                case USER_NAME: {
                                    fieldValue = DESEncrypt.jieMiUsername(fieldValue);
                                    break;
                                }
                                case ID_CARD: {
                                    fieldValue = DESEncrypt.jieMiIdCard(fieldValue);
                                    break;
                                }
                                case MOBILE_PHONE: {
                                    fieldValue = DESEncrypt.jieMiUsername(fieldValue);
                                    break;
                                }
                                case BANK_CARD: {
                                    fieldValue = DESEncrypt.jieMiBankCard(fieldValue);
                                }
                                default:
                                    break;
                            }
                            field.set(this, fieldValue);
                        }
                        field.setAccessible(false);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (T) this;
    }
}
