package com.mc.enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum WhiteTypeEnum {
    TOKEN("wt_100","服务白名单（免token验证）"),
    USER("wt_101","用户白名单（免功能验证）");

    private String key;
    private String value;

    WhiteTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (WhiteTypeEnum e : WhiteTypeEnum.values()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    public static List<String> getValues() {
        List<String> names = new ArrayList<>();
        for (WhiteTypeEnum e : WhiteTypeEnum.values()) {
            names.add(e.getValue());
        }
        return names;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> eList = new ArrayList<>();
        for (WhiteTypeEnum e : WhiteTypeEnum.values()) {
            Map<String, String> eMap = new HashMap<>();
            eMap.put("key", e.getKey());
            eMap.put("value", e.getValue());
            eList.add(eMap);
        }
        return eList;
    }

    public static String get(String key) {
        for (WhiteTypeEnum e : WhiteTypeEnum.values()) {
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
