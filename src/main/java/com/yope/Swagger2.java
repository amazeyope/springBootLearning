package com.yope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yope
 * @version 1.0.0
 * @date 16/08/27 02:34.
 * @github https://github.com/amazeyope
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()//选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.yope.web")) // 对指定包下的api进行监控
                .paths(PathSelectors.any())// 对所有路径进行监控
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("关于Swagger2更多的描述请访问官方:http://swagger.io/")
                .termsOfServiceUrl("https://github.com/amazeyope")
                .contact("yope")
                .version("1.0.0")
                .build();
    }

}
