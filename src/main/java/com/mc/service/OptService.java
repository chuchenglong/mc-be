package com.mc.service;

import com.mc.mapper.OptRecordMapper;
import com.mc.model.OptRecord;
import com.mc.vo.OptVo;
import com.mc.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptService {
    @Autowired
    private OptRecordMapper optRecordMapper;

    public PageVo getOptList(OptVo optVo) {
        List<OptRecord> list = optRecordMapper.selectOptRecordListByCondition(optVo);
        int total = optRecordMapper.selectOptRecordListCountByCondition(optVo);
        PageVo pageVo = new PageVo();
        pageVo.setTotal(total);
        pageVo.setRows(list);
        return pageVo;
    }
}
