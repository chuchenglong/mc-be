package com.mc.vo;

import com.mc.model.AccountOutside;

public class OutsideVo extends AccountOutside {
    private String companyName;
    private String productName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
