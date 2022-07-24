package cn.edu.syu.utils;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * 工具类
 */
public class util {
    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumber(String str) {
        if (str == null) return false;
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
