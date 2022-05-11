package com.suning.springboot001.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created：Jeffrey
 * date   ：2022/4/30 11:15
 */
@Configuration
public class RedissonConfig {
    @Value("${spring.redis.host}")
    private String redisHost;

    @Bean
    RedissonClient buildRedisson() {
        //1、创建配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + redisHost + ":6379");

        //2、根据Config创建出RedissonClient实例
        //Redis url should start with redis:// or rediss://
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }


}
