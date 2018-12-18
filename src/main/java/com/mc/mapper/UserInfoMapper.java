package com.mc.mapper;

import com.mc.config.QkMapperConfig;
import com.mc.model.UserInfo;
import com.mc.vo.UserConditionVo;
import com.mc.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper extends QkMapperConfig<UserInfo> {
    UserInfo selectUserInfoByUsername(String username);

    void updateFailTimesByUserId(@Param("userId") int userId, @Param("times") int times);

    void updateUserStatusByUserId(@Param("userId") int userId, @Param("userStatus") String userStatus);

    int selectUserInfoCountByUsername(String username);

    UserVo selectUserVoByUserId(int userId);

    void updatePasswordByUserId(@Param("userId") int userId, @Param("password") String password);

    List<UserVo> getUserVoPageListByCondition(UserConditionVo userConditionVo);

    int getUserVoPageListCountByCondition(UserConditionVo userConditionVo);
}