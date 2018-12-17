package com.mc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author ChenglongChu
 * @description redis配置及操作
 * @create 2018/06/27 16:08
 */
@Configuration
//@EnableCaching
//@ConditionalOnProperty(prefix = "spring.redis", name = "enable", matchIfMissing = false)
public class RedisConfig {
    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    /**
     * @description 实例化 RedisTemplate 对象
     * @author ChenglongChu
     * @create 2018/6/27 16:53
    **/
    @Bean
    public RedisTemplate<String, Object> functionDomainRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * @description 设置数据存入 redis 的序列化方式
     * @author ChenglongChu
     * @create 2018/6/27 16:54
    **/
    private void initDomainRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * @description 实例化 HashOperations 对象,可以使用 Hash 类型操作
     * @author ChenglongChu
     * @create 2018/6/27 16:54
    **/
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    /**
     * @description 实例化 ValueOperations 对象,可以使用 String 操作
     * @author ChenglongChu
     * @create 2018/6/27 16:54
    **/
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    /**
     * @description 实例化 ListOperations 对象,可以使用 List 操作
     * @author ChenglongChu
     * @create 2018/6/27 16:55
    **/
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    /**
     * @description 实例化 SetOperations 对象,可以使用 Set 操作
     * @author ChenglongChu
     * @create 2018/6/27 16:55
    **/
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    /**
     * @description 实例化 ZSetOperations 对象,可以使用 ZSet 操作
     * @author ChenglongChu
     * @create 2018/6/27 16:55
    **/
    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }
}
