-- ----------------------------------------
-- 用户信息表
-- 1. 用户状态中
--   1）锁定为登录密码错误次数过多导致，可N小时后自动解锁，也可由系统管理员手动解锁。
--   2）冻结为系统管理员手动冻结/解冻。
--   3）休眠为用户N长时间未活跃，自动进入休眠状态，待用户登录后唤醒为正常用户。
--   4）注销为系统管理员手动注销，注销后认为对用户逻辑删除。
-- 2. 10000000预留为system
-- ----------------------------------------
drop table if exists t_user_info;
create table t_user_info (
  id int(8) not null auto_increment comment 'ID',
  username varchar(50) unique not null comment '用户名',
  password varchar(50) not null comment '登录密码',
  fail_times int(8) default 0 comment '登录密码错误次数',
  user_status varchar(10) not null comment '用户状态，UserStatusEnum',
  create_time timestamp null default null comment '注册时间',
  primary key (id)
) engine=InnoDB auto_increment=10000001 default charset=utf8;

-- ----------------------------------------
-- 用户基础信息表
-- 记录用户的常用查询信息
-- ----------------------------------------
drop table if exists t_user_detail;
create table t_user_detail (
  id int(8) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  cert_type varchar(10) default null comment '证件类型，CertTypeEnum',
  cert_no varchar(50) default null comment '证件号码',
  name varchar(50) default null comment '个人姓名',
  phone varchar(20) default null comment '手机号',
  email varchar(50) default null comment '邮箱',
  alias varchar(50) default null comment '昵称',
  gender varchar(10) default null comment '性别，GenderEnum',
  birth_date timestamp null default null comment '出生日期',
  brief varchar(200) default null comment '用户简介',
  photo varchar(200) default null comment '用户头像',
  marital  varchar(10) default null comment '婚姻状况，MaritalEnum',
  race varchar(10) default null comment '名族，RaceEnum',
  nationality varchar(10) default null comment '国籍，NationalityEnum',
  domicile varchar(200) default null comment '户籍地址',
  primary key (id)
) engine=InnoDB auto_increment=10000001 default charset=utf8;

-- ----------------------------------------
-- 用户登录信息表
-- ----------------------------------------
drop table if exists t_user_login;
create table t_user_login (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  login_time timestamp null default null comment '登录时间',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 用户角色映射表，独立映射是为了支持一对多的情况
-- ----------------------------------------
drop table if exists t_user_role;
create table t_user_role (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  role_type varchar(10) not null comment '角色类型',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 角色信息表
-- ----------------------------------------
drop table if exists t_role_info;
create table t_role_info (
  id int(11) not null auto_increment comment 'ID',
  role_type varchar(10) unique not null comment '角色类型',
  role_name varchar(50) not null comment '角色名称',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 角色服务映射表
-- ----------------------------------------
drop table if exists t_role_server;
create table t_role_server (
  id int(11) not null auto_increment comment 'ID',
  role_type varchar(10) not null comment '角色类型',
  server_id int(11) not null comment '服务ID',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 服务信息表
-- ----------------------------------------
drop table if exists t_server_info;
create table t_server_info (
  id int(11) not null auto_increment comment 'ID',
  server_url varchar(50) unique not null comment '服务地址',
  server_name varchar(50) not null comment '服务名称',
  server_type varchar(10) default null comment '服务类型，ServerTypeEnum',
  biz_type varchar(10) default null comment '业务类型，BizTypeEnum',
  server_mark varchar(10) default null comment '标签，ServerMarkEnum',
  server_status varchar(10) not null comment '服务状态，ServerStatusEnum',
  server_des varchar(200) default null comment '服务描述',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 系统配置表
-- ----------------------------------------
drop table if exists t_config_info;
create table t_config_info (
  id int(11) not null auto_increment comment 'ID',
  config_code varchar(20) unique not null comment '配置code',
  config_name varchar(50) not null comment '配置名称',
  config_value varchar(20) not null comment '配置值',
  config_type varchar(10) default null comment '配置类型，ConfigTypeEnum',
  biz_type varchar(10) default null comment '业务类型，BizTypeEnum',
  config_mark varchar(10) default null comment '标签，ConfigMarkEnum',
  config_status varchar(10)  not null comment '配置状态，ConfigStatusEnum',
  config_des varchar(200) default null comment '配置描述',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 白名单信息表
-- ----------------------------------------
drop table if exists t_white_info;
create table t_white_info (
  id int(11) not null auto_increment comment 'ID',
  white_type varchar(10) not null comment '白名单类型，WhiteTypeEnum',
  white_value varchar(50) not null comment '白名单值',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 操作信息记录表
-- ----------------------------------------
drop table if exists t_opt_record;
create table t_opt_record (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) default null comment '用户ID',
  opt_url varchar(50) not null comment '操作服务地址',
  opt_time timestamp null default null comment '操作时间',
  opt_status varchar(10) not null comment '操作状态，OptStatusEnum',
  opt_ip varchar(20) not null comment '操作人的ip',
  opt_content varchar(200) default null comment '操作内容',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

-- ----------------------------------------
-- 三方账户信息表
-- ----------------------------------------
drop table if exists t_account_outside;
create table t_account_outside (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  rel_account_id int(11) default null comment '关联账号',
  account_no varchar(50) default null comment '三方账号',
  login_password varchar(50) default null comment '登录密码',
  query_password varchar(50) default null comment '查询密码',
  transfer_password varchar(50) default null comment '支付密码',
  account_type varchar(10) default null comment '账号类型，AccountTypeEnum',
  account_mark varchar(10) default null comment '账号标签，AccountMarkEnum',
  product int(11) default null comment '所属产品',
  company int(11) default null comment '所属公司',
  cert_type varchar(10) default null comment '证件类型，CertTypeEnum',
  cert_no varchar(50) default null comment '证件号码',
  name varchar(50) default null comment '个人姓名',
  phone varchar(20) default null comment '手机号',
  email varchar(50) default null comment '邮箱',
  question1 varchar(100) default null comment '安全问题1',
  answer1 varchar(100) default null comment '安全问题答案1',
  question2 varchar(100) default null comment '安全问题2',
  answer2 varchar(100) default null comment '安全问题答案2',
  question3 varchar(100) default null comment '安全问题3',
  answer3 varchar(100) default null comment '安全问题答案3',
  account_used varchar(50) default null comment '用途',
  account_des varchar(200) default null comment '账号描述',
  create_time timestamp null default null comment '创建日期',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;


drop table if exists t_company_info;
create table t_company_info (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  company_name varchar(50) default null comment '公司名称',
  company_des varchar(200) default null comment '公司描述',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;

drop table if exists t_product_info;
create table t_product_info (
  id int(11) not null auto_increment comment 'ID',
  user_id int(8) not null comment '用户ID',
  company_id int(11) default null comment '公司ID',
  product_name varchar(50) default null comment '产品名称',
  product_des varchar(200) default null comment '公司描述',
  primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8;