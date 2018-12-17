package com.mc.constant;

/**
 * @author ChenglongChu
 * @description 基础常量
 * @create 2018/5/28 16:52
 */
public class CommConstant {
    // 常量类禁用构造函数
    private CommConstant() {
        super();
    }

    // redis and config
    public static final String TOKEN_TIMEOUT = "token_timeout";
    public static final String LOGIN_WRONG_TIMES = "login_wrong_times";
    public static final String SUPPORT_IMAGE_TYPE = "support_image_type";
    public static final String TOKEN_ON_OFF = "token_on_off";
    public static final String SERVICE_ON_OFF = "service_on_off";
    public static final String ON = "on";
    public static final String OFF = "off";

    // request
    public static final String HEADER_TOKEN = "token";
    public static final String METHOD_OPTIONS = "OPTIONS";

    // system
    public static final String PROJECT_NAME = "mc-be";
    public static final int SYSTEM_ID = 10000000;
    // verification code
    public static final String VC = "vc";

    // number
    public static final int NUM_MINUS_ONE = -1;
    public static final int NUM_ZERO = 0;
    public static final int NUM_ONE = 1;
    public static final int NUM_TWO = 2;
    public static final int NUM_THREE = 3;
    public static final int NUM_FOUR = 4;
    public static final int NUM_FIVE = 5;
    public static final int NUM_SIX = 6;
    public static final int NUM_SEVEN = 7;
    public static final int NUM_EIGHT = 8;
    public static final int NUM_NINE = 9;
    public static final int NUM_TEN = 10;

    // sign
    public static final String STRING_EMPTY = "";

    // date format
    public static final String DATE_FORMAT_ONE = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DATE_FORMAT_TWO = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_THREE = "yyyy-MM-dd";

    public static final String DOC = ".doc";
    public static final String DOCX = ".docx";
}
