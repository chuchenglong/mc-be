package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.CompanyInfo;

import java.util.List;

public interface CompanyInfoMapper extends QkMapperConfig<CompanyInfo> {
    List<CompanyInfo> selectCompanyListByUserId(int userId);

    void updateCompanyByIdAndUserId(CompanyInfo companyInfo);

    int selectCompanyCountByCompanyNameAndUserId(CompanyInfo companyInfo);

    void deleteCompanyByIdAndUserId(CompanyInfo companyInfo);
}