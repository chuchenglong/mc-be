package com.mc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.springframework.util.StringUtils {
    public static boolean isNotEmpty(Object str) {
        return !isEmpty(str);
    }

    public static String deciphering(String ciphertext) {
        return Base64Utils.decode(ciphertext);
    }

    public static boolean isNumber(String str) {
        if (isEmpty(str))
            return false;
        Pattern pattern = Pattern.compile("-?[0-9]*.?[0-9]*");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean isNotNumber(String str) {
        return !isNumber(str);
    }

    // format规则：去掉首位/，原因是调度不同，首位/数可能会不同，统一清楚首位/
    public static String formatUri(String uri) {
        if (uri.indexOf("/") == 0) {
            uri = uri.replaceFirst("/", "");
            return formatUri(uri);
        }
        return  uri;
    }

    public static String hidePhone(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }

    public static String hideCertNo(String certNo) {
        return certNo.replaceAll("(\\d{4})\\d{10}(\\w{4})","$1*****$2");
    }

    public static void main(String[] args) {
//        String uri = "///login/in";
//        System.out.print(formatUri(uri));
        String uri = "41200201708080654";
        System.out.print(hideCertNo(uri));
    }
}
