package com.mc.model;

import javax.persistence.*;

@Table(name = "t_white_info")
public class WhiteInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 白名单类型，WhiteTypeEnum
     */
    @Column(name = "white_type")
    private String whiteType;

    /**
     * 白名单值
     */
    @Column(name = "white_value")
    private String whiteValue;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取白名单类型，WhiteTypeEnum
     *
     * @return white_type - 白名单类型，WhiteTypeEnum
     */
    public String getWhiteType() {
        return whiteType;
    }

    /**
     * 设置白名单类型，WhiteTypeEnum
     *
     * @param whiteType 白名单类型，WhiteTypeEnum
     */
    public void setWhiteType(String whiteType) {
        this.whiteType = whiteType;
    }

    /**
     * 获取白名单值
     *
     * @return white_value - 白名单值
     */
    public String getWhiteValue() {
        return whiteValue;
    }

    /**
     * 设置白名单值
     *
     * @param whiteValue 白名单值
     */
    public void setWhiteValue(String whiteValue) {
        this.whiteValue = whiteValue;
    }
}