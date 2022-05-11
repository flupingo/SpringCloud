package com.suning.springboot001.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created：Jeffrey
 * date   ：2022/4/30 15:35
 */
@ConfigurationProperties(prefix = "springcloud.threadpool")
@Data
public class ThreadPoolProperty {
    private int core;
    private int max;
    private int keepaliveTime;

}
