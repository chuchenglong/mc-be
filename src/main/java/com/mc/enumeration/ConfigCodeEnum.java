package com.mc.enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ConfigCodeEnum {
    TOKEN_TIMEOUT("token_timeout", "token超时时间"),
    SUPPORT_IMAGE_TYPE("support_image_type", "支持的图片格式"),
    TOKEN_ON_OFF("token_on_off", "token验证开关"),
    SERVER_ON_OFF("server_on_off", "service验证开关"),
    ROLE_ON_OFF("role_on_off", "role验证开关"),
    LOGIN_WRONG_TIMES("login_wrong_times","登录密码错误最大次数");

    private String key;
    private String value;

    ConfigCodeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (ConfigCodeEnum e : ConfigCodeEnum.values()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    public static List<String> getValues() {
        List<String> names = new ArrayList<>();
        for (ConfigCodeEnum e : ConfigCodeEnum.values()) {
            names.add(e.getValue());
        }
        return names;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> eList = new ArrayList<>();
        for (ConfigCodeEnum e : ConfigCodeEnum.values()) {
            Map<String, String> eMap = new HashMap<>();
            eMap.put("key", e.getKey());
            eMap.put("value", e.getValue());
            eList.add(eMap);
        }
        return eList;
    }

    public static String get(String key) {
        for (ConfigCodeEnum e : ConfigCodeEnum.values()) {
            if (e.getKey().equals(key))
                return e.getValue();
        }
        return null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
