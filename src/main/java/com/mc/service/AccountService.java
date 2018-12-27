package com.mc.service;

import com.mc.constant.TipsConstant;
import com.mc.mapper.AccountOutsideMapper;
import com.mc.model.AccountOutside;
import com.mc.system.McBusinessException;
import com.mc.util.StringUtils;
import com.mc.vo.AccountOutsideVo;
import com.mc.vo.OutsideVo;
import com.mc.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountOutsideMapper accountOutsideMapper;

    public PageVo getAccountOutsidePageListByCondition(AccountOutsideVo accountOutsideVo) {
        List<OutsideVo> list = accountOutsideMapper.selectAccountOutsidePageListByCondition(accountOutsideVo);
        int total = accountOutsideMapper.selectAccountOutsidePageListCountByCondition(accountOutsideVo);
        return PageVo.getResult(list, total);
    }

    public void checkAccountOutsideIsUsed(AccountOutside accountOutside) throws McBusinessException {
        if (StringUtils.isEmpty(accountOutside.getAccountNo()) && accountOutside.getRelAccountId() == 0)
            throw new McBusinessException(TipsConstant.NULL_ACCOUNT_NO);

        int count = accountOutsideMapper.selectAccountOutsideCountByCondition(accountOutside);
        if (count > 0)
            throw new McBusinessException(TipsConstant.USED_ACCOUNT_NO);
    }

    public int addAccountOutsideOnce(AccountOutside accountOutside) {
        if (null == accountOutside.getCreateTime())
            accountOutside.setCreateTime(new Date());
        accountOutsideMapper.insert(accountOutside);
        return accountOutside.getId();
    }

    public void deleteAccountOutside(AccountOutside accountOutside) throws McBusinessException {
        AccountOutside ao = accountOutsideMapper.selectByPrimaryKey(accountOutside.getId());
        if (null == ao)
            throw new McBusinessException(TipsConstant.NULL_ACCOUNT_OUTSIDE);
        accountOutsideMapper.deleteByPrimaryKey(accountOutside.getId());
    }

    public AccountOutside getAccountOutsideDetail(int id) throws McBusinessException {
        if (id == 0)
            throw new McBusinessException(TipsConstant.NULL_ACCOUNT_OUTSIDE);
        return accountOutsideMapper.selectByPrimaryKey(id);
    }

    public void updateAccountOutside(AccountOutside accountOutside) throws McBusinessException {
        if (accountOutside.getId() == 0)
            throw new McBusinessException(TipsConstant.NULL_ACCOUNT_OUTSIDE);
        accountOutsideMapper.updateAccountOutsideById(accountOutside);
    }
}
