package com.mc.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user_detail")
public class UserDetail {
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
     * 昵称
     */
    private String alias;

    /**
     * 性别，GenderEnum
     */
    private String gender;

    /**
     * 出生日期
     */
    @Column(name = "birth_date")
    private Date birthDate;

    /**
     * 用户简介
     */
    private String brief;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 婚姻状况，MaritalEnum
     */
    private String marital;

    /**
     * 名族，RaceEnum
     */
    private String race;

    /**
     * 国籍，NationalityEnum
     */
    private String nationality;

    /**
     * 户籍地址
     */
    private String domicile;

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
     * 获取昵称
     *
     * @return alias - 昵称
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置昵称
     *
     * @param alias 昵称
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取性别，GenderEnum
     *
     * @return gender - 性别，GenderEnum
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别，GenderEnum
     *
     * @param gender 性别，GenderEnum
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取出生日期
     *
     * @return birth_date - 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期
     *
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取用户简介
     *
     * @return brief - 用户简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置用户简介
     *
     * @param brief 用户简介
     */
    public void setBrief(String brief) {
        this.brief = brief;
    }

    /**
     * 获取用户头像
     *
     * @return photo - 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置用户头像
     *
     * @param photo 用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取婚姻状况，MaritalEnum
     *
     * @return marital - 婚姻状况，MaritalEnum
     */
    public String getMarital() {
        return marital;
    }

    /**
     * 设置婚姻状况，MaritalEnum
     *
     * @param marital 婚姻状况，MaritalEnum
     */
    public void setMarital(String marital) {
        this.marital = marital;
    }

    /**
     * 获取名族，RaceEnum
     *
     * @return race - 名族，RaceEnum
     */
    public String getRace() {
        return race;
    }

    /**
     * 设置名族，RaceEnum
     *
     * @param race 名族，RaceEnum
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * 获取国籍，NationalityEnum
     *
     * @return nationality - 国籍，NationalityEnum
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置国籍，NationalityEnum
     *
     * @param nationality 国籍，NationalityEnum
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 获取户籍地址
     *
     * @return domicile - 户籍地址
     */
    public String getDomicile() {
        return domicile;
    }

    /**
     * 设置户籍地址
     *
     * @param domicile 户籍地址
     */
    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }
}