package com.example.mentoring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(this.metaInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.mentoring.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("todoList API Docs")
                .description("api docs")
                .contact("Content")
                .version("1.0.0")
                .termsOfServiceUrl("Terms of Service url")
                .license("License")
                .licenseUrl("License URL")
                .build();
    }
}
