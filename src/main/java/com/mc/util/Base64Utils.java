package com.mc.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Base64Utils {
    /**
     * @description Base64加密
     * @param str 待加密字符串
     * @return String 加密后字符串
     * @author chuchenglong
     * @datetime 2018-11-13 12:00:37
     * @version v1.0
    */
    public static String encode(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    /**
     * @description Base64加密
     * @param str 待解密字符串
     * @return String 解密后字符串
     * @author chuchenglong
     * @datetime 2018-11-13 12:00:37
     * @version v1.0
     */
    public static String decode(String str) {
        byte[] b = null;
        String result = null;
        if (str != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(str);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
