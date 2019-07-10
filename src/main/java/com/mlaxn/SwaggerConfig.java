package com.mlaxn;

import java.util.Collections;

//for Swagger Configuration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//for Docket Bean
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

//For APIinfo
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    //displays the custom API information in the Swagger Document
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Demo Spring Boot Rest API",
                "This project used IntelliJ, Gradle build tool Swagger UI, Slf4j with Log4j2 using lumbock plugin and JDBC template    ",
                "Sysco-Houston-version 0.00",
                "Terms of service",
                new Contact("Milan Biswakarma", "www.sysco.com/milan.biswakarma", "mlaxnzzz@sysco.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
