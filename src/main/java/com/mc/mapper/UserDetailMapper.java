package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.UserDetail;
import com.mc.vo.UserVo;

public interface UserDetailMapper extends QkMapperConfig<UserDetail> {
    int selectUserDetailCountByPhone(String phone);

    UserDetail selectHomeDataByUserId(int userId);

    int selectUserDetailCountByUserId(int userId);

    void updateUserDetailByUserId(UserVo userVo);
}