package com.mc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_account_outside")
public class AccountOutside {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 关联账号
     */
    @Column(name = "rel_account_id")
    private Integer relAccountId;

    /**
     * 三方账号
     */
    @Column(name = "account_no")
    private String accountNo;

    /**
     * 登录密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 查询密码
     */
    @Column(name = "query_password")
    private String queryPassword;

    /**
     * 支付密码
     */
    @Column(name = "transfer_password")
    private String transferPassword;

    /**
     * 账号类型，AccountTypeEnum
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 账号标签，AccountMarkEnum
     */
    @Column(name = "account_mark")
    private String accountMark;

    /**
     * 所属产品
     */
    private String product;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 证件类型，CertTypeEnum
     */
    @Column(name = "cert_type")
    private String certType;

    /**
     * 证件号码
     */
    @Column(name = "cert_no")
    private String certNo;

    /**
     * 个人姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 安全问题1
     */
    private String question1;

    /**
     * 安全问题答案1
     */
    private String answer1;

    /**
     * 安全问题2
     */
    private String question2;

    /**
     * 安全问题答案2
     */
    private String answer2;

    /**
     * 安全问题3
     */
    private String question3;

    /**
     * 安全问题答案3
     */
    private String answer3;

    /**
     * 用途
     */
    @Column(name = "account_used")
    private String accountUsed;

    /**
     * 账号描述
     */
    @Column(name = "account_des")
    private String accountDes;

    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取关联账号
     *
     * @return rel_account_id - 关联账号
     */
    public Integer getRelAccountId() {
        return relAccountId;
    }

    /**
     * 设置关联账号
     *
     * @param relAccountId 关联账号
     */
    public void setRelAccountId(Integer relAccountId) {
        this.relAccountId = relAccountId;
    }

    /**
     * 获取三方账号
     *
     * @return account_no - 三方账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 设置三方账号
     *
     * @param accountNo 三方账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 获取登录密码
     *
     * @return login_password - 登录密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登录密码
     *
     * @param loginPassword 登录密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取查询密码
     *
     * @return query_password - 查询密码
     */
    public String getQueryPassword() {
        return queryPassword;
    }

    /**
     * 设置查询密码
     *
     * @param queryPassword 查询密码
     */
    public void setQueryPassword(String queryPassword) {
        this.queryPassword = queryPassword;
    }

    /**
     * 获取支付密码
     *
     * @return transfer_password - 支付密码
     */
    public String getTransferPassword() {
        return transferPassword;
    }

    /**
     * 设置支付密码
     *
     * @param transferPassword 支付密码
     */
    public void setTransferPassword(String transferPassword) {
        this.transferPassword = transferPassword;
    }

    /**
     * 获取账号类型，AccountTypeEnum
     *
     * @return account_type - 账号类型，AccountTypeEnum
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账号类型，AccountTypeEnum
     *
     * @param accountType 账号类型，AccountTypeEnum
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取账号标签，AccountMarkEnum
     *
     * @return account_mark - 账号标签，AccountMarkEnum
     */
    public String getAccountMark() {
        return accountMark;
    }

    /**
     * 设置账号标签，AccountMarkEnum
     *
     * @param accountMark 账号标签，AccountMarkEnum
     */
    public void setAccountMark(String accountMark) {
        this.accountMark = accountMark;
    }

    /**
     * 获取所属产品
     *
     * @return product - 所属产品
     */
    public String getProduct() {
        return product;
    }

    /**
     * 设置所属产品
     *
     * @param product 所属产品
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * 获取所属公司
     *
     * @return company - 所属公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属公司
     *
     * @param company 所属公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取证件类型，CertTypeEnum
     *
     * @return cert_type - 证件类型，CertTypeEnum
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置证件类型，CertTypeEnum
     *
     * @param certType 证件类型，CertTypeEnum
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取证件号码
     *
     * @return cert_no - 证件号码
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * 设置证件号码
     *
     * @param certNo 证件号码
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    /**
     * 获取个人姓名
     *
     * @return name - 个人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置个人姓名
     *
     * @param name 个人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取安全问题1
     *
     * @return question1 - 安全问题1
     */
    public String getQuestion1() {
        return question1;
    }

    /**
     * 设置安全问题1
     *
     * @param question1 安全问题1
     */
    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    /**
     * 获取安全问题答案1
     *
     * @return answer1 - 安全问题答案1
     */
    public String getAnswer1() {
        return answer1;
    }

    /**
     * 设置安全问题答案1
     *
     * @param answer1 安全问题答案1
     */
    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    /**
     * 获取安全问题2
     *
     * @return question2 - 安全问题2
     */
    public String getQuestion2() {
        return question2;
    }

    /**
     * 设置安全问题2
     *
     * @param question2 安全问题2
     */
    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    /**
     * 获取安全问题答案2
     *
     * @return answer2 - 安全问题答案2
     */
    public String getAnswer2() {
        return answer2;
    }

    /**
     * 设置安全问题答案2
     *
     * @param answer2 安全问题答案2
     */
    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    /**
     * 获取安全问题3
     *
     * @return question3 - 安全问题3
     */
    public String getQuestion3() {
        return question3;
    }

    /**
     * 设置安全问题3
     *
     * @param question3 安全问题3
     */
    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    /**
     * 获取安全问题答案3
     *
     * @return answer3 - 安全问题答案3
     */
    public String getAnswer3() {
        return answer3;
    }

    /**
     * 设置安全问题答案3
     *
     * @param answer3 安全问题答案3
     */
    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    /**
     * 获取用途
     *
     * @return account_used - 用途
     */
    public String getAccountUsed() {
        return accountUsed;
    }

    /**
     * 设置用途
     *
     * @param accountUsed 用途
     */
    public void setAccountUsed(String accountUsed) {
        this.accountUsed = accountUsed;
    }

    /**
     * 获取账号描述
     *
     * @return account_des - 账号描述
     */
    public String getAccountDes() {
        return accountDes;
    }

    /**
     * 设置账号描述
     *
     * @param accountDes 账号描述
     */
    public void setAccountDes(String accountDes) {
        this.accountDes = accountDes;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}