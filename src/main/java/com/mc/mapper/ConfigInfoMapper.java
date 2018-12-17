package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.ConfigInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfigInfoMapper extends QkMapperConfig<ConfigInfo> {
    String selectValueByCode(String configCode);

    List<ConfigInfo> selectEnableConfigInfo();

    int selectConfigInfoCountByConfigCode(String configCode);

    void updateConfigInfoById(ConfigInfo configInfo);

    void updateConfigStatusById(@Param("id") int id, @Param("configStatus") String configStatus);
}