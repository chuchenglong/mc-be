package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.mapper.WhiteInfoMapper;
import com.mc.model.WhiteInfo;
import com.mc.system.McBusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class WhiteService {
    @Autowired
    private WhiteInfoMapper whiteInfoMapper;
    @Autowired
    private RedisService redisService;

    public boolean checkWhiteListByType(String value, String whiteType) {
        List<String> whiteList = redisService.getWhiteListByType(whiteType);
        if (CollectionUtils.isEmpty(whiteList)) {
            whiteList = whiteInfoMapper.selectWhiteListByType(whiteType);
        }
        if (!CollectionUtils.isEmpty(whiteList) && whiteList.contains(value))
            return true;
        return false;
    }

    public List<WhiteInfo> getWhiteInfoList() {
        return whiteInfoMapper.selectAll();
    }

    public void checkWhiteInfoListIsUsed(WhiteInfo whiteInfo) throws McBusinessException {
        WhiteInfo w = whiteInfoMapper.selectOne(whiteInfo);
        if (null != w)
            throw new McBusinessException(TipsConstant.WHITE_LIST_EXISTS);
    }

    public int addWhiteInfo(WhiteInfo whiteInfo) {
        whiteInfoMapper.insert(whiteInfo);
        return whiteInfo.getId();
    }

    public void checkWhiteInfo(int id) throws McBusinessException {
        WhiteInfo w = whiteInfoMapper.selectByPrimaryKey(id);
        if (null == w)
            throw new McBusinessException(TipsConstant.NULL_WHITE_LIST);
    }

    public void deleteWhiteInfoById(int id) {
        whiteInfoMapper.deleteByPrimaryKey(id);
    }


}
