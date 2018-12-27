package com.mc.model;

import javax.persistence.*;

@Table(name = "t_company_info")
public class CompanyInfo {
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
     * 公司名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司描述
     */
    @Column(name = "company_des")
    private String companyDes;

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
     * 获取公司名称
     *
     * @return company_name - 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名称
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取公司描述
     *
     * @return company_des - 公司描述
     */
    public String getCompanyDes() {
        return companyDes;
    }

    /**
     * 设置公司描述
     *
     * @param companyDes 公司描述
     */
    public void setCompanyDes(String companyDes) {
        this.companyDes = companyDes;
    }
}