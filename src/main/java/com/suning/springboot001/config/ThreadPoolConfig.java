package com.suning.springboot001.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created：Jeffrey
 * date   ：2022/4/30 15:32
 */
@Configuration
@EnableConfigurationProperties(ThreadPoolProperty.class)
public class ThreadPoolConfig {
    @Bean
    ThreadPoolExecutor threadPool(ThreadPoolProperty threadPoolProperty) {
        return new ThreadPoolExecutor(threadPoolProperty.getCore(),
                threadPoolProperty.getMax(),
                threadPoolProperty.getKeepaliveTime(), TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000), new ThreadPoolExecutor.AbortPolicy());
    }

}
