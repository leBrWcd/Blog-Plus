package com.lebrwcd.blog.controller;


import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.service.BlogCategoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分类表(BlogCategory)表控制层
 *
 * @author makejava
 * @since 2023-05-07 15:30:56
 */
@RestController
@Api(tags = "文章分类接口",description = "文章分类接口")
@RequestMapping("category")
public class BlogCategoryController {

    /**
     * 服务对象
     */
    @Resource
    private BlogCategoryService blogCategoryService;


    @GetMapping("/getCategoryList")
    public ResponseResult getCategoryList() {
        return blogCategoryService.getCategoryList();
    }

}

