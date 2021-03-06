package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.AccountOutside;
import com.mc.vo.AccountOutsideVo;
import com.mc.vo.OutsideVo;

import java.util.List;

public interface AccountOutsideMapper extends QkMapperConfig<AccountOutside> {
    List<OutsideVo> selectAccountOutsidePageListByCondition(AccountOutsideVo accountOutsideVo);

    int selectAccountOutsidePageListCountByCondition(AccountOutsideVo accountOutsideVo);

    int selectAccountOutsideCountByCondition(AccountOutside accountOutside);

    void updateAccountOutsideById(AccountOutside accountOutside);
}