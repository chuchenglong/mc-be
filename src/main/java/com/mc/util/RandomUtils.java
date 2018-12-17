package com.mc.util;

import com.mc.constant.CommConstant;

import java.util.Random;

public class RandomUtils {
    public static String createRandomNumByDigit(int digit) {
        Random random = new Random();
        StringBuffer result = new StringBuffer();
        for (int i=0; i<digit; i++)
            result.append(random.nextInt(CommConstant.NUM_TEN));
        return result.toString();
    }

    public static String createRandomStringByDigit(int digit) {
        Random random = new Random();
        String sources = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = sources.length() - CommConstant.NUM_ONE;
        StringBuffer result = new StringBuffer();
        for (int i=0; i<digit; i++)
            result.append(sources.charAt(random.nextInt(length)) + "");
        return result.toString();
    }
}
