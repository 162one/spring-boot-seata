package com.seata.config;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

/**
 * @author wz
 * @company tongyun
 * @create 2022-01-26-10:52
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String title;

    private String version = "1.0";

    @Bean
    public Docket createRestApi() {
        // 配置OAS 3.0协议
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 查找有@Tag注解的类，并生成一个对应的分组；类下面的所有http请求方法，都会生成对应的API接口
                // 通过这个配置，就可以将那些没有添加@Tag注解的控制器类排除掉
                .apis(RequestHandlerSelectors.withClassAnnotation(Tag.class))
                .paths(PathSelectors.any())
                .build()
                //添加token验证
//                .securitySchemes(Arrays.asList(tokenScheme()))
//                .securityContexts(Arrays.asList(tokenContext()))
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(title + "服务")
                .termsOfServiceUrl("https://swagger.io/")
                .contact(new Contact("WangZhen", "https://swagger.io/", "961751713@qq.com"))
                .version(version)
                .build();
    }

//    private HttpAuthenticationScheme tokenScheme() {
//        return HttpAuthenticationScheme.JWT_BEARER_BUILDER.name("Authorization").build();
//    }
//
//    private SecurityContext tokenContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(SecurityReference.builder()
//                        .scopes(new AuthorizationScope[0])
//                        .reference("Authorization")
//                        .build()))
//                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
//                .build();
//    }
}
