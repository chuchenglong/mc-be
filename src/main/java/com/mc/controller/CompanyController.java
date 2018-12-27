package com.mc.controller;

import com.mc.constant.ThreadLocalConstant;
import com.mc.model.CompanyInfo;
import com.mc.service.CompanyService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/getCompanyList", method = RequestMethod.POST)
    public McResult getCompanyList() throws McBusinessException {
        List<CompanyInfo> companyInfos = companyService.getCompanyListByUserId(ThreadLocalConstant.getLocalUser().getUserId());
        // 返回成功结果信息
        return McResult.newSuccess(companyInfos);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public McResult addCompany(@RequestBody CompanyInfo companyInfo) throws McBusinessException {
        companyInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        companyService.checkCompanyIsUsed(companyInfo);
        companyService.addCompany(companyInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public McResult updateCompany(@RequestBody CompanyInfo companyInfo) throws McBusinessException {
        companyInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        companyService.checkCompanyIsExists(companyInfo);
        companyService.updateCompanyByIdAndUserId(companyInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public McResult deleteCompany(@RequestBody CompanyInfo companyInfo) throws McBusinessException {
        companyInfo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        companyService.checkCompanyIsExists(companyInfo);
        companyService.deleteCompanyByIdAndUserId(companyInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
