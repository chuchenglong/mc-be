package com.mc.enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum NationalityEnum {
    CHINA("n_100","中国"), USA("n_101","美国"), BRAZIL("n_102","巴西"), KOREA("n_103","韩国")
    , JAPAN("n_104","日本"), SINGAPORE("n_105","新加坡"), BRITAIN("n_106","英国"), FRANCE("n_107","法国")
    , GERMANY("n_108","德国"), THAILAND("n_109","泰国"), MYANMAR("n_110","缅甸"), RUSSIA("n_111","俄罗斯");

    private String key;
    private String value;

    NationalityEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (NationalityEnum e : NationalityEnum.values()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    public static List<String> getValues() {
        List<String> names = new ArrayList<>();
        for (NationalityEnum e : NationalityEnum.values()) {
            names.add(e.getValue());
        }
        return names;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> eList = new ArrayList<>();
        for (NationalityEnum e : NationalityEnum.values()) {
            Map<String, String> eMap = new HashMap<>();
            eMap.put("key", e.getKey());
            eMap.put("value", e.getValue());
            eList.add(eMap);
        }
        return eList;
    }

    public static String get(String key) {
        for (NationalityEnum e : NationalityEnum.values()) {
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
