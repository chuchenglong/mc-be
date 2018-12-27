package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.mapper.CompanyInfoMapper;
import com.mc.model.CompanyInfo;
import com.mc.system.McBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    public List<CompanyInfo> getCompanyListByUserId(int userId) throws McBusinessException {
        if (userId == 0)
            throw new McBusinessException(TipsConstant.NULL_USER);
        return companyInfoMapper.selectCompanyListByUserId(userId);
    }

    public void checkCompanyIsUsed(CompanyInfo companyInfo) throws McBusinessException {
        int count = companyInfoMapper.selectCompanyCountByCompanyNameAndUserId(companyInfo);
        if (count > 0)
            throw new McBusinessException(TipsConstant.USED_COMPANY);
    }

    public void addCompany(CompanyInfo companyInfo) {
        companyInfoMapper.insert(companyInfo);
    }

    public void checkCompanyIsExists(CompanyInfo companyInfo) throws McBusinessException {
        if (companyInfo.getId() == null)
            throw new McBusinessException(TipsConstant.NULL_COMPANY);
        if (companyInfo.getUserId() == null || companyInfo.getUserId() == 0)
            throw new McBusinessException(TipsConstant.NULL_USER);
    }

    public void updateCompanyByIdAndUserId(CompanyInfo companyInfo) throws McBusinessException {
        companyInfoMapper.updateCompanyByIdAndUserId(companyInfo);
    }


    public void deleteCompanyByIdAndUserId(CompanyInfo companyInfo) {
        companyInfoMapper.deleteCompanyByIdAndUserId(companyInfo);
    }


}
