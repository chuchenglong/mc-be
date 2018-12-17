package com.mc.service;

import com.mc.constant.CommConstant;
import com.mc.constant.TipsConstant;
import com.mc.enumeration.*;
import com.mc.mapper.UserDetailMapper;
import com.mc.mapper.UserInfoMapper;
import com.mc.mapper.UserLoginMapper;
import com.mc.mapper.UserRoleMapper;
import com.mc.model.UserDetail;
import com.mc.model.UserInfo;
import com.mc.model.UserLogin;
import com.mc.model.UserRole;
import com.mc.system.McBusinessException;
import com.mc.system.McLog;
import com.mc.util.RandomUtils;
import com.mc.util.StringUtils;
import com.mc.vo.HomeVo;
import com.mc.vo.LoginVo;
import com.mc.vo.RegisterVo;
import com.mc.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserService extends BaseService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserLoginMapper userLoginMapper;

    /**
     * @description 检查用户登录信息，若不存在，则抛出异常
     * @param loginVo 待检查的用户名和密码
     * @return int 对应的用户ID
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-13 15:05:23
     * @version v1.0
     */
    public int checkLogin(LoginVo loginVo) throws McBusinessException {
        if (StringUtils.isEmpty(loginVo.getUsername()))
            throw new McBusinessException(TipsConstant.NULL_USERNAME);

        if (StringUtils.isEmpty(loginVo.getUsername()))
            throw new McBusinessException(TipsConstant.NULL_PASSWORD);

        UserInfo userInfo = userInfoMapper.selectUserInfoByUsername(loginVo.getUsername());
        if (null == userInfo)
            throw new McBusinessException(TipsConstant.USERNAME_NOT_EXISTS);

        if (UserStatusEnum.LOCK.getKey().equals(userInfo.getUserStatus()))
            throw new McBusinessException(TipsConstant.USER_LOCK);

        if (UserStatusEnum.FREEZE.getKey().equals(userInfo.getUserStatus()))
            throw new McBusinessException(TipsConstant.USER_FREEZE);

        if (UserStatusEnum.DORMANT.getKey().equals(userInfo.getUserStatus()))
            throw new McBusinessException(TipsConstant.USER_DORMANT);

        int userId = userInfo.getId();
        int loginWrongTimes = 0;
        String times = configService.getValueByCode(CommConstant.LOGIN_WRONG_TIMES);
        if (StringUtils.isNumber(times))
            loginWrongTimes = Integer.valueOf(times);
        String inPassword = StringUtils.deciphering(loginVo.getPassword());
        String userPassword = StringUtils.deciphering(userInfo.getPassword());
        if (inPassword.equals(userPassword)) {
            // 如果配置了失败次数验证且之前有失败次数，则重置失败次数
            if (loginWrongTimes > 0 && userInfo.getFailTimes() > 0) {
                userInfoMapper.updateFailTimesByUserId(userId, CommConstant.NUM_ZERO);
            }
        } else {
            // 如果配置了失败次数验证
            if (loginWrongTimes > 0) {
                // 失败次数+1
                int failTimes = userInfo.getFailTimes() + CommConstant.NUM_ONE;
                userInfoMapper.updateFailTimesByUserId(userId, failTimes);
                // 如果配置了失败次数验证且失败次数大于5，则将用户锁定
                if (failTimes >= loginWrongTimes) {
                    userInfoMapper.updateUserStatusByUserId(userId, UserStatusEnum.LOCK.getKey());
                    throw new McBusinessException(TipsConstant.WRONG_PASSWORD_TOO_MANY);
                }
            }
            throw new McBusinessException(TipsConstant.WRONG_PASSWORD2);
        }
        return userId;
    }

    /**
     * @description 生成6位随机数字验证码
     * @return String 已生成的验证码
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:05:23
     * @version v1.0
     */
    public String createVerificationCode() throws McBusinessException {
        String verificationCode = RandomUtils.createRandomNumByDigit(6);
        if (StringUtils.isEmpty(verificationCode) || verificationCode.length() != 6)
            throw new McBusinessException(TipsConstant.WRONG_CREATE_VERIFICATION_CODE);

        return verificationCode;
    }

    /**
     * @description 发送验证码到指定手机号
     * @param verificationCode 待发送的验证码
     * @param phone 接收验证码的手机号
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:09:09
     * @version v1.0
     */
    public void sendVerificationCodeToPhone(String verificationCode, String phone) throws McBusinessException {
        McLog.debug(logger, "{}的验证码为：{}", phone, verificationCode);
    }

    /**
     * @description 发送验证码到指定邮箱
     * @param verificationCode 待发送的验证码
     * @param email 接收验证码的邮箱
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:09:09
     * @version v1.0
     */
    public void sendVerificationCodeToEmail(String verificationCode, String email) throws McBusinessException {
        if (StringUtils.isEmpty(email))
            throw new McBusinessException(TipsConstant.NULL_EMAIL);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("chenglong.chu@qq.com");
        message.setTo(email);
        message.setSubject("MC系统注册验证码");
        message.setText("注册验证码为：" + verificationCode + "，有效期为5分钟。");
        mailSender.send(message);
    }

    /**
     * @description 发送验证码到指定邮箱
     * @param verificationCode 待发送的验证码
     * @param key vc+key做为缓存Key
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:15:09
     * @version v1.0
     */
    public void addVerificationCodeInRedis(String verificationCode, String key) throws McBusinessException {
        String redisKey = CommConstant.VC + key;
        redisService.setValueByKey(redisKey, verificationCode, 300);
    }

    /**
     * @description 检查验证码正确性
     * @param verificationCode 待发送的验证码
     * @param key vc+key做为缓存Key
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:15:09
     * @version v1.0
     */
    public void checkVerificationCode(String verificationCode, String key) throws McBusinessException {
        if (StringUtils.isEmpty(verificationCode))
            throw new McBusinessException(TipsConstant.NULL_VERIFICATION_CODE);

        String redisKey = CommConstant.VC + key;
        String sysVerificationCode = redisService.getValueByKey(redisKey);
        if (StringUtils.isEmpty(sysVerificationCode))
            throw new McBusinessException(TipsConstant.EXPIRE_VERIFICATION_CODE);

        if (!sysVerificationCode.equals(verificationCode))
            throw new McBusinessException(TipsConstant.WRONG_CHECK_VERIFICATION_CODE);
    }

    /**
     * @description 检查手机号是否已被使用
     * @param phone 待检查的手机号
     * @exception McBusinessException 业务异常
     * @author chuchenglong
     * @datetime 2018-11-29 14:15:09
     * @version v1.0
     */
    public void checkPhoneIsUsed(String phone) throws McBusinessException {
        if (StringUtils.isEmpty(phone))
            throw new McBusinessException(TipsConstant.NULL_PHONE);

        int count = userDetailMapper.selectUserDetailCountByPhone(phone);
        if (count > 0)
            throw new McBusinessException(TipsConstant.USED_PHONE);
    }

    public void checkUsernameIsUsed(String username) throws McBusinessException {
        if (StringUtils.isEmpty(username))
            throw new McBusinessException(TipsConstant.NULL_PHONE);

        int count = userInfoMapper.selectUserInfoCountByUsername(username);
        if (count > 0)
            throw new McBusinessException(TipsConstant.USED_PHONE);
    }

    public void addUserOnce(RegisterVo registerVo) throws McBusinessException {
        if (StringUtils.isEmpty(registerVo.getPassword()))
            throw new McBusinessException(TipsConstant.NULL_PASSWORD);

        Date now = new Date();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(registerVo.getUsername());
        userInfo.setPassword(registerVo.getPassword());
        userInfo.setUserStatus(UserStatusEnum.NORMAL.getKey());
        userInfo.setFailTimes(CommConstant.NUM_ZERO);
        userInfo.setCreateTime(now);
        userInfoMapper.insert(userInfo);

        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(userInfo.getId());
        userDetail.setPhone(registerVo.getPhone());
        userDetailMapper.insert(userDetail);

        UserRole userRole = new UserRole();
        userRole.setUserId(userInfo.getId());
        userRole.setRoleType(RoleTypeEnum.ORDINARY.getKey());
        userRoleMapper.insert(userRole);
    }

    public UserVo getUserVoByUserId(int userId) throws McBusinessException {
        if (userId <= 0)
            throw new McBusinessException(TipsConstant.USER_NOT_EXISTS);

        UserVo userVo = userInfoMapper.selectUserVoByUserId(userId);
        if (null != userVo) {
            userVo.setUserStatusDis(UserStatusEnum.get(userVo.getUserStatus()));
            userVo.setCertTypeDis(CertTypeEnum.get(userVo.getCertType()));
            userVo.setGenderDis(GenderEnum.get(userVo.getGender()));
            userVo.setMaritalDis(MaritalEnum.get(userVo.getMarital()));
            userVo.setNationalityDis(NationalityEnum.get(userVo.getNationality()));
            userVo.setRaceDis(RaceEnum.get(userVo.getRace()));
        }

        return userVo;
    }

    public void saveLoginRecord(int userId) throws McBusinessException {
        try {
            UserLogin userLogin = new UserLogin();
            userLogin.setUserId(userId);
            userLogin.setLoginTime(new Date());
            userLoginMapper.insert(userLogin);
        } catch (Exception e) {
            McLog.error(logger, "记录用户{}登录时间异常", userId);
        }
    }

    public HomeVo getHomeDataByUserId(int userId) throws McBusinessException {
        HomeVo homeVo = new HomeVo();
        UserDetail userDetail = userDetailMapper.selectHomeDataByUserId(userId);
        if (userDetail == null)
            throw new McBusinessException(TipsConstant.USER_NOT_EXISTS);

        homeVo.setAlias(StringUtils.isEmpty(userDetail.getAlias()) ? StringUtils.hidePhone(userDetail.getPhone()) : userDetail.getAlias());
        homeVo.setPhoto(StringUtils.isEmpty(userDetail.getPhone()) ? CommConstant.STRING_EMPTY : userDetail.getPhoto());
        return homeVo;
    }

    public void updateUserVoByUserId(UserVo userVo) throws McBusinessException {
        int count = userDetailMapper.selectUserDetailCountByUserId(userVo.getUserId());
        if (count == 0)
            throw new McBusinessException(TipsConstant.USER_NOT_EXISTS);
        userDetailMapper.updateUserDetailByUserId(userVo);
    }

    public void checkPassword(int userId, String oldPassword) throws McBusinessException {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        if (null == userInfo)
            throw new McBusinessException(TipsConstant.NULL_USER);

        String oldPwd = StringUtils.deciphering(oldPassword);
        String pwd = StringUtils.deciphering(userInfo.getPassword());
        if (!oldPwd.equals(pwd))
            throw new McBusinessException(TipsConstant.WRONG_OLD_PASSWORD);
    }

    public void updatePasswordByUserId(int userId, String password) {
        userInfoMapper.updatePasswordByUserId(userId, password);
    }
}
