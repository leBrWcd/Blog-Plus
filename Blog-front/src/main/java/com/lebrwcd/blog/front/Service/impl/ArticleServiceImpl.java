package com.lebrwcd.blog.front.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lebrwcd.blog.front.Service.ArticleService;
import com.lebrwcd.blog.front.entity.model.Article;
import com.lebrwcd.blog.front.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description 文章业务实现类
 *
 * @author lebrwcd
 * @version 1.0
 * @date 2023/5/5
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

}
