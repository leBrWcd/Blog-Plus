package com.lebrwcd.blog.front.controller;

import com.lebrwcd.blog.front.Service.ArticleService;
import com.lebrwcd.blog.front.entity.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description 文章控制器
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询所有文章列表
     * @return 所有文章
     * TODO:简单做一下测试，后续增加业务逻辑
     */
    @GetMapping("/list")
    public List<Article> getArticleList() {
        List<Article> list = articleService.list();
        if (list != null) {
            return list;
        }
        return null;
    }

}
