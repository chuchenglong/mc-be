package com.mc.service;

import com.mc.constant.CommConstant;
import com.mc.constant.ThreadLocalConstant;
import com.mc.system.McBusinessException;
import com.mc.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected RedisService redisService;
    @Autowired
    protected ConfigService configService;

    protected int getLocalUserId() {
        String token = ThreadLocalConstant.getLocalRequest().getHeader(CommConstant.HEADER_TOKEN);
        if (StringUtils.isEmpty(token))
            return CommConstant.NUM_ZERO;

        String userId = redisService.getValueByKey(token);
        if (StringUtils.isNotNumber(userId))
            return CommConstant.NUM_ZERO;

        return Integer.valueOf(userId);
    }

    protected String getLocalUserIdToString() {
        String token = ThreadLocalConstant.getLocalRequest().getHeader(CommConstant.HEADER_TOKEN);
        if (StringUtils.isEmpty(token))
            return CommConstant.STRING_EMPTY;

        return redisService.getValueByKey(token);
    }

}
