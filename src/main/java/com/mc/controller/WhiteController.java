package com.mc.controller;

import com.mc.model.WhiteInfo;
import com.mc.service.WhiteService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/white")
public class WhiteController {
    @Autowired
    private WhiteService whiteService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public McResult getWhiteInfoList() throws McBusinessException {
        List<WhiteInfo> list = whiteService.getWhiteInfoList();
        // 返回成功结果信息
        return McResult.newSuccess(list);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public McResult addWhiteInfo(@RequestBody WhiteInfo whiteInfo) throws McBusinessException {
        whiteService.checkWhiteInfoListIsUsed(whiteInfo);
        int id = whiteService.addWhiteInfo(whiteInfo);
        // 返回成功结果信息
        return McResult.newSuccess(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public McResult deleteWhiteInfoById(@RequestBody WhiteInfo whiteInfo) throws McBusinessException {
        whiteService.checkWhiteInfo(whiteInfo.getId());
        whiteService.deleteWhiteInfoById(whiteInfo.getId());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
