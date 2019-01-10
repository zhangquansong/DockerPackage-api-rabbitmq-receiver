package com.clt.api.utils;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName : CheckUtils
 * @Author : zhangquansong
 * @Date : 2019/1/5 0005 下午 3:17
 * @Description : 检查工具类
 **/
public class CheckUtils {

    public static final String COMMON_FIELD = "flowID,initiator,";

    /**
     * 验证对象是否为NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
     *
     * @param obj     被验证的对象
     * @param message 异常信息
     */
    @SuppressWarnings("rawtypes")
    public static void notEmpty(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message + " must be specified");
        }
        if (obj instanceof String && obj.toString().trim().length() == 0) {
            throw new IllegalArgumentException(message + " must be specified");
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            throw new IllegalArgumentException(message + " must be specified");
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            throw new IllegalArgumentException(message + " must be specified");
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            throw new IllegalArgumentException(message + " must be specified");
        }
    }

    /**
     * 字符串正则表达式验证
     *
     * @param rexp 正则表达式
     * @param str  字符串
     * @return 是否通过
     */
    public static boolean isPattern(String rexp, String str) {
        Pattern p = Pattern.compile(rexp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 字符串去掉前后空格
     *
     * @param str
     * @return
     */
    public static String isTrim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * 字符串去掉所有空格
     *
     * @param str
     * @return
     */
    public static String isReplace(String str) {
        if (isNull(str)) {
            return "";
        }
        String str2 = str.replaceAll(" ", "");
        return str2;
    }

    /**
     * 去掉所有空格后，是否为空
     *
     * @param str
     * @return
     */
    public static boolean isReplaceToNull(String str) {
        if (isNull(str)) {
            return true;
        }
        String str2 = str.replaceAll(" ", "");
        if (isNull(str2)) {
            return true;
        }
        return false;
    }

    /**
     * 是否包含中文
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        Pattern p = Pattern.compile("[\\u4e00-\\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean isNumOrLetter(String str) {
        return isPattern("^[a-zA-Z0-9]+$", str);
    }

    /**
     * 计算字符串长度(可同时字母和汉字，字母占一个字符，汉字占2个字符)
     *
     * @param str
     * @return
     */
    public static int strLen(String str) {
        int len = 0;
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        for (int i = 0; i < str.length(); i++) {
            boolean bool = isChinese("" + str.charAt(i));
            if (bool) {
                len += 2;
            } else {
                len += 1;
            }
        }
        return len;
    }

    /**
     * 是否为纯数字
     *
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        return isPattern("[0-9]{1,}", str);
    }

    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        if (StringUtils.isBlank(str)) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串最小长度
     *
     * @param str
     * @param minlength 最小长度
     * @return
     */
    public static boolean minLen(String str, int minlength) {
        int len = strLen(str);
        if (len < minlength) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串最大长度
     *
     * @param str
     * @param maxlength 最大长度
     * @return
     */
    public static boolean maxLen(String str, int maxlength) {
        int len = strLen(str);
        if (len > maxlength) {
            return true;
        }
        return false;
    }

    /**
     * 用户名是否错误-只能为字母、数字或中文
     *
     * @param str
     * @return
     */
    public static boolean isUsername(String str) {
        String rexp = "^([\\u4e00-\\u9fa5]|[a-zA-Z0-9])+$";
        boolean bool = isPattern(rexp, str);
        if (bool) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否是手机号码(错误返回true,正确返回false)
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        String rexp = "^1[0-9]{10}$";
        boolean bool = isPattern(rexp, str);
        if (bool) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断银行卡号是否错误
     *
     * @param cardId
     * @return
     */
    public static boolean isBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if (bit == 'N') {
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if (nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0 || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if (j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
    }

    /**
     * 判断邮箱是否错误
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        String rexp = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        boolean bool = isPattern(rexp, str);
        if (bool) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 是否由字母、数字或下划线组成
     *
     * @param password
     */
    public static boolean isPassword(String password) {
        Pattern pattern = Pattern.compile("^\\w{6,16}$");
        return pattern.matcher(password).matches();
    }

    /**
     * 简单身份证号校验
     *
     * @param str 身份证号
     * @return 格式是否正确
     */
    private static boolean checkIdentitycard(String str) {
        int len = strLen(str);
        // 15位身份证号为纯数字
        if (len == 15) {
            if (!isNum(str)) {
                return false;
            }
        } else if (len == 18) {
            // 18位身份证号码验证，前17位必须为数字
            String subStr = str.substring(0, 17);
            if (!isNum(subStr)) {
                return false;
            }
            // 最后一位必须为数字或者X
            String lastStr = str.substring(17);
            if (!isNum(lastStr) && !StringUtils.equals("X", lastStr.toUpperCase())) {
                return false;
            }
        }
        return true;
    }


    /**
     * 判断金额是否为整数
     *
     * @param money
     * @return
     * @date 2018年5月9日 上午10:26:36
     * @author zhaoyp@boruijinfu.com
     */
    public static Boolean isMoney(String money) {
        boolean bool = isPattern("^[0-9]+(\\.[0-9]{1,2})?$", money);
        if (bool) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断带有2位小数点的金额
     *
     * @param str
     * @return
     * @date 2018年5月25日 下午2:24:57
     * @author zhaoyp@boruijinfu.com
     */
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match = pattern.matcher(str);
        if (match.matches() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 判断是否非空
     */
    public static boolean isNotEmpty(Object obj) {
        if (obj instanceof Map) {
            return obj != null && ((Map<?, ?>) obj).size() > 0;
        }
        if (obj instanceof Collection) {
            return obj != null && ((Collection<?>) obj).size() > 0;
        }
        return obj != null && !"".equals(obj.toString());
    }

    /**
     * 一次判断多个对象是否为null(为null或者“”时返回false).
     * 当传入的类型是List时，会验证list的长度，如果长度为0也会返回false
     *
     * @param objs
     * @return
     */
    public static boolean isMultilNotEmpty(Object... objs) {
        for (Object obj : objs) {
            if (!isNotEmpty(obj)) {
                return false;
            }
        }
        return true;
    }
}
