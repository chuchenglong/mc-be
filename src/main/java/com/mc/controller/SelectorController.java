package com.mc.controller;

import com.mc.enumeration.*;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/selector")
public class SelectorController {
    @RequestMapping(value = "/getCertType", method = RequestMethod.POST)
    public McResult getCertType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(CertTypeEnum.getAll());
    }

    @RequestMapping(value = "/getRace", method = RequestMethod.POST)
    public McResult getRace() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(RaceEnum.getAll());
    }

    @RequestMapping(value = "/getNationality", method = RequestMethod.POST)
    public McResult getNationality() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(NationalityEnum.getAll());
    }

    @RequestMapping(value = "/getGender", method = RequestMethod.POST)
    public McResult getGender() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(GenderEnum.getAll());
    }

    @RequestMapping(value = "/getMarital", method = RequestMethod.POST)
    public McResult getMarital() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(MaritalEnum.getAll());
    }

    @RequestMapping(value = "/getWhiteType", method = RequestMethod.POST)
    public McResult getWhiteType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(WhiteTypeEnum.getAll());
    }

    @RequestMapping(value = "/getConfigType", method = RequestMethod.POST)
    public McResult getConfigType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ConfigTypeEnum.getAll());
    }

    @RequestMapping(value = "/getBizType", method = RequestMethod.POST)
    public McResult getBizType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(BizTypeEnum.getAll());
    }

    @RequestMapping(value = "/getConfigMark", method = RequestMethod.POST)
    public McResult getConfigMark() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ConfigMarkEnum.getAll());
    }

    @RequestMapping(value = "/getConfigStatus", method = RequestMethod.POST)
    public McResult getConfigStatus() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ConfigStatusEnum.getAll());
    }

    @RequestMapping(value = "/getServerType", method = RequestMethod.POST)
    public McResult getServerType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ServerTypeEnum.getAll());
    }

    @RequestMapping(value = "/getServerMark", method = RequestMethod.POST)
    public McResult getServerMark() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ServerMarkEnum.getAll());
    }

    @RequestMapping(value = "/getServerStatus", method = RequestMethod.POST)
    public McResult getServerStatus() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(ServerStatusEnum.getAll());
    }

    @RequestMapping(value = "/getUserStatus", method = RequestMethod.POST)
    public McResult getUserStatus() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(UserStatusEnum.getAll());
    }

    @RequestMapping(value = "/getOptStatus", method = RequestMethod.POST)
    public McResult getOptStatus() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(OptStatusEnum.getAll());
    }

    @RequestMapping(value = "/getAccountType", method = RequestMethod.POST)
    public McResult getAccountType() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(AccountTypeEnum.getAll());
    }

    @RequestMapping(value = "/getAccountMark", method = RequestMethod.POST)
    public McResult getAccountMark() throws McBusinessException {
        // 返回成功结果信息
        return McResult.newSuccess(AccountMarkEnum.getAll());
    }

}
