package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.WhiteInfo;

import java.util.List;

public interface WhiteInfoMapper extends QkMapperConfig<WhiteInfo> {
    List<String> selectWhiteListByType(String whiteType);
}