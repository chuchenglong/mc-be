package com.mc.model;

import javax.persistence.*;

@Table(name = "t_config_info")
public class ConfigInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 配置code
     */
    @Column(name = "config_code")
    private String configCode;

    /**
     * 配置名称
     */
    @Column(name = "config_name")
    private String configName;

    /**
     * 配置值
     */
    @Column(name = "config_value")
    private String configValue;

    /**
     * 配置类型，ConfigTypeEnum
     */
    @Column(name = "config_type")
    private String configType;

    /**
     * 业务类型，BizTypeEnum
     */
    @Column(name = "biz_type")
    private String bizType;

    /**
     * 标签，ConfigMarkEnum
     */
    @Column(name = "config_mark")
    private String configMark;

    /**
     * 配置状态，ConfigStatusEnum
     */
    @Column(name = "config_status")
    private String configStatus;

    /**
     * 配置描述
     */
    @Column(name = "config_des")
    private String configDes;

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
     * 获取配置code
     *
     * @return config_code - 配置code
     */
    public String getConfigCode() {
        return configCode;
    }

    /**
     * 设置配置code
     *
     * @param configCode 配置code
     */
    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    /**
     * 获取配置名称
     *
     * @return config_name - 配置名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 设置配置名称
     *
     * @param configName 配置名称
     */
    public void setConfigName(String configName) {
        this.configName = configName;
    }

    /**
     * 获取配置值
     *
     * @return config_value - 配置值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 设置配置值
     *
     * @param configValue 配置值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    /**
     * 获取配置类型，ConfigTypeEnum
     *
     * @return config_type - 配置类型，ConfigTypeEnum
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 设置配置类型，ConfigTypeEnum
     *
     * @param configType 配置类型，ConfigTypeEnum
     */
    public void setConfigType(String configType) {
        this.configType = configType;
    }

    /**
     * 获取业务类型，BizTypeEnum
     *
     * @return biz_type - 业务类型，BizTypeEnum
     */
    public String getBizType() {
        return bizType;
    }

    /**
     * 设置业务类型，BizTypeEnum
     *
     * @param bizType 业务类型，BizTypeEnum
     */
    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    /**
     * 获取标签，ConfigMarkEnum
     *
     * @return config_mark - 标签，ConfigMarkEnum
     */
    public String getConfigMark() {
        return configMark;
    }

    /**
     * 设置标签，ConfigMarkEnum
     *
     * @param configMark 标签，ConfigMarkEnum
     */
    public void setConfigMark(String configMark) {
        this.configMark = configMark;
    }

    /**
     * 获取配置状态，ConfigStatusEnum
     *
     * @return config_status - 配置状态，ConfigStatusEnum
     */
    public String getConfigStatus() {
        return configStatus;
    }

    /**
     * 设置配置状态，ConfigStatusEnum
     *
     * @param configStatus 配置状态，ConfigStatusEnum
     */
    public void setConfigStatus(String configStatus) {
        this.configStatus = configStatus;
    }

    /**
     * 获取配置描述
     *
     * @return config_des - 配置描述
     */
    public String getConfigDes() {
        return configDes;
    }

    /**
     * 设置配置描述
     *
     * @param configDes 配置描述
     */
    public void setConfigDes(String configDes) {
        this.configDes = configDes;
    }
}