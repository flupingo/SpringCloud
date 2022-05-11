package com.suning.springboot001.web.controller;

import com.suning.springboot001.entity.SwaggerSelect;
import com.suning.springboot001.entity.User;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;

/**
 * Created：Jeffrey
 * date   ：2022/4/24 17:28
 */
@Controller
@Slf4j
@Api(tags = "TestSwagger接口")
//@RefreshScope
public class TestSwagger {

    @Value("${test.user.name}")
    private String name;

    @Value("${test.user.age}")
    private int age;

    @Resource
    User user;

    @GetMapping("/get")
    @SwaggerSelect
    @ApiIgnore //不生成接口文档
    public void test001(String name, @RequestBody RequestVo requestVo) {

        log.info("test001接口:{}", name);
        log.info("test001接口:{}", requestVo);
    }

    @ApiOperation("测试post请求接口")
    @SwaggerSelect
    @PostMapping("/post")
    public ResponseVo test002(@ApiParam(value = "姓名", required = true) String name, @ApiParam(value = "传对象") @RequestBody ResponseVo requestVo) {

        log.info("test001接口:{}", name);
        log.info("test001接口:{}", requestVo);
        return requestVo;
    }

    @RequestMapping("/testNacos")
    @ResponseBody
    public User testRefresh() {
        log.info(age+"");
        log.info(name);
        return user;
    }


    @AllArgsConstructor
    @Data
    public static class RequestVo {
        private String color;
        private int age;

    }

    @Builder
//    @AllArgsConstructor
    @Data
    @ApiModel(description = "返回对象ResponseVo")
    public static class ResponseVo {
        @ApiModelProperty(value = "姓名", required = true, example = "张三")
        private String name;

        @ApiModelProperty(value = "年龄", example = "12")
        private int age;
    }

}
