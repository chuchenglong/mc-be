package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.OptRecord;
import com.mc.vo.OptVo;

import java.util.List;

public interface OptRecordMapper extends QkMapperConfig<OptRecord> {
    List<OptRecord> selectOptRecordListByCondition(OptVo optVo);

    int selectOptRecordListCountByCondition(OptVo optVo);
}