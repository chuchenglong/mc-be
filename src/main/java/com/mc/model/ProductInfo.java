package com.mc.model;

import javax.persistence.*;

@Table(name = "t_product_info")
public class ProductInfo {
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
     * 公司ID
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 公司描述
     */
    @Column(name = "product_des")
    private String productDes;

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
     * 获取公司ID
     *
     * @return company_id - 公司ID
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     *
     * @param companyId 公司ID
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取公司描述
     *
     * @return product_des - 公司描述
     */
    public String getProductDes() {
        return productDes;
    }

    /**
     * 设置公司描述
     *
     * @param productDes 公司描述
     */
    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }
}