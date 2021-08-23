package com.root2z.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/** @author root2z */
@Configuration
public class RedisConfig {

  /**
   * 注入RedisTemplate 到容器中，提供复杂对象操作
   *
   * @param redisConnectionFactory Redis连接工厂
   * @return redisTemplate
   */
  @Bean
  public RedisTemplate<String, Object> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    // 配置redisTemplate
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    // 设置序列化
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer =
        new Jackson2JsonRedisSerializer<>(Object.class);
    ObjectMapper om = new ObjectMapper();

    // 使用getter访问访问全部属性，自动检测可见设置为任意
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

    om.activateDefaultTyping(
        LaissezFaireSubTypeValidator.instance,
        ObjectMapper.DefaultTyping.NON_FINAL,
        JsonTypeInfo.As.PROPERTY);

    // 设置对象映射
    jackson2JsonRedisSerializer.setObjectMapper(om);

    // key序列化
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    // value序列化
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    // Hash key序列化
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    // Hash value序列化
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  /** 配置Redis连接工厂 */
  @Bean
  RedisConnectionFactory redisConnectionFactory(RedisProperties properties) {
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
    config.setPassword(properties.getPassword());
    return new LettuceConnectionFactory(config);
  }

  /**
   * 注入StringRedisTemplate到容器中，key-value 均为字符串
   *
   * @param redisConnectionFactory redis连接工厂
   * @return 返回StringRedisTemplate
   */
  @Bean
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
    stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
    return stringRedisTemplate;
  }
}
