package com.mc.controller;

import com.mc.model.ConfigInfo;
import com.mc.service.ConfigService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public McResult getConfigInfoList() throws McBusinessException {
        List<ConfigInfo> list = configService.getConfigInfoList();
        // 返回成功结果信息
        return McResult.newSuccess(list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public McResult addConfigInfo(@RequestBody ConfigInfo configInfo) throws McBusinessException {
        configService.checkConfigInfoListIsUsed(configInfo);
        int id = configService.addConfigInfo(configInfo);
        // 返回成功结果信息
        return McResult.newSuccess(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public McResult deleteConfigInfoById(@RequestBody ConfigInfo configInfo) throws McBusinessException {
        configService.checkConfigInfo(configInfo.getId());
        configService.deleteConfigInfoById(configInfo.getId());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public McResult updateConfigInfo(@RequestBody ConfigInfo configInfo) throws McBusinessException {
        configService.checkConfigInfo(configInfo.getId());
        configService.updateConfigInfo(configInfo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public McResult getConfigInfoDetail(@RequestBody ConfigInfo configInfo) throws McBusinessException {
        ConfigInfo ci = configService.getConfigInfoDetail(configInfo.getId());
        // 返回成功结果信息
        return McResult.newSuccess(ci);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public McResult updateConfigStatus(@RequestBody ConfigInfo configInfo) throws McBusinessException {
        configService.checkConfigInfo(configInfo.getId());
        configService.updateConfigStatusById(configInfo.getId(), configInfo.getConfigStatus());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
