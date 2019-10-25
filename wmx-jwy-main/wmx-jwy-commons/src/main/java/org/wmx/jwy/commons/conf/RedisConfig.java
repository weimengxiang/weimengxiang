package org.wmx.jwy.commons.conf;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @weimengxiang
 * 
 * redis 配置类
 * 
 */
@Component
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	
	private static final Logger LOG = LogManager.getLogger(RedisConfig.class);
    /**
    * 自定义redis key值生成策略
    */
    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }
    
    @SuppressWarnings("unchecked")
	@Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
      om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
      //redis序列化
      @SuppressWarnings("rawtypes")
	  Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
      jackson2JsonRedisSerializer.setObjectMapper(om);
      StringRedisTemplate template = new StringRedisTemplate(factory);
      template.setValueSerializer(jackson2JsonRedisSerializer);
      template.afterPropertiesSet();
      return template;
    }

    /**
    * 自定义CacheManager
    */
    @SuppressWarnings("rawtypes")
	@Bean
     public CacheManager cacheManager(RedisTemplate redisTemplate) {
         //全局redis缓存过期时间
         RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1));  
         RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }
}

/*@Configuration
public class Rediconfig extends CachingConfigurerSupport {

    
     * 定义缓存数据 key 生成策略的bean 包名+类名+方法名+所有参数
     
     @Bean
     public KeyGenerator wiselyKeyGenerator(){
     return new KeyGenerator() {
     @Override
     public Object generate(Object target, Method method, Object... params) {
     StringBuilder sb = new StringBuilder();
     sb.append(target.getClass().getName());
     sb.append(method.getName());
     for (Object obj : params) {
     sb.append(obj.toString());
     }
     return sb.toString();
     }
     };
    
     }

    
     * 要启用spring缓存支持,需创建一个 CacheManager的 bean，CacheManager 接口有很多实现，这里Redis 的集成，用
     * RedisCacheManager这个实现类 Redis 不是应用的共享内存，它只是一个内存服务器，就像 MySql 似的，
     * 我们需要将应用连接到它并使用某种“语言”进行交互，因此我们还需要一个连接工厂以及一个 Spring 和 Redis 对话要用的
     * RedisTemplate， 这些都是 Redis 缓存所必需的配置，把它们都放在自定义的 CachingConfigurerSupport 中
     
    @Bean
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        // cacheManager.setDefaultExpiration(60);//设置缓存保留时间（seconds）
        return cacheManager;
    }

    // 1.项目启动时此方法先被注册成bean被spring管理,如果没有这个bean，则redis可视化工具中的中文内容（key或者value）都会以二进制存储，不易检查。
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}*/