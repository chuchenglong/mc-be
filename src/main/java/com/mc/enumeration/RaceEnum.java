package com.mc.enumeration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum RaceEnum {
    HAN("r_100","汉族"), ACHANG("r_101","阿昌族"), BAI("r_102","白族"), BAOAN("r_103","保安族")
    , BULANG("r_104","布朗族"), BUYI("r_105","布依族"), CHAOXIAN("r_106","朝鲜族"), DAWOER("r_107","达斡尔族")
    , DAI("r_108","傣族"), DEANG("r_109","德昂族"), TONG("r_110","侗族"), DONGXIANG("r_111","东乡族")
    , DULONG("r_112","独龙族"), ELUNCHUN("r_113","鄂伦春族"), ELUOSI("r_114","俄罗斯族"), EWENKE("r_115","鄂温克族")
    , GAOSHAN("r_116","高山族"), YILAO("r_117","仡佬族"), HANI("r_118","哈尼族"), HASAKE("r_119","哈萨克族")
    , HAOZHE("r_120","赫哲族"), HUI("r_121","回族"), JINUO("r_122","基诺族"), JING("r_123","京族")
    , JINGPO("r_124","景颇族"), KEERKEZI("r_125","柯尔克孜族"), LAHU("r_126","拉祜族"), NI("r_127","黎族")
    , LILI("r_128","傈僳族"), NUOBA("r_129","珞巴族"), MAN("r_130","满族"), MAONAN("r_131","毛南族")
    , MENBA("r_132","门巴族"), MENGGU("r_133","蒙古族"), MIAO("r_134","苗族"), MULAO("r_135","仫佬族")
    , NAXI("r_136","纳西族"), NU("r_137","怒族"), PUMI("r_138","普米族"), QIANG("r_139","羌族")
    , SALA("r_140","撒拉族"), SHE("r_141","畲族"), SHUI("r_142","水族"), TAJIKE("r_143","塔吉克族")
    , TATAER("r_144","塔塔尔族"), TU("r_145","土族"), TUJIA("r_146","土家族"), WA("r_147","佤族")
    , WEIWUER("r_148","维吾尔族"), WUZIBIEKE("r_149","乌孜别克族"), XIBO("r_150","锡伯族"), YAO("r_151","瑶族")
    , YI("r_152","彝族"), YUGU("r_153","裕固族"), ZANG("r_154","藏族"), ZHUANG("r_155","壮族");

    private String key;
    private String value;

    RaceEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static List<String> getKeys() {
        List<String> keys = new ArrayList<>();
        for (RaceEnum e : RaceEnum.values()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    public static List<String> getValues() {
        List<String> names = new ArrayList<>();
        for (RaceEnum e : RaceEnum.values()) {
            names.add(e.getValue());
        }
        return names;
    }

    public static List<Map<String, String>> getAll() {
        List<Map<String, String>> eList = new ArrayList<>();
        for (RaceEnum e : RaceEnum.values()) {
            Map<String, String> eMap = new HashMap<>();
            eMap.put("key", e.getKey());
            eMap.put("value", e.getValue());
            eList.add(eMap);
        }
        return eList;
    }

    public static String get(String key) {
        for (RaceEnum e : RaceEnum.values()) {
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
