package com.suning.springboot001;

import com.alibaba.fastjson.JSON;
import com.suning.springboot001.entity.Cinema;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableSwagger2 //扫描
@EnableAspectJAutoProxy
public class Springboot001Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot001Application.class, args);

        System.out.println("==");
    }

}
