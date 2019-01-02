package com.mc.service;

import com.mc.constant.CommConstant;
import com.mc.constant.TipsConstant;
import com.mc.enumeration.ConfigCodeEnum;
import com.mc.enumeration.WhiteTypeEnum;
import com.mc.mapper.ConfigInfoMapper;
import com.mc.mapper.WhiteInfoMapper;
import com.mc.model.ConfigInfo;
import com.mc.system.McBusinessException;
import com.mc.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final Logger logger = LoggerFactory.getLogger(RedisService.class);
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private ValueOperations<String, String> valueOperations;
    @Resource
    private ListOperations<String, String> listOperations;
    @Autowired
    private ConfigInfoMapper configInfoMapper;
    @Autowired
    private WhiteInfoMapper whiteInfoMapper;

    public String addToken(int userId) {
        String redisKey = UUID.randomUUID().toString();
        // 设置token到redis
        valueOperations.set(redisKey, String.valueOf(userId));
        // 设置token超时时间
        return resetTokenTimeout(redisKey);
    }

    public String resetTokenTimeout(String redisKey) {
        if (StringUtils.isNotEmpty(redisKey)) {
            // 获取token超时时间配置数据
            String tokenTimeout = valueOperations.get(ConfigCodeEnum.TOKEN_TIMEOUT.getKey());
            // 如果配置了超时时间，设置超时时间
            if (StringUtils.isNotEmpty(tokenTimeout))
                redisTemplate.expire(redisKey, Integer.valueOf(tokenTimeout), TimeUnit.SECONDS);
        }
        return redisKey;
    }

    public String getValueByKey(String key) {
        if (StringUtils.isEmpty(key))
            return CommConstant.STRING_EMPTY;
        return valueOperations.get(key);
    }

    public void setValueByKey(String key, String value) throws McBusinessException {
        if (StringUtils.isEmpty(key))
            throw new McBusinessException(TipsConstant.NULL_REDIS_KEY);
        valueOperations.set(key, value);
    }

    public void setValueByKey(String key, String value, int timeout) throws McBusinessException {
        setValueByKey(key, value);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public void delValueByKey(String key) {
        redisTemplate.delete(key);
    }

    public void setConfigInfo() {
        List<ConfigInfo> configList = configInfoMapper.selectEnableConfigInfo();
        configList.stream().forEach(config -> {
            try {
                setValueByKey(config.getConfigCode(), config.getConfigValue());
            } catch (McBusinessException e) {
                logger.debug("redis data config init fail : config code is {}, config value is {} \\n", config.getConfigCode(), config.getConfigValue());
            }
        });
    }

    public void setWhiteList() {
        List<String> keys = WhiteTypeEnum.getKeys();
        if (!CollectionUtils.isEmpty(keys)) {
            keys.stream().forEach(key -> {
                try {
                    setWhiteListByType(key);
                } catch (McBusinessException e) {
                    logger.debug("redis data white list init fail : {} \\n", key);
                }
            });
        }
    }

    public void setWhiteListByType(String key) throws McBusinessException {
        if (StringUtils.isEmpty(key))
            throw new McBusinessException(TipsConstant.NULL_REDIS_KEY);
        List<String> list = whiteInfoMapper.selectWhiteListByType(key);
        if (!CollectionUtils.isEmpty(list)) {
            // 清空redis list
            if (redisTemplate.hasKey(key))
                redisTemplate.delete(key);

            listOperations.rightPushAll(key, list);
        }
    }

    public List<String> getWhiteListByType(String key) {
        if (StringUtils.isEmpty(key))
            return null;
        return listOperations.range(key, CommConstant.NUM_ZERO, CommConstant.NUM_MINUS_ONE);
    }

    public void flushDb() {

    }
}
