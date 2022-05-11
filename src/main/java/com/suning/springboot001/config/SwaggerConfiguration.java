package com.suning.springboot001.config;

import com.suning.springboot001.entity.SwaggerSelect;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Created：Jeffrey
 * date   ：2022/4/24 20:37
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfoBuilder().title("SpringCloud项目").description("API接口文档").termsOfServiceUrl("https://www.guli.cloud").build();
        docket.apiInfo(apiInfo).select().apis
                (RequestHandlerSelectors.withMethodAnnotation(SwaggerSelect.class)).build(); //不能没有build
        return docket;
    }

}
