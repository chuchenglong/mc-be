package com.mc.controller;

import com.mc.constant.ThreadLocalConstant;
import com.mc.service.UserService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import com.mc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.POST)
    public McResult getVerificationCode(@RequestBody VerificationCodeVo verificationCodeVo) throws McBusinessException {
        // 检查手机号是否已被使用
        userService.checkPhoneIsUsed(verificationCodeVo.getPhone());
        // 生成验证码
        String verificationCode = userService.createVerificationCode();
        // 将验证码缓存至redis
        userService.addVerificationCodeInRedis(verificationCode, verificationCodeVo.getPhone());
        // 发送至手机
        userService.sendVerificationCodeToPhone(verificationCode, verificationCodeVo.getPhone());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/checkVerificationCode", method = RequestMethod.POST)
    public McResult checkVerificationCode(@RequestBody VerificationCodeVo verificationCodeVo) throws McBusinessException {
        // 检查验证码正确性
        userService.checkVerificationCode(verificationCodeVo.getVerificationCode(), verificationCodeVo.getPhone());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public McResult register(@RequestBody RegisterVo registerVo) throws McBusinessException {
        // 检查用户名是否已被使用
        userService.checkUsernameIsUsed(registerVo.getUsername());
        // 添加用户注册信息
        userService.addUserOnce(registerVo);
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/getHomeData", method = RequestMethod.POST)
    public McResult getHomeData() throws McBusinessException {
        // 查询用户基本信息
        HomeVo homeVo = userService.getHomeDataByUserId(ThreadLocalConstant.getLocalUser().getUserId());
        // 返回成功结果信息
        return McResult.newSuccess(homeVo);
    }

    @RequestMapping(value = "/getUserDetail", method = RequestMethod.POST)
    public McResult getUserDetail() throws McBusinessException {
        // 查询用户基本信息
        UserVo userVo = userService.getUserVoByUserId(ThreadLocalConstant.getLocalUser().getUserId());
        // 返回成功结果信息
        return McResult.newSuccess(userVo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public McResult update(@RequestBody UserVo userVo) throws McBusinessException {
        // 修改用户基本信息
        userVo.setUserId(ThreadLocalConstant.getLocalUser().getUserId());
        userService.updateUserVoByUserId(userVo);
        // 返回成功结果信息
        return McResult.newSuccess(userVo);
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public McResult updatePassword(@RequestBody LoginVo loginVo) throws McBusinessException {
        // 修改用户基本信息
        userService.checkPassword(ThreadLocalConstant.getLocalUser().getUserId(), loginVo.getPassword());
        userService.updatePasswordByUserId(ThreadLocalConstant.getLocalUser().getUserId(), loginVo.getPassword2());
        // 返回成功结果信息
        return McResult.newSuccess(null);
    }

    @RequestMapping(value = "/getUserPageList", method = RequestMethod.POST)
    public McResult getUserPageList(@RequestBody UserConditionVo userConditionVo) throws McBusinessException {
        // 查询用户基本信息
        PageVo pageVo = userService.getUserVoPageListByCondition(userConditionVo);
        // 返回成功结果信息
        return McResult.newSuccess(pageVo);
    }


}
