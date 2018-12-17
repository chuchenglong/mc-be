package com.mc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_info")
public class UserInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 登录密码错误次数
     */
    @Column(name = "fail_times")
    private Integer failTimes;

    /**
     * 用户状态，UserStatusEnum
     */
    @Column(name = "user_status")
    private String userStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取登录密码错误次数
     *
     * @return fail_times - 登录密码错误次数
     */
    public Integer getFailTimes() {
        return failTimes;
    }

    /**
     * 设置登录密码错误次数
     *
     * @param failTimes 登录密码错误次数
     */
    public void setFailTimes(Integer failTimes) {
        this.failTimes = failTimes;
    }

    /**
     * 获取用户状态，UserStatusEnum
     *
     * @return user_status - 用户状态，UserStatusEnum
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态，UserStatusEnum
     *
     * @param userStatus 用户状态，UserStatusEnum
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}