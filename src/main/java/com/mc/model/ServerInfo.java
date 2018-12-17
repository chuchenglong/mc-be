package com.mc.model;

import javax.persistence.*;

@Table(name = "t_server_info")
public class ServerInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 服务地址
     */
    @Column(name = "server_url")
    private String serverUrl;

    /**
     * 服务名称
     */
    @Column(name = "server_name")
    private String serverName;

    /**
     * 服务类型，ServerTypeEnum
     */
    @Column(name = "server_type")
    private String serverType;

    /**
     * 业务类型，BizTypeEnum
     */
    @Column(name = "biz_type")
    private String bizType;

    /**
     * 标签，ServerMarkEnum
     */
    @Column(name = "server_mark")
    private String serverMark;

    /**
     * 参数状态，ServerStatusEnum
     */
    @Column(name = "server_status")
    private String serverStatus;

    /**
     * 服务描述
     */
    @Column(name = "server_des")
    private String serverDes;

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
     * 获取服务地址
     *
     * @return server_url - 服务地址
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * 设置服务地址
     *
     * @param serverUrl 服务地址
     */
    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    /**
     * 获取服务名称
     *
     * @return server_name - 服务名称
     */
    public String getServerName() {
        return serverName;
    }

    /**
     * 设置服务名称
     *
     * @param serverName 服务名称
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    /**
     * 获取服务类型，ServerTypeEnum
     *
     * @return server_type - 服务类型，ServerTypeEnum
     */
    public String getServerType() {
        return serverType;
    }

    /**
     * 设置服务类型，ServerTypeEnum
     *
     * @param serverType 服务类型，ServerTypeEnum
     */
    public void setServerType(String serverType) {
        this.serverType = serverType;
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
     * 获取标签，ServerMarkEnum
     *
     * @return server_mark - 标签，ServerMarkEnum
     */
    public String getServerMark() {
        return serverMark;
    }

    /**
     * 设置标签，ServerMarkEnum
     *
     * @param serverMark 标签，ServerMarkEnum
     */
    public void setServerMark(String serverMark) {
        this.serverMark = serverMark;
    }

    /**
     * 获取参数状态，ServerStatusEnum
     *
     * @return server_status - 参数状态，ServerStatusEnum
     */
    public String getServerStatus() {
        return serverStatus;
    }

    /**
     * 设置参数状态，ServerStatusEnum
     *
     * @param serverStatus 参数状态，ServerStatusEnum
     */
    public void setServerStatus(String serverStatus) {
        this.serverStatus = serverStatus;
    }

    /**
     * 获取服务描述
     *
     * @return server_des - 服务描述
     */
    public String getServerDes() {
        return serverDes;
    }

    /**
     * 设置服务描述
     *
     * @param serverDes 服务描述
     */
    public void setServerDes(String serverDes) {
        this.serverDes = serverDes;
    }
}