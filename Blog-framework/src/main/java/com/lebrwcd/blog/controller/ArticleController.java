package com.lebrwcd.blog.controller;

import com.lebrwcd.blog.common.ResponseResult;
import com.lebrwcd.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Description 文章控制器
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
@Api(tags = "文章接口",description = "文章相关接口")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("查询文章详情信息")
    @GetMapping("{id}")
    public ResponseResult getArticle(@PathVariable("id") Long id) {
        return articleService.getArticleDetails(id);
    }

    @ApiOperation("查询热门文章接口")
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticle() {
        return articleService.hotArticle();
    }


    /**
     * 分页查询所有文章列表
     * @return 所有文章
     */
    @GetMapping("/articleList")
    public ResponseResult getArticleList(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam(value = "categoryId",defaultValue = "0") Integer categoryId) {
        return articleService.selectPage(pageNum,pageSize,categoryId);
    }

}
