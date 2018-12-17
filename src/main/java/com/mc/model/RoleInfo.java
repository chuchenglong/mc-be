package com.mc.model;

import javax.persistence.*;

@Table(name = "t_role_info")
public class RoleInfo {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色类型，RoleTypeEnum
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

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
     * 获取角色类型，RoleTypeEnum
     *
     * @return role_type - 角色类型，RoleTypeEnum
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 设置角色类型，RoleTypeEnum
     *
     * @param roleType 角色类型，RoleTypeEnum
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}