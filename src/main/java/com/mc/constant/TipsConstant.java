package com.mc.constant;

/**
 * @author ChenglongChu
 * @description 检查提示，错误提示等信息
 * @create 2018/5/28 16:52
 */
public enum TipsConstant {
    USERNAME_NOT_EXISTS("EUSER10001", "用户名不存在，请检查用户名输入是否正确！"),
    USER_LOCK("EUSER10001", "该用户已被锁定！"),
    USER_FREEZE("EUSER10001", "该用户已被冻结！"),
    USER_DORMANT("EUSER10001", "该用户已长时间未使用，请先激活后再使用！"),
    NULL_USERNAME("EUSER10002", "用户名为空，请您输入正确的用户名！"),
    NOT_MATCHED_SELECTOR_CODE("EUSER10002", "未找到匹配的selector code！"),
    NULL_SELECTOR_CODE("EUSER10002", "selector code为空！"),
    WRONG_CREATE_VERIFICATION_CODE("EUSER10002", "验证码生成错误，请重新获取！"),
    WRONG_CHECK_VERIFICATION_CODE("EUSER10002", "验证码输入错误！"),
    EXPIRE_VERIFICATION_CODE("EUSER10002", "验证码已过期，请重新获取！"),
    NULL_USER("EUSER10002", "无可用的用户信息"),
    NULL_REDIS_KEY("EUSER10002", "redis的key在set时不能为空"),
    USER_EXISTS("EUSER10002", "用户已存在，请勿重复申请！"),
    USER_NOT_EXISTS("EUSER10002", "用户不存在！"),
    USERNAME_EXISTS("EUSER10002", "用户名已存在，请勿重复申请！"),
    NULL_PASSWORD("EUSER10003", "密码为空，请您输入正确的密码！"),
    NULL_VERIFICATION_CODE("EUSER10003", "验证码为空，请您输入正确的验证码！"),
    NULL_PHONE("EUSER10003", "手机号为空，请您输入正确的手机号！"),
    USED_PHONE("EUSER10003", "手机号已被注册！"),
    NULL_EMAIL("EUSER10003", "邮箱为空，请您输入正确的邮箱！"),
    WRONG_PASSWORD("EUSER10004", "登录密码不正确，您已输错?次，错误?次后用户将会被锁定！"),
    WRONG_PASSWORD2("EUSER10004", "登录密码不正确！"),
    WRONG_OLD_PASSWORD("EUSER10004", "旧密码不正确！"),
    WRONG_PASSWORD_TOO_MANY("EUSER10004", "密码错误次数超过5次，您的账户已被锁定，24小时后自动解锁，或申请人工解锁！"),
    FILE_INVALID("EUSER10004", "未发现有效文件！"),
    FILE_OVERSIZED_3M("EUSER10004", "文件过大, 不能超过3M！"),
    UNSUPPORT_FILE("EUSER10004", "文件格式不正确！"),
    SYSTEM_ERROR("ERROR10000", "系统异常，请稍后再试！"),
    NULL_WHITE_LIST("ERROR10000", "不存在此白名单！"),
    NULL_SERVER("ERROR10000", "不存在此服务！"),
    WHITE_LIST_EXISTS("ERROR10000", "此白名单已存在！"),
    CONFIG_EXISTS("ERROR10000", "此code配置已存在！"),
    SERVER_EXISTS("ERROR10000", "此服务已存在！"),
    NULL_CONFIG("ERROR10000", "不存在此配置！"),
    FAIL_UPLOAD("EUSER10004", "上传失败！")
    ;

    private String code;
    private String message;

    TipsConstant(String code, String message) {
        this.code = code;
        this.message = message;
    }

    TipsConstant(String code, String message, String... args) {
        this.code = code;
        for (String arg : args) {
            message = message.replaceFirst("\\?", arg);
        }
        this.message = message;
    }


    public static Enum<TipsConstant> setParams(TipsConstant src, String... args) {
        String message = src.getMessage();
        for (String arg : args) {
            message = message.replaceFirst("\\?", arg);
        }
        src.setMessage(message);
        return src;
    }

    public String getFullContent() {
        return this.code + "-" +this.message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.code + "-" + this.message;
    }

}

