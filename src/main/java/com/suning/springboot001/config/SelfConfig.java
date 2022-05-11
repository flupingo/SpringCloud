package com.suning.springboot001.config;

import com.suning.springboot001.entity.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created：Jeffrey
 * date   ：2022/5/6 20:54
 */
@Configuration
@EnableConfigurationProperties(value = {User.class})
public class SelfConfig {




}
