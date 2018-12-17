package com.mc.controller;

import com.mc.service.RedisService;
import com.mc.service.UserService;
import com.mc.system.McBusinessException;
import com.mc.system.McResult;
import com.mc.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/in", method = RequestMethod.POST)
    public McResult loginIn(@RequestBody LoginVo loginVo) throws McBusinessException {
        // 登录检查
        int userId = userService.checkLogin(loginVo);
        // 添加用户session入redis
        String token = redisService.addToken(userId);
        // 记录登录信息
        userService.saveLoginRecord(userId);
        // 返回token
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        return McResult.newSuccess(map);
    }

    @RequestMapping(value = "/out", method = RequestMethod.POST)
    public McResult loginOut(@RequestBody LoginVo loginVo) throws McBusinessException {
        // 删除redis的用户session
        redisService.delValueByKey(loginVo.getToken());
        return McResult.newSuccess(null);
    }

}
