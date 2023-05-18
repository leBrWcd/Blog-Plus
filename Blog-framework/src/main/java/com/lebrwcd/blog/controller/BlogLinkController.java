package com.lebrwcd.blog.controller;


import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.service.BlogLinkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 友链(BlogLink)表控制层
 *
 * @author makejava
 * @since 2023-05-07 21:18:39
 */
@RestController
@RequestMapping("link")
public class BlogLinkController {

    /**
     * 服务对象
     */
    @Resource
    private BlogLinkService blogLinkService;

    /**
     * 获取所有友链
     * @return
     */
    @GetMapping("/getAllLink")
    public ResponseResult getAllLink() {
        return blogLinkService.getAllLink();
    }


}

