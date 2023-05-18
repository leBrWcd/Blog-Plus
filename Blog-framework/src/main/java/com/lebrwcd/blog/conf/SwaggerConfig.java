package com.lebrwcd.blog.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Description Swagger2文档配置
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/7
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blog.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("LeBrWcd", "https://github.com/leBrWcd", "1327923760@qq.com");
        return new ApiInfoBuilder()
                .title("博客前台")
                .description("文档描述")
                .contact(contact)   // 联系方式
                .version("v1.0")  // 版本
                .build();
    }
}
