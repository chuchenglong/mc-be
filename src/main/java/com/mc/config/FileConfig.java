package com.mc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * @author ChenglongChu
 * @description 文件上传下载配置
 * @create 2018/06/15 18:56
 */
@Configuration
public class FileConfig {

    /**
     * @description 文件上传请求配置
     * @param maxFileSize 单个文件最大
     * @param maxRequestSize 总上传数据总大小
     * @author ChenglongChu
     * @create 2018/6/15 18:58
    **/
    @Bean
    public MultipartConfigElement multipartConfigElement(@Value("${multipart.maxFileSize}") String maxFileSize, @Value("${multipart.maxRequestSize}") String maxRequestSize) {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个文件最大
        factory.setMaxFileSize(maxFileSize);
        // 设置总上传数据总大小
        factory.setMaxRequestSize(maxRequestSize);
        return factory.createMultipartConfig();
    }
}
