package com.mc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_opt_record")
public class OptRecord {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 操作服务地址
     */
    @Column(name = "opt_url")
    private String optUrl;

    /**
     * 操作时间
     */
    @Column(name = "opt_time")
    private Date optTime;

    /**
     * 操作状态，OptStatusEnum
     */
    @Column(name = "opt_status")
    private String optStatus;

    /**
     * 操作人的ip
     */
    @Column(name = "opt_ip")
    private String optIp;

    /**
     * 操作内容
     */
    @Column(name = "opt_content")
    private String optContent;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取操作服务地址
     *
     * @return opt_url - 操作服务地址
     */
    public String getOptUrl() {
        return optUrl;
    }

    /**
     * 设置操作服务地址
     *
     * @param optUrl 操作服务地址
     */
    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl;
    }

    /**
     * 获取操作时间
     *
     * @return opt_time - 操作时间
     */
    public Date getOptTime() {
        return optTime;
    }

    /**
     * 设置操作时间
     *
     * @param optTime 操作时间
     */
    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    /**
     * 获取操作状态，OptStatusEnum
     *
     * @return opt_status - 操作状态，OptStatusEnum
     */
    public String getOptStatus() {
        return optStatus;
    }

    /**
     * 设置操作状态，OptStatusEnum
     *
     * @param optStatus 操作状态，OptStatusEnum
     */
    public void setOptStatus(String optStatus) {
        this.optStatus = optStatus;
    }

    /**
     * 获取操作人的ip
     *
     * @return opt_ip - 操作人的ip
     */
    public String getOptIp() {
        return optIp;
    }

    /**
     * 设置操作人的ip
     *
     * @param optIp 操作人的ip
     */
    public void setOptIp(String optIp) {
        this.optIp = optIp;
    }

    /**
     * 获取操作内容
     *
     * @return opt_content - 操作内容
     */
    public String getOptContent() {
        return optContent;
    }

    /**
     * 设置操作内容
     *
     * @param optContent 操作内容
     */
    public void setOptContent(String optContent) {
        this.optContent = optContent;
    }
}