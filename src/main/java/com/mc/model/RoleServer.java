package com.mc.model;

import javax.persistence.*;

@Table(name = "t_role_server")
public class RoleServer {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色类型
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 服务ID
     */
    @Column(name = "server_id")
    private Integer serverId;

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
     * 获取角色类型
     *
     * @return role_type - 角色类型
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置角色类型
     *
     * @param roleType 角色类型
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取服务ID
     *
     * @return server_id - 服务ID
     */
    public Integer getServerId() {
        return serverId;
    }

    /**
     * 设置服务ID
     *
     * @param serverId 服务ID
     */
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }
}