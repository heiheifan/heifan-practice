package com.heifan.common.utils;

import cn.hutool.core.util.RandomUtil;

/**
 * 通用工具类
 *
 * @author HiF
 * @date 2021年11月19日
 */
public class CommonUtil {
    /**
     * 随机指定位数字符串（英文+数字）
     *
     * @param length
     *            长度
     * @return String
     */
    public static String randomString(int length) {
        if (length <= 0) {
            return "";
        }
        return RandomUtil.randomString(length);
    }
}
