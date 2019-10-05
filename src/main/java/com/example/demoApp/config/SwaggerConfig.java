package com.example.demoApp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * User: Edward Tanko <br/>
 * Date: 5/29/19 8:58 PM <br/>
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(metadata())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title(applicationName+" API")
                .description(applicationName+ ": Api Service")
                .version("1.0")
                // .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}