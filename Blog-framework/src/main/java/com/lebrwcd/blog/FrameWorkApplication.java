package com.lebrwcd.blog;

/**
 * Description TODO
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/15
 */

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description 博客应用
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@SpringBootApplication
@EnableSwagger2
@Slf4j
@MapperScan("com.lebrwcd.blog.mapper")
public class FrameWorkApplication {

    public static void main(String[] args) {
        log.info("启动中......");
        SpringApplication.run(FrameWorkApplication.class,args);
    }

}
