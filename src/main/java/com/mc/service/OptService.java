package com.mc.service;

import com.mc.mapper.OptRecordMapper;
import com.mc.model.OptRecord;
import com.mc.vo.OptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptService {
    @Autowired
    private OptRecordMapper optRecordMapper;

    public List<OptRecord> getOptList(OptVo optVo) {
        return optRecordMapper.selectOptRecordListByCondition(optVo);
    }
}
