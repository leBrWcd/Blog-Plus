package com.lebrwcd.blog.front;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description 博客前台
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan("com.lebrwcd.blog.front.mapper")
public class FrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class,args);
    }

}
