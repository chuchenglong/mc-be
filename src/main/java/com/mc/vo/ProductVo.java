package com.mc.vo;

import com.mc.model.ProductInfo;

public class ProductVo extends ProductInfo {
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
