package com.mc.controller;

import com.mc.constant.ThreadLocalConstant;
import com.mc.model.AccountOutside;
import com.mc.service.AccountService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import com.mc.vo.AccountOutsideVo;
import com.mc.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/outside/list", method = RequestMethod.POST)
    public McResult getAccountOutsidePageList(@RequestBody AccountOutsideVo accountOutsideVo) throws McBusinessException {
        PageVo pageVo = accountService.getAccountOutsidePageListByCondition(accountOutsideVo);
        // 返回成功结果信息
        return McResult.newSuccess(pageVo);
    }

    @RequestMapping(value = "/outside/add", method = RequestMethod.POST)
    public McResult addAccountOutside(@RequestBody AccountOutside accountOutside) throws McBusinessException {
        accountOutside.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        accountService.checkAccountOutsideIsUsed(accountOutside);
        int id = accountService.addAccountOutsideOnce(accountOutside);
        // 返回成功结果信息
        return McResult.newSuccess(id);
    }

    @RequestMapping(value = "/outside/delete", method = RequestMethod.POST)
    public McResult deleteAccountOutside(@RequestBody AccountOutside accountOutside) throws McBusinessException {
        accountService.deleteAccountOutside(accountOutside);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/outside/detail", method = RequestMethod.POST)
    public McResult getAccountOutsideDetail(@RequestBody AccountOutside accountOutside) throws McBusinessException {
        AccountOutside ao = accountService.getAccountOutsideDetail(accountOutside.getId());
        // 返回成功结果信息
        return McResult.newSuccess(ao);
    }

    @RequestMapping(value = "/outside/update", method = RequestMethod.POST)
    public McResult updateAccountOutside(@RequestBody AccountOutside accountOutside) throws McBusinessException {
        accountService.updateAccountOutside(accountOutside);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }
}
