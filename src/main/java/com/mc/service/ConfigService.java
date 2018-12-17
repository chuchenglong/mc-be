package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.enumeration.ConfigStatusEnum;
import com.mc.mapper.ConfigInfoMapper;
import com.mc.model.ConfigInfo;
import com.mc.system.McBusinessException;
import com.mc.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService extends BaseService {
    @Autowired
    private ConfigInfoMapper configInfoMapper;

    public String getValueByCode(String configCode) {
        String value = redisService.getValueByKey(configCode);
        // 如果缓存中未取到配置信息，再从数据库中获取
        if (StringUtils.isEmpty(value))
            return configInfoMapper.selectValueByCode(configCode);
        return value;
    }

    public List<ConfigInfo> getConfigInfoList() {
        return configInfoMapper.selectAll();
    }

    public void checkConfigInfoListIsUsed(ConfigInfo configInfo) throws McBusinessException {
        int count = configInfoMapper.selectConfigInfoCountByConfigCode(configInfo.getConfigCode());
        if (count > 0)
            throw new McBusinessException(TipsConstant.CONFIG_EXISTS);
    }

    public int addConfigInfo(ConfigInfo configInfo) {
        configInfo.setConfigStatus(ConfigStatusEnum.NORMAL.getKey());
        configInfoMapper.insert(configInfo);
        return configInfo.getId();
    }

    public void checkConfigInfo(int id) throws McBusinessException {
        ConfigInfo configInfo = configInfoMapper.selectByPrimaryKey(id);
        if (null == configInfo)
            throw new McBusinessException(TipsConstant.NULL_WHITE_LIST);
    }

    public void deleteConfigInfoById(int id) {
        configInfoMapper.deleteByPrimaryKey(id);
    }

    public void updateConfigInfo(ConfigInfo configInfo) {
        configInfoMapper.updateConfigInfoById(configInfo);
    }

    public ConfigInfo getConfigInfoDetail(int id) {
        return configInfoMapper.selectByPrimaryKey(id);
    }

    public void updateConfigStatusById(int id, String configStatus) {
        configInfoMapper.updateConfigStatusById(id, configStatus);
    }
}
