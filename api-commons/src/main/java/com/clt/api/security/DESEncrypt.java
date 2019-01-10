package com.clt.api.security;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @ClassName : DESEncrypt
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:14
 * @Description :DES加密工具类
 **/
@Slf4j
public class DESEncrypt {

    /**
     * 加密
     *
     * @param src 要加密的数据
     * @param key 加密取用的key。八位字符串
     * @return
     * @throws Exception
     */
    public static final String encrypt(String src, String key) throws Exception {
        if (src == null)
            return null;
        if ("".equals(src))
            return "";
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        byte bb[] = cipher.doFinal(src.getBytes());
        StringBuffer buff = new StringBuffer(bb.length);
        String sTemp;
        for (int i = 0; i < bb.length; i++) {
            sTemp = Integer.toHexString(0xFF & bb[i]);
            if (sTemp.length() < 2) {
                buff.append(0);
            }
            buff.append(sTemp.toUpperCase());

        }
        return buff.toString();
    }

    /**
     * 解密
     *
     * @param src 要解密的数据源
     * @param key 加密时取用的key，八位字符串
     * @return
     * @throws Exception
     */
    public static final String decrypt(String src, String key) throws Exception {
        if (src == null)
            return null;
        if ("".equals(src))
            return "";
        try {
            int len = (src.length() / 2);
            byte[] result = new byte[len];
            char[] achar = src.toString().toCharArray();
            for (int j = 0; j < len; j++) {
                int pos = j * 2;
                result[j] = ((byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1])));
            }
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            // 从原始密匙数据创建一个DESKeySpec对象
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
            // 一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(dks);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
            // 现在，获取数据并解密
            // 正式执行解密操作
            return new String(cipher.doFinal(result));
        } catch (Exception e) {
            log.error("字符非法，解析错误:{}, 返回原字符串：{}", e.getMessage(), src);
        }
        return src;

    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * 登录密码;支付密码;
     *
     * @param string 需要加密的字符串;
     * @return 加密过后的字符串;
     * @throws Exception
     */
    public static String jiaMiPassword(String string) {
        try {
            String str = encrypt(string, "clt*_*@@");
            String str2 = encrypt(str, "clt");
            return str2;
        } catch (Exception e) {
            log.error("登录密码加密异常：", e);
        }
        return null;
    }

    /**
     * 解密字符串;<br>
     * 登录密码;支付密码;
     *
     * @param string 加密过后的字符串;
     * @return 解密过后的字符串;
     * @throws Exception
     */
    public static String jieMiPassword(String string) {
        String de2 = null;
        try {
            String de = decrypt(string, "clt");
            de2 = decrypt(de, "clt*_*@@");
        } catch (Exception e) {
            log.error("登录密码解密异常：", e);
        }
        return de2;
    }

    /**
     * 加密字符串;<br>
     * 帐号,手机号码,邮箱;
     *
     * @param string 需要加密的字符串;
     * @return 加密过后的字符串;
     * @throws Exception
     */
    public static String jiaMiUsername(String string) {
        try {
            String str = encrypt(string, "userName");
            String str2 = encrypt(str, "clt*_*@@");
            return str2;
        } catch (Exception e) {
            log.error("用户名加密异常：", e);
        }
        return null;
    }

    /**
     * 解密字符串;<br>
     * 帐号,手机号码,邮箱;
     *
     * @param string 加密过后的字符串;
     * @return 解密过后的字符串;
     * @throws Exception
     */
    public static String jieMiUsername(String string) {
        String de2 = null;
        try {
            String de = decrypt(string, "clt*_*@@");
            de2 = decrypt(de, "userName");
        } catch (Exception e) {
            log.error("用户名解密异常：", e);
        }
        return de2;
    }

    /**
     * 加密字符串;<br>
     * 身份证号
     *
     * @param string 需要加密的字符串;
     * @return 加密过后的字符串;
     * @throws Exception
     */
    public static String jiaMiIdCard(String string) {
        try {
            String str = encrypt(string, "@*IdCard*");
            String str2 = encrypt(str, "cltCards");
            return str2;
        } catch (Exception e) {
            log.error("身份证加密异常：", e);
        }
        return null;
    }

    /**
     * 解密字符串;<br>
     * 身份证号
     *
     * @param string 加密过后的字符串;
     * @return 解密过后的字符串;
     * @throws Exception
     */
    public static String jieMiIdCard(String string) {
        String de2 = null;
        try {
            String de = decrypt(string, "cltCards");
            de2 = decrypt(de, "@*IdCard*");
        } catch (Exception e) {
            log.error("身份证解密异常：", e);
        }
        return de2;
    }

    /**
     * 加密字符串;<br>
     * 银行卡
     *
     * @param string 需要加密的字符串;
     * @return 加密过后的字符串;
     * @throws Exception
     */
    public static String jiaMiBankCard(String string) {
        try {
            String str = encrypt(string, "cltBanks");
            String str2 = encrypt(str, "$_$_bank");
            return str2;
        } catch (Exception e) {
            log.error("银行卡加密异常：", e);
        }
        return null;
    }

    /**
     * 解密字符串;<br>
     * 银行卡
     *
     * @param string 加密过后的字符串;
     * @return 解密过后的字符串;
     * @throws Exception
     */
    public static String jieMiBankCard(String string) {
        String de2 = null;
        try {
            String de = decrypt(string, "$_$_bank");
            de2 = decrypt(de, "cltBanks");
        } catch (Exception e) {
            log.error("银行卡解密异常：", e);
        }
        return de2;
    }

}
