package com.mc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ChenglongChu
 * @description Mybatis依赖加入和相关配置信息
 * @create 2018/5/28 16:50
 */
@Configuration
@MapperScan(basePackages = "com.mc.mapper", sqlSessionFactoryRef = "sqlSessionFactory", sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybatisConfig {
}
