package com.mc.config;

import com.mc.properties.ThreadPoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenglongchu
 * @description 配置自定义线程池
 * @create 2018/5/28 16:51
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {
	@Autowired
	private ThreadPoolProperties properties;
	
	@Bean(name="taskAsyncPool")
    public Executor taskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(properties.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(properties.getMaxPoolSize());
        // 队列容量
        executor.setQueueCapacity(properties.getQueueCapacity());
        // 线程活跃时间(秒)
        executor.setKeepAliveSeconds(properties.getKeepAliveSeconds());
        // 线程名称前缀
        executor.setThreadNamePrefix(properties.getPrefix());
        // 拒绝策略: CALLER_RUNS, 当pool已经达到max size的时候, 不在新线程中执行任务, 而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
//        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();  
        return executor;  
    }  
}
